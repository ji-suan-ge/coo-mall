package cn.edu.hfut.coomall.web.custom.bean;

import cn.edu.hfut.coomall.entity.Address;

import java.util.List;

public class FindAddressRespBean {

    private List<Address> addressList;
    private Integer TotalPage;

    public Integer getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(Integer totalPage) {
        TotalPage = totalPage;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
