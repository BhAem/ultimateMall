package homework.ultimatemall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import homework.ultimatemall.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Order)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-06 15:31:17
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {

}

