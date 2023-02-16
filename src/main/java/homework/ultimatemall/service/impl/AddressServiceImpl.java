package homework.ultimatemall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import homework.ultimatemall.dao.AddressDao;
import homework.ultimatemall.entity.Address;
import homework.ultimatemall.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2022-12-04 22:12:34
 */
@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, Address> implements AddressService {

}

