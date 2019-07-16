package cn.edu.hfut.coomall.web.admin.bean;

import javax.validation.constraints.NotNull;

public class GetByNickNameOrPhoneNumberOrEmailReqBean {

    @NotNull(message = "currentPage 不能为空")
    private Integer currentPage;
    @NotNull(message = "limit 不能为空")
    private Integer limit;
    private String nickName;
    private String phoneNumber;
    private String email;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
