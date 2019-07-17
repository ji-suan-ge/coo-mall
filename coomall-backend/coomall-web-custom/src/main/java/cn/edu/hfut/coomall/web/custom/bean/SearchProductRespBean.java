package cn.edu.hfut.coomall.web.custom.bean;

import cn.edu.hfut.coomall.entity.Product;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/15 22:13
 */
public class SearchProductRespBean {

    private List<Product> productList;
    private Integer totalPage;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
