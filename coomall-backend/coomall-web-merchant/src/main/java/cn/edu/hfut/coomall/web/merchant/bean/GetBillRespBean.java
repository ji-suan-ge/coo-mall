package cn.edu.hfut.coomall.web.merchant.bean;

import cn.edu.hfut.coomall.entity.Bill;

import java.util.List;

public class GetBillRespBean {

    private List<Bill> billList;

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
