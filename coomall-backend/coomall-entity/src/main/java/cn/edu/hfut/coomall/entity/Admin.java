package cn.edu.hfut.coomall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author 葛学文
 * @date 2019/7/14 10:22
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Admin {

    private Integer ID;
    private String name;
    private String gender;
    private String password;
    private String phoneNumber;
    private String email;

    @Override
    public String toString() {
        return "Admin{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
