package cn.edu.hfut.coomall.entity;

public class ShoppingCar {

    private Integer productID;
    private Integer customID;
    private Integer number;

    public ShoppingCar(Integer productID, Integer customID, Integer number) {
        this.productID = productID;
        this.customID = customID;
        this.number = number;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "productID=" + productID +
                ", customID=" + customID +
                ", number=" + number +
                '}';
    }

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
}
