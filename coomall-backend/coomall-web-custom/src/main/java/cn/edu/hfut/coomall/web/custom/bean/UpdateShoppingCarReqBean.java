package cn.edu.hfut.coomall.web.custom.bean;

public class UpdateShoppingCarReqBean {

    private Integer productID;
    private Integer changenumber;

    public Integer getChangenumber() {
        return changenumber;
    }

    public void setChangenumber(Integer changenumber) {
        this.changenumber = changenumber;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
}
