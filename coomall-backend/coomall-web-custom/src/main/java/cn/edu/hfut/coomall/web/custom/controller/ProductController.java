package cn.edu.hfut.coomall.web.custom.controller;

import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.Product;
import cn.edu.hfut.coomall.service.ProductService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.custom.bean.SearchProductReqBean;
import cn.edu.hfut.coomall.web.custom.bean.SearchProductRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author 葛学文
 * @date 2019/7/15 21:40
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @SuppressWarnings("unchecked")
    @PostMapping("/search")
    public Message search(@RequestBody @Valid SearchProductReqBean searchProductReqBean) {

        String keyword = searchProductReqBean.getKeyword();
        Integer currentPage = searchProductReqBean.getCurrentPage();
        Integer limit = searchProductReqBean.getLimit();

        Map<String, Object> map = productService.search(keyword, currentPage, limit);
        List<Product> productList = (List<Product>) map.get("list");
        Integer totalPage = (Integer) map.get("totalPage");
        SearchProductRespBean searchProductRespBean = new SearchProductRespBean();
        searchProductRespBean.setProductList(productList);
        searchProductRespBean.setTotalPage(totalPage);
        return ResultUtil.success(searchProductRespBean);
    }
}
