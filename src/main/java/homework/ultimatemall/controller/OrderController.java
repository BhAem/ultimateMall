/**
 * @Author: Neo
 * @Date: 2022/12/05 星期一 17:01:45
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import homework.ultimatemall.common.BaseContext;
import homework.ultimatemall.common.R;
import homework.ultimatemall.dto.OrderDto;
import homework.ultimatemall.entity.Item;
import homework.ultimatemall.entity.Order;
import homework.ultimatemall.entity.OrderDetail;
import homework.ultimatemall.service.ItemService;
import homework.ultimatemall.service.OrderDetailService;
import homework.ultimatemall.service.OrderService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public R<String> add(@RequestBody OrderDto orderDto) {
        Long userId = BaseContext.getCurrentId();
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderAmount(orderDto.getAmount());
        order.setAddressId(orderDto.getAddressId());
        order.setOrderState(0);
        order.setOrderTime(LocalDateTime.now());
        orderService.save(order);
        orderDto.getItems().forEach(item -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setItemId(item.getItemId());
            orderDetail.setItemNum(item.getItemNum());
            orderDetailService.save(orderDetail);
        });
        return R.success("添加成功");
    }

    @PostMapping("/list")
    public R<List<OrderDto>> getOrderListByCondition(@RequestBody Order order) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(order.getOrderId() != null, Order::getOrderId, order.getOrderId());
        queryWrapper.eq(order.getUserId() != null, Order::getUserId, order.getUserId());
        queryWrapper.eq(order.getOrderState() != null, Order::getOrderState, order.getOrderState());
        return getList(queryWrapper);
    }


    @GetMapping("/list")
    public R<List<OrderDto>> getOrderListByUserId() {
        Long userId = BaseContext.getCurrentId();
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getUserId, userId);
        queryWrapper.orderByDesc(Order::getOrderTime);
        return getList(queryWrapper);
    }


    @Transactional
    @DeleteMapping("/{orderId}")
    public R<String> delete(@PathVariable("orderId") Long id) {
        orderService.removeById(id);
        orderDetailService.remove(new LambdaQueryWrapper<OrderDetail>().eq(OrderDetail::getOrderId, id));
        return R.success("删除成功");
    }

    @Transactional
    @PutMapping("/{orderId}/{newState}")
    public R<String> update(@PathVariable("orderId") Long orderId, @PathVariable("newState") Integer newState) {
        LambdaUpdateWrapper<Order> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Order::getOrderId, orderId);
        updateWrapper.set(Order::getOrderState, newState);
        orderService.update(updateWrapper);
        if (newState == 3) {
            LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(OrderDetail::getOrderId, orderId);
            for (OrderDetail orderDetail : orderDetailService.list(queryWrapper)) {
                itemService.updateSellNum(orderDetail.getItemId(), orderDetail.getItemNum());
            }
        }
        return R.success("更新成功");
    }

    @NotNull
    private R<List<OrderDto>> getList(LambdaQueryWrapper<Order> queryWrapper) {
        List<OrderDto> orderDtoList = orderService.list(queryWrapper).stream().map(obj -> {
            Long orderId = obj.getOrderId();
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderId(orderId);
            orderDto.setAddressId(obj.getAddressId());
            orderDto.setAmount(obj.getOrderAmount());
            orderDto.setOrderTime(obj.getOrderTime());
            orderDto.setOrderState(obj.getOrderState());

            LambdaQueryWrapper<OrderDetail> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(OrderDetail::getOrderId, orderId);
            List<Item> items = orderDetailService.list(wrapper).stream().map(detail -> {
                Long itemId = detail.getItemId();
                Item item = itemService.getById(itemId);
                item.setItemNum(detail.getItemNum());
                return item;
            }).collect(Collectors.toList());

            orderDto.setItems(items);
            return orderDto;
        }).collect(Collectors.toList());
        return R.success(orderDtoList);
    }

}
