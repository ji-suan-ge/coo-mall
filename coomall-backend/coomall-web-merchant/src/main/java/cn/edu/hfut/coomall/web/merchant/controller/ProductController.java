package cn.edu.hfut.coomall.web.merchant.controller;

import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.Product;
import cn.edu.hfut.coomall.service.ProductService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.merchant.bean.AddProductReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 葛学文
 * @date 2019/7/14 22:00
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Message addProduct(@RequestBody AddProductReqBean addProductReqBean) {

        String name = addProductReqBean.getName();
        Integer price = addProductReqBean.getPrice();
        Integer quantity = addProductReqBean.getQuantity();
        Integer category = addProductReqBean.getCategory();
        String detail = addProductReqBean.getDetail();
        Integer merchantID = addProductReqBean.getMerchantID();

        Product product = new Product(name, price, quantity, category, detail, merchantID);
        productService.saveProduct(product);

        return ResultUtil.success();
    }

}
