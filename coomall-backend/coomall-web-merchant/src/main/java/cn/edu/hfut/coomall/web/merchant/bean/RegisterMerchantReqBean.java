package cn.edu.hfut.coomall.web.merchant.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
public class RegisterMerchantReqBean {
    @NotNull(message = "shopName 不能为空")
    private String shopName;
    @NotNull(message = "ownerName 不能为空")
    private String ownerName;
    @NotNull(message = "phoneNumber 不能为空")
    private String phoneNumber;
    @NotNull(message = "intro 不能为空")
    private String intro;
    @NotNull(message = "password 不能为空")
    private String password;
    @NotNull(message = "address 不能为空")
    private String address;
    @NotNull(message = "identityNumber 不能为空")
    private String identityNumber;
    @NotNull(message = "identityPhoto 不能为空")
    private String identityPhoto;
    @NotNull(message = "email 不能为空")
    private String email;

    @Override
    public String toString() {
        return "RegisterMerchantReqBean{" +
                "shopName='" + shopName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", intro='" + intro + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", identityPhoto='" + identityPhoto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getIdentityPhoto() {
        return identityPhoto;
    }

    public void setIdentityPhoto(String identityPhoto) {
        this.identityPhoto = identityPhoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

