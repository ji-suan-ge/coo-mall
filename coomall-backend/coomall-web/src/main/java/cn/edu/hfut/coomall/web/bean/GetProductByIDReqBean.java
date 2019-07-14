package cn.edu.hfut.coomall.web.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/7/14 22:06
 */
public class GetProductByIDReqBean {

    @NotNull(message = "productID 不能为空")
    private Integer productID;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
}
