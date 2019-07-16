package cn.edu.hfut.coomall.entity;

public class Address {
    private Integer ID;
    private Integer customID;
    private String address;
    private String phoneNumber;
    private String name;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Address(Integer customID, String address, String phoneNumber, String name) {
        this.customID = customID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }
}
