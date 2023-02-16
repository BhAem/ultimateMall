package homework.ultimatemall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import homework.ultimatemall.entity.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-04 22:12:33
 */
@Mapper
public interface AddressDao extends BaseMapper<Address> {

}

