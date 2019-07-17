package cn.edu.hfut.coomall.web.custom.bean;

public class UpdateShoppingCarReqBean {

    private Integer productID;
    private Integer changeNumber;

    public Integer getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(Integer changeNumber) {
        this.changeNumber = changeNumber;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
}
