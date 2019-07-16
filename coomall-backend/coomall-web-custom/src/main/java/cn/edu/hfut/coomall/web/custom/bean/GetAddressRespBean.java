package cn.edu.hfut.coomall.web.custom.bean;

import cn.edu.hfut.coomall.entity.Address;

import java.util.List;

public class GetAddressRespBean {
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    private List<Address> addressList;
}
