package homework.ultimatemall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import homework.ultimatemall.dao.KindDao;
import homework.ultimatemall.entity.Kind;
import homework.ultimatemall.service.KindService;
import org.springframework.stereotype.Service;

/**
 * (Kind)表服务实现类
 *
 * @author makejava
 * @since 2022-12-04 22:12:34
 */
@Service("kindService")
public class KindServiceImpl extends ServiceImpl<KindDao, Kind> implements KindService {

}

