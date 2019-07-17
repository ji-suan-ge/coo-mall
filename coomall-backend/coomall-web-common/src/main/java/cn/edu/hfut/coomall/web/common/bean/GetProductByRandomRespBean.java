package cn.edu.hfut.coomall.web.common.bean;

import cn.edu.hfut.coomall.entity.Product;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/15 23:53
 */
public class GetProductByRandomRespBean {

    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
