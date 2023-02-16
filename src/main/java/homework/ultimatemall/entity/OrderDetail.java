package homework.ultimatemall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * (OrderDetail)表实体类
 *
 * @author makejava
 * @since 2022-12-05 17:17:18
 */
@SuppressWarnings("serial")
@Data
public class OrderDetail extends Model<OrderDetail> {

    private Long itemId;

    private Integer itemNum;

    private Long orderId;
}

