package cn.edu.hfut.coomall.web.common.bean;

import cn.edu.hfut.coomall.entity.ProductStyle;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/16 2:26
 */
public class GetStyleRespBean {

    private List<ProductStyle> productStyleList;

    public List<ProductStyle> getProductStyleList() {
        return productStyleList;
    }

    public void setProductStyleList(List<ProductStyle> productStyleList) {
        this.productStyleList = productStyleList;
    }
}
