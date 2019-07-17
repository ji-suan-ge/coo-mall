package cn.edu.hfut.coomall.web.custom.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/7/16 21:09
 */
public class EditPasswordRequestBean {

    @NotNull(message = "验证码不能为空")
    private String emailCode;
    @NotNull(message = "新密码不能为空")
    private String newPassword;

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
