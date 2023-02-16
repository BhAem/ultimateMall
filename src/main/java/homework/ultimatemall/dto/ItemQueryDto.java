/**
 * @Author: Neo
 * @Date: 2022/12/05 星期一 15:16:18
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.dto;

import homework.ultimatemall.entity.Item;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemQueryDto extends Item {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
