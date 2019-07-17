package cn.edu.hfut.coomall.web.admin.bean;

import javax.validation.constraints.NotNull;

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
