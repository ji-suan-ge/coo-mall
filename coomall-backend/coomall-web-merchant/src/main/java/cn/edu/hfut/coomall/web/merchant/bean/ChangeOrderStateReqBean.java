package cn.edu.hfut.coomall.web.merchant.bean;

public class ChangeOrderStateReqBean {

    private Integer orderID;
    private Integer State;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }
}
