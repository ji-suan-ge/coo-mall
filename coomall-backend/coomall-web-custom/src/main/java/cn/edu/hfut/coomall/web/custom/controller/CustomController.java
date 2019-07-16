package cn.edu.hfut.coomall.web.custom.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.CustomService;
import cn.edu.hfut.coomall.service.exception.BaseException;
import cn.edu.hfut.coomall.service.exception.CustomNotFoundException;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.custom.bean.AddCustomReqBean;
import cn.edu.hfut.coomall.web.custom.bean.EditCustomReqBean;
import cn.edu.hfut.coomall.web.custom.bean.LoginReqBean;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CooMallConfig cooMallConfig;
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

        httpSession.setAttribute(cooMallConfig.getIdentifier(), custom);
        custom.setPassword(null);
        return ResultUtil.success(custom);
    }

    @PostMapping("/logout")
    public Message login(HttpSession httpSession) {

        httpSession.removeAttribute(cooMallConfig.getIdentifier());
        return ResultUtil.success();
    }

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @LoginRequired
    @PostMapping("/edit")
    public Message editCustom(@RequestBody @Valid EditCustomReqBean editCustomReqBean,
                               HttpSession httpSession) {

        String nickname = editCustomReqBean.getNickname();
        Integer gender = editCustomReqBean.getGender();
        String avatar = editCustomReqBean.getAvatar();
        String phoneNumber = editCustomReqBean.getPhoneNumber();
        String email = editCustomReqBean.getEmail();

        if (nickname == null && gender == null && avatar == null
                && phoneNumber == null && email == null) {
            return ResultUtil.error(4001, "参数不足");
        }
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();

        customService.editCustom(customID, nickname, gender, avatar, phoneNumber, email);
        return ResultUtil.success();
    }

    /**
     * @author 郑力煽
     * @date 2019/7/16
     */
    @PostMapping("/add")
    public Message addCustom(@RequestBody @Valid AddCustomReqBean addCustomReqBean) {

        String nickname = addCustomReqBean.getNickname();
        Integer gender = addCustomReqBean.getGender();
        String avatar = addCustomReqBean.getAvatar();
        String phoneNumber = addCustomReqBean.getPhoneNumber();
        String email = addCustomReqBean.getEmail();
        String password = addCustomReqBean.getPassword();

        if (nickname == null || gender == null || avatar == null
                || phoneNumber == null || email == null || password == null) {
            return ResultUtil.error(4001, "参数不足");
        }
        Custom custom = new Custom(nickname,gender,avatar,phoneNumber,email,password);

        customService.saveCustom(custom);
        return ResultUtil.success();
    }

}
