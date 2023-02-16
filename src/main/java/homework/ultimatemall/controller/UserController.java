/**
 * @Author: Neo
 * @Date: 2022/12/04 星期日 22:15:15
 * @Project: javaweb_homework
 * @IDE: IntelliJ IDEA
 **/
package homework.ultimatemall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import homework.ultimatemall.common.R;
import homework.ultimatemall.entity.User;
import homework.ultimatemall.service.SendMailService;
import homework.ultimatemall.service.UserService;
import homework.ultimatemall.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userservice;

    @Autowired
    private SendMailService sendMailService;

    @PostMapping("/sendMail")
    public R<String> sendMail(@RequestBody User user, HttpSession session) {
        String email = user.getUserMail();
        log.info(email);
        if (StringUtils.hasText(email)) {
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("验证码{}", code);
            session.setAttribute(email, code);
            sendMailService.sendLoginCode(email, code);
            return R.success(code);
        }
        return R.error("验证码发送失败");
    }

    @PostMapping("/regist")
    public R<User> Regist(@RequestBody User user, HttpSession session) {

        userservice.save(user);
        session.setAttribute("user", user);
        return R.success(user);
    }

    @PostMapping("/loginByMail")
    public R<User> loginByMail(@RequestBody Map map, HttpSession session) {
        String email = map.get("email").toString();
        String code = map.get("code").toString();
        String sessionCode = (String) session.getAttribute(email);
        if (StringUtils.hasText(code) && code.equals(sessionCode)) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getUserMail, email);
            User user = userservice.getOne(queryWrapper);
            if (user != null) {
                return R.error("用户不存在");
            }
            session.setAttribute("user", user);
            return R.success(user);
        }
        return R.error("验证码错误");
    }

    @PostMapping("/loginByPassword")
    public R<User> loginByPassword(@RequestBody User user, HttpSession session) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserPassword, user.getUserPassword());
        queryWrapper.eq(User::getUserName, user.getUserName());
        User one = userservice.getOne(queryWrapper);
        if (one != null) {
            if (one.getUserPassword().equals(user.getUserPassword())) {
                session.setAttribute("user", one.getUserId());
                return R.success(one);
            }
        }
        return R.error("用户名或密码错误");
    }

    @GetMapping("/logout")
    public R<String> logout(HttpSession session) {
        log.info("退出信息！！！");
        session.removeAttribute("user");
        return R.success("退出成功");
    }
}
