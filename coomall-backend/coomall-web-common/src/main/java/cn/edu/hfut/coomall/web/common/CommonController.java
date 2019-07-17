package cn.edu.hfut.coomall.web.common;

import cn.edu.hfut.coomall.entity.Admin;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.AdminService;
import cn.edu.hfut.coomall.service.CustomService;
import cn.edu.hfut.coomall.service.MerchantService;
import cn.edu.hfut.coomall.util.EmailUtil;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.common.bean.getEmailCodeReqBean;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/7/16 21:18
 */
@RestController
public class CommonController {

    @Autowired
    CustomService customService;
    @Autowired
    MerchantService merchantService;
    @Autowired
    AdminService adminService;
    @PostMapping("/getEmailCode")
    public Message getEmailCode(@RequestBody @Valid getEmailCodeReqBean getEmailCodeReqBean,
                                HttpSession httpSession) {

        String email = getEmailCodeReqBean.getEmail();
//        Admin admin = adminService.getAdminByEmail(email);
//        if (admin == null) {
//            Custom custom = customService.getCustomByEmail(email);
//            if (custom == null) {
//                Merchant merchant = merchantService.getMerchantByEmail(email);
//                if (merchant == null) {
//                    return ResultUtil.error(4501, "邮箱不存在");
//                }
//            }
//        }
        String emailCode = RandomStringUtils.randomAlphanumeric(4);
        String content = "您找回密码的邮箱验证码为：" + emailCode;
        httpSession.setAttribute("emailCode", emailCode);
        httpSession.setAttribute("emailAddr", email);

        EmailUtil.send(email, "CooMall - 找回密码", content);

        return ResultUtil.success();
    }
}
