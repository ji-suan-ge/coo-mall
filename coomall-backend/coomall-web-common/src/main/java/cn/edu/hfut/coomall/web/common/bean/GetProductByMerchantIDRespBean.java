package cn.edu.hfut.coomall.web.common.bean;

import cn.edu.hfut.coomall.entity.Product;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 22:16
 */
public class GetProductByMerchantIDRespBean {

    private List<Product> productList;
    private Integer totalPage;

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
