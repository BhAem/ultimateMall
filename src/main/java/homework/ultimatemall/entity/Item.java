package homework.ultimatemall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * (Item)表实体类
 *
 * @author makejava
 * @since 2022-12-04 21:50:24
 */
@SuppressWarnings("serial")
@Data
public class Item extends Model<Item> {

    @TableId(type = IdType.ASSIGN_ID)
    private Long itemId;

    private String itemName;

    private BigDecimal itemPrice;

    private String itemKind;

    private String itemUrl;

    private Integer itemNum;

    private Integer itemSell;

    private String itemDescription;

    private Integer itemState;
}

