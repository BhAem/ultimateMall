package homework.ultimatemall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import homework.ultimatemall.entity.Item;

import java.util.List;

/**
 * (Item)表服务接口
 *
 * @author makejava
 * @since 2022-12-04 21:50:24
 */
public interface ItemService extends IService<Item> {

    void updateSellNum(Long itemId, Integer itemNum);

    List<Item> queryAll();

    List<Item> queryByKind(String kind);

    int countByKind(String kind);
}

