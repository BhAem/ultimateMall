package homework.ultimatemall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import homework.ultimatemall.dao.OrderDetailDao;
import homework.ultimatemall.entity.OrderDetail;
import homework.ultimatemall.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * (OrderDetail)表服务实现类
 *
 * @author makejava
 * @since 2022-12-05 17:17:18
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailDao, OrderDetail> implements OrderDetailService {

}

