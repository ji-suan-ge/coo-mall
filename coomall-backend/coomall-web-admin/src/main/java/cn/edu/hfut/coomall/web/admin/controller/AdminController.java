package cn.edu.hfut.coomall.web.admin.controller;

import cn.edu.hfut.coomall.entity.Admin;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.AdminService;
import cn.edu.hfut.coomall.service.exception.AdminNotFoundException;
import cn.edu.hfut.coomall.service.exception.BaseException;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.admin.bean.LoginReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/7/14 15:30
 */
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public Message login(@RequestBody @Valid LoginReqBean loginReqBean,
                         HttpSession httpSession) {

        String phoneNumber = loginReqBean.getPhoneNumber();
        String password = loginReqBean.getPassword();

        Admin admin;
        try {
            admin = adminService.login(phoneNumber, password);
        } catch (AdminNotFoundException e) {
            return ResultUtil.error(4101, e.getMessage());
        } catch (BaseException e) {
            return ResultUtil.error(4102, e.getMessage());
        }

        httpSession.setAttribute("admin", admin);
        return ResultUtil.success();
    }

    @PostMapping("/logout")
    public Message login(HttpSession httpSession) {

        httpSession.removeAttribute("admin");
        return ResultUtil.success();
    }
}
