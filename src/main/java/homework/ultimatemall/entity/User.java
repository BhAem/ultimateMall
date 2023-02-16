package homework.ultimatemall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2022-12-04 21:47:30
 */
@SuppressWarnings("serial")
@Data
public class User extends Model<User> {
    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;

    private String userName;

    private String userPassword;

    private String userMail;

    private Integer userKind;


}

