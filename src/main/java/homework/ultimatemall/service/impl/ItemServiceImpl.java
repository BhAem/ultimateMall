package homework.ultimatemall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import homework.ultimatemall.dao.ItemDao;
import homework.ultimatemall.entity.Item;
import homework.ultimatemall.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Item)表服务实现类
 *
 * @author makejava
 * @since 2022-12-04 21:50:24
 */
@Service("itemService")
public class ItemServiceImpl extends ServiceImpl<ItemDao, Item> implements ItemService {

    @Override
    public void updateSellNum(Long itemId, Integer itemNum) {
        Item item = this.getById(itemId);
        item.setItemSell(item.getItemSell() + itemNum);
        this.updateById(item);
    }

    @Override
    public List<Item> queryAll() {
        return this.list();
    }

    @Override
    public List<Item> queryByKind(String kind) {
        LambdaQueryWrapper<Item> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Item::getItemKind, kind);
        return this.list(wrapper);
    }

    @Override
    public int countByKind(String kind) {
        LambdaQueryWrapper<Item> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Item::getItemKind, kind);
        return (int) this.count(wrapper);
    }

}

