package homework.ultimatemall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import homework.ultimatemall.dao.OrderDao;
import homework.ultimatemall.entity.Order;
import homework.ultimatemall.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2022-12-04 21:49:53
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}

