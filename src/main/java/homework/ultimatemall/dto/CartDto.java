/**
 * @Author: Neo
 * @Date: 2022/12/05 星期一 16:37:21
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.dto;

import homework.ultimatemall.entity.Item;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDto {
    private List<Item> items;
    private BigDecimal amount;
}
