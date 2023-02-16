package homework.ultimatemall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import homework.ultimatemall.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * (OrderDetail)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-05 17:17:18
 */
@Mapper
public interface OrderDetailDao extends BaseMapper<OrderDetail> {

}

