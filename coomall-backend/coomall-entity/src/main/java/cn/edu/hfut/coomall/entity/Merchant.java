package cn.edu.hfut.coomall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author 葛学文
 * @date 2019/7/14 14:39
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Merchant {

    private Integer ID;
    private String shopName;
    private String ownerName;
    private String phoneNumber;
    private String intro;
    private String password;
    private String address;
    private String identityNumber;
    private String identityPhoto;
    private String email;
    private Integer score;
    private Integer state;

    @Override
    public String toString() {
        return "Merchant{" +
                "ID=" + ID +
                ", shopName='" + shopName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", intro='" + intro + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", identityPhoto='" + identityPhoto + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                ", state=" + state +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
