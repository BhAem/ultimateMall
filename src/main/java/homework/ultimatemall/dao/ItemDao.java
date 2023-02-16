package homework.ultimatemall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import homework.ultimatemall.entity.Item;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Item)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-04 21:50:23
 */
@Mapper
public interface ItemDao extends BaseMapper<Item> {

}

