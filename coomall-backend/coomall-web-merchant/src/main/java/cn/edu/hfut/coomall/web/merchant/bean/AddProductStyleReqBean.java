package cn.edu.hfut.coomall.web.merchant.bean;

/**
 * @author 葛学文
 * @date 2019/7/16 2:36
 */
public class AddProductStyleReqBean {

    private Integer productID;
    private String style;

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
