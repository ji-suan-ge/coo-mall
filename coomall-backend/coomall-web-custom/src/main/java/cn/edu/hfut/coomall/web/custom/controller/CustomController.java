package cn.edu.hfut.coomall.web.custom.controller;

import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.CustomService;
import cn.edu.hfut.coomall.service.exception.BaseException;
import cn.edu.hfut.coomall.service.exception.CustomNotFoundException;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.custom.bean.LoginReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/7/14 20:55
 */
@RestController
@RequestMapping("/custom")
public class CustomController {

    @Value("${coomall.identifier}")
    private String identifier;

    @Autowired
    CustomService customService;

    @PostMapping("/login")
    public Message login(@RequestBody @Valid LoginReqBean loginReqBean,
                         HttpSession httpSession) {

        String phoneNumber = loginReqBean.getPhoneNumber();
        String password = loginReqBean.getPassword();

        Custom custom;
        try {
            custom = customService.login(phoneNumber, password);
        } catch (CustomNotFoundException e) {
            return ResultUtil.error(4101, e.getMessage());
        } catch (BaseException e) {
            return ResultUtil.error(4102, e.getMessage());
        }

        httpSession.setAttribute(identifier, custom);
        custom.setPassword(null);
        return ResultUtil.success(custom);
    }

    @PostMapping("/logout")
    public Message login(HttpSession httpSession) {

        httpSession.removeAttribute(identifier);
        return ResultUtil.success();
    }

}
