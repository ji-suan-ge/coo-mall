package cn.edu.hfut.coomall.web.common;

import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.util.EmailUtil;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.common.bean.getEmailCodeReqBean;
import org.apache.commons.lang3.RandomStringUtils;
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

    @PostMapping("/getEmailCode")
    public Message getEmailCode(@RequestBody @Valid getEmailCodeReqBean getEmailCodeReqBean,
                                HttpSession httpSession) {

        String email = getEmailCodeReqBean.getEmail();
        String emailCode = RandomStringUtils.randomAlphanumeric(4);
        String content = "您找回密码的邮箱验证码为：" + emailCode;
        httpSession.setAttribute("emailCode", emailCode);
        httpSession.setAttribute("emailAddr", email);

        EmailUtil.send(email, "CooMall - 找回密码", content);

        return ResultUtil.success();
    }
}
