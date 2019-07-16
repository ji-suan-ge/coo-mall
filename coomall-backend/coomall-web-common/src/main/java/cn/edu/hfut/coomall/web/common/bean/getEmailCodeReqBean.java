package cn.edu.hfut.coomall.web.common.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/7/16 21:19
 */
public class getEmailCodeReqBean {

    @NotNull(message = "email 不能为空")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
