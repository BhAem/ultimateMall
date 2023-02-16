/**
 * @Author: Neo
 * @Date: 2022/12/05 星期一 11:06:35
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import homework.ultimatemall.common.R;
import homework.ultimatemall.entity.Kind;
import homework.ultimatemall.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kind")
public class KindController {
    @Autowired
    private KindService kindService;

    @GetMapping("/list")
    public R<List<Kind>> getItemList() {
        return R.success(kindService.list());
    }

    @GetMapping("/{kindName}")
    public R<String> add(@PathVariable String kindName) {
        Kind kind = new Kind();
        kind.setItemKind(kindName);
        kindService.save(kind);
        return R.success("添加成功");
    }

    @DeleteMapping("/{kindName}")
    public R<String> delete(@PathVariable String kindName) {
        LambdaQueryWrapper<Kind> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Kind::getItemKind, kindName);
        kindService.remove(queryWrapper);
        return R.success("删除成功");
    }

    @PutMapping("/{oldName}/{newName}")
    public R<String> update(@PathVariable String oldName, @PathVariable String newName) {
        LambdaUpdateWrapper<Kind> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Kind::getItemKind, newName);
        updateWrapper.eq(Kind::getItemKind, oldName);
        kindService.update(updateWrapper);
        return R.success("修改成功");
    }
}
