package cn.edu.hfut.coomall.entity;

/**
 * @author 葛学文
 * @date 2019/7/16 2:18
 */
public class ProductStyle {

    private Integer ID;
    private Integer productID;
    private String style;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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
}
