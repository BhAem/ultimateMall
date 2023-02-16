package homework.ultimatemall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (Address)表实体类
 *
 * @author makejava
 * @since 2022-12-04 22:12:34
 */
@SuppressWarnings("serial")
@Data
public class Address extends Model<Address> {
    @TableId(type = IdType.ASSIGN_ID)
    private Long addressId;

    private Long userId;

    private String userAddress;

    private String userName;

    private String phone;

    private String label;

    private Integer isDefault;

}

