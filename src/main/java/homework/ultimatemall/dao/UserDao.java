package homework.ultimatemall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import homework.ultimatemall.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-04 21:47:30
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

