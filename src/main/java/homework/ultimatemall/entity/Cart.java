package homework.ultimatemall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (Cart)表实体类
 *
 * @author makejava
 * @since 2022-12-04 22:12:34
 */
@SuppressWarnings("serial")
@Data
public class Cart extends Model<Cart> {

    private Long UserId;

    private Long itemId;

    private Integer itemNum;

}

