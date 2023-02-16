package homework.ultimatemall.controller;

import homework.ultimatemall.common.R;
import homework.ultimatemall.dto.SaleListDto;
import homework.ultimatemall.entity.Item;
import homework.ultimatemall.entity.Kind;
import homework.ultimatemall.service.ItemService;
import homework.ultimatemall.service.KindService;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SaleListController {
    //报表的路径
    String returnName = "saleList.xlsx";
    @Autowired
    private ItemService itemService;
    @Autowired
    private KindService kindService;

    @GetMapping("/saleList/echarts")
    private R<SaleListDto> getEcharts() {
        List<Kind> kind = kindService.list();
        List<String> kindLegend = new ArrayList<>();
        List<Integer> kindData = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < kind.size(); i++) {
            //获取商品种类
            String kindStr = kind.get(i).getItemKind();
            kindLegend.add(kindStr);
            //获取对应种类的商品
            List<Item> items = itemService.queryByKind(kindStr);
            //计算每种商品的销量
            sum = 0;
            for (int j = 0; j < items.size(); j++)
                if (items.get(j).getItemSell() != null)
                    sum += items.get(j).getItemSell();
            kindData.add(sum);
        }
        System.out.println(kindData);
        System.out.println(kindLegend);
        SaleListDto saleListDto = SaleListDto.builder()
                .title("销售榜单")
                .legend(kindLegend)
                .data(kindData)
                .build();

        return R.success(saleListDto);
    }

    @GetMapping("/saleList/poi")
    public void getPOI(HttpServletResponse response) throws Exception {
        //1、创建一个excel文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        List<Item> itemList = itemService.queryAll();
        //2、创建一个工作表，参数就是表名
        XSSFSheet sheet = workbook.createSheet("ultimateMall销售榜单");
        //3、添加标题
        XSSFRow row = sheet.createRow(0);
        //设置行高
        row.setHeightInPoints(40);
        XSSFCell cell;
        //报表的每列的标题
        String[] titles = {"商品名称", "商品价格", "商品种类", "商品库存量", "商品销售量", "商品描述", "商品状态"};
        //商品的状态数组
        String[] states = {"已上架", "已下架"};
        Item item;
        for (int i = 0; i < titles.length; i++) {

            sheet.setColumnWidth(i, i == 5 ? 15000 : 5000); //固定列宽
            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(setLegendStyle(workbook));
        }

        for (int i = 0; i < itemList.size(); i++) {
            row = sheet.createRow(i + 1);
            item = itemList.get(i);
            String[] content = {item.getItemName(), String.valueOf(item.getItemPrice()), item.getItemKind(),
                    String.valueOf(item.getItemNum()), String.valueOf(item.getItemSell()), item.getItemDescription(),
                    states[item.getItemState()]};

            //4、填写每一行商品数据。
            for (int j = 0; j < titles.length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(content[j]);
            }
        }
        response.setContentType("application/octet-stream;charset=UTF-8");
        returnName = URLEncoder.encode(returnName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + returnName);
        //5、把这个excel表输出到本地磁盘
        //workbook.write(new FileOutputStream(path));
        workbook.write(response.getOutputStream());
        //6、关闭io流
        workbook.close();
    }

    //设置列宽自适应
    public void setAutoColumn(XSSFSheet sheet, int columnIndex) {
        sheet.autoSizeColumn(columnIndex);
        int width = sheet.getColumnWidth(columnIndex) * 7 / 4;
        sheet.setColumnWidth(columnIndex, width);
    }

    //样式设计api

    //添加边界
    public XSSFCellStyle setBorder(XSSFCellStyle cellStyle) {
        cellStyle.setBorderTop(BorderStyle.THIN);//设置上边框
        cellStyle.setBorderBottom(BorderStyle.THIN);//设置下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//设置左边框
        cellStyle.setBorderRight(BorderStyle.THIN);//设置右边框
        return cellStyle;
    }

    //设置字体
    public XSSFCellStyle setFont(XSSFWorkbook workbook, XSSFCellStyle cellStyle, String fontStyle, int fontSize, boolean isBold, boolean isRed) {
        XSSFFont font = workbook.createFont();
        font.setFontName(fontStyle);//设置字体
        font.setFontHeightInPoints((short) fontSize);//设置字号
        font.setBold(isBold);//加粗    
        if (isRed)
            font.setColor(HSSFFont.COLOR_RED);
        cellStyle.setFont(font);
        return cellStyle;
    }

    //设置居中
    public XSSFCellStyle setAlign(XSSFCellStyle cellStyle) {
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        return cellStyle;
    }

    //设置背景颜色
    public XSSFCellStyle setBackgroundColor(XSSFCellStyle cellStyle) {
        cellStyle.setFillForegroundColor(IndexedColors.LIME.getIndex());//indexedcolors为枚举类型，定义很多颜色
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return cellStyle;
    }

    //设置表格标题样式
    public CellStyle setLegendStyle(XSSFWorkbook workbook) {
        //样式处理
        //创建样式对象
        XSSFCellStyle cellStyle = workbook.createCellStyle();

        //添加边界
        cellStyle = setBorder(cellStyle);

        //创建字体对象
        cellStyle = setFont(workbook, cellStyle, "黑体", 20, true, true);

        //设置背景颜色
        cellStyle = setBackgroundColor(cellStyle);

        //居中显示
        cellStyle = setAlign(cellStyle);

        return cellStyle;
    }
}
