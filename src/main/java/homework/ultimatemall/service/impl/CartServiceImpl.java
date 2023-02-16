package homework.ultimatemall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import homework.ultimatemall.dao.CartDao;
import homework.ultimatemall.entity.Cart;
import homework.ultimatemall.service.CartService;
import org.springframework.stereotype.Service;

/**
 * (Cart)表服务实现类
 *
 * @author makejava
 * @since 2022-12-04 22:12:34
 */
@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, Cart> implements CartService {

}

