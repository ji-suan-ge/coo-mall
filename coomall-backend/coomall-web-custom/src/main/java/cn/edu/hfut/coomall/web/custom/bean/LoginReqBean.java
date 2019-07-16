package cn.edu.hfut.coomall.web.custom.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/7/15 11:14
 */
public class LoginReqBean {

    @NotNull(message = "手机号不能为空")
    private String phoneNumber;
    @NotNull(message = "密码不能为空")
    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
