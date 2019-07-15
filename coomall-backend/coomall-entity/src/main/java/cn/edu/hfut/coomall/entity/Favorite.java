package cn.edu.hfut.coomall.entity;

public class Favorite {

    private Integer productID;
    private Integer customID;

    public Favorite(Integer productID, Integer customID) {
        this.productID = productID;
        this.customID = customID;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "productID=" + productID +
                ", customID=" + customID +
                '}';
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }
}
