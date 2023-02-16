/**
 * @Author: Neo
 * @Date: 2022/12/05 星期一 21:39:31
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import homework.ultimatemall.common.BaseContext;
import homework.ultimatemall.common.R;
import homework.ultimatemall.entity.Address;
import homework.ultimatemall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{addressId}")
    public R<Address> get(@PathVariable Long addressId) {
        return R.success(addressService.getById(addressId));
    }

    @GetMapping("/list")
    public R<List<Address>> getList() {
        LambdaQueryWrapper<Address> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Address::getUserId, BaseContext.getCurrentId());
        return R.success(addressService.list(queryWrapper));
    }

    @PostMapping("/add")
    public R<String> add(@RequestBody Address address) {
        address.setUserId(BaseContext.getCurrentId());
        addressService.save(address);
        return R.success("添加成功");
    }

    @PutMapping
    public R<String> update(@RequestBody Address address) {
        addressService.updateById(address);
        return R.success("更新成功");
    }

    @DeleteMapping("/{addressId}")
    public R<String> delete(@PathVariable Long addressId) {
        addressService.removeById(addressId);
        return R.success("删除成功");
    }

}
