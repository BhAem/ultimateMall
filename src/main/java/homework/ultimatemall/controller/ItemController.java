/**
 * @Author: Neo
 * @Date: 2022/12/04 星期日 23:05:41
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import homework.ultimatemall.common.R;
import homework.ultimatemall.dto.ItemQueryDto;
import homework.ultimatemall.entity.Item;
import homework.ultimatemall.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public R<String> add(@RequestBody Item item) {
        itemService.save(item);
        return R.success("添加成功");
    }

    @PutMapping
    public R<String> update(@RequestBody Item item) {
        itemService.updateById(item);
        return R.success("修改成功");
    }

    @DeleteMapping("/{id}")
    public R<String> delete(@PathVariable Long id) {
        itemService.removeById(id);
        return R.success("删除成功");
    }

    @PutMapping("/{id}")
    public R<String> updataStatus(@PathVariable Long id) {
        Item item = itemService.getById(id);
        item.setItemState(item.getItemState() ^ 1);
        itemService.updateById(item);
        return R.success("修改成功");
    }

    @PutMapping("/update")
    public R<String> updateStatusByIds(@RequestParam List<Long> ids) {
        List<Item> items = ids.stream().map(id -> {
            Item item = itemService.getById(id);
            item.setItemState(item.getItemState() ^ 1);
            return item;
        }).collect(Collectors.toList());
        itemService.updateBatchById(items);
        return R.success("修改成功");
    }

    @GetMapping("/{id}")
    public R<Item> getItemById(@PathVariable Long id) {
        return R.success(itemService.getById(id));
    }


    @PostMapping("/list")
    public R<List<Item>> getItemListByCondition(@RequestBody ItemQueryDto query) {
        log.info("query:{}", query);
        LambdaQueryWrapper<Item> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(query.getItemName()), Item::getItemName, query.getItemName());
        queryWrapper.eq(StringUtils.hasText(query.getItemKind()), Item::getItemKind, query.getItemKind());
        queryWrapper.eq(query.getItemState() != null, Item::getItemState, query.getItemState());
        if (query.getMaxPrice() != null && query.getMinPrice() != null) {
            queryWrapper.between(Item::getItemPrice, query.getMinPrice(), query.getMaxPrice());
        } else if (query.getMaxPrice() != null) {
            queryWrapper.le(Item::getItemPrice, query.getMaxPrice());
        } else if (query.getMinPrice() != null) {
            queryWrapper.ge(Item::getItemPrice, query.getMinPrice());
        }
        return R.success(itemService.list(queryWrapper));
    }

    @GetMapping("/list")
    public R<List<Item>> getItemList() {
        return R.success(itemService.list());
    }
}
