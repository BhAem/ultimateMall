package homework.ultimatemall.dto;
import java.util.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaleListDto {
	/**
     * 图表的标题
     */
    private String title = "销售榜单";

    /**
     * 每一项的标题
     */
    private List<String> legend;

    /**
     * 每一项的具体数据
     */
    private List<Integer> data;
}
