package cn.edu.hfut.coomall.entity;

/**
 * @author 郑力煽
 * @date 2019/7/16
 */
public class Order_Product {

    private Integer orderID;
    private Integer productID;
    private String style;
    private Integer amount;

    public Order_Product(Integer orderID, Integer productID, String style, Integer amount) {
        this.orderID = orderID;
        this.productID = productID;
        this.style = style;
        this.amount = amount;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
