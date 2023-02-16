package homework.ultimatemall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * (Order)表实体类
 *
 * @author makejava
 * @since 2022-12-06 15:31:24
 */
@Data
@TableName("orders")
public class Order {

    @TableId(type = IdType.ASSIGN_ID)
    private Long orderId;

    private Long userId;

    private Long addressId;

    private BigDecimal orderAmount;

    private Integer orderState;

    private LocalDateTime orderTime;

}

