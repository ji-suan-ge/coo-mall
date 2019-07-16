package cn.edu.hfut.coomall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Custom {

    private Integer ID;
    private String nickname;
    private Integer gender;
    private String avatar;
    private String phoneNumber;
    private String email;
    private String password;
    private Integer state;

    public Custom() {}

    public Custom(String nickname, Integer gender, String avatar, String phoneNumber, String email, String password) {
        this.nickname = nickname;
        this.gender = gender;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "ID=" + ID +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
