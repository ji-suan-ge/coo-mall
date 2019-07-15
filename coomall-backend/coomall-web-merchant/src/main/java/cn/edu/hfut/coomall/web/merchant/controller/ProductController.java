package cn.edu.hfut.coomall.web.merchant.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.Product;
import cn.edu.hfut.coomall.service.ProductService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.merchant.bean.AddProductReqBean;
import cn.edu.hfut.coomall.web.merchant.bean.EditProductReqBean;
import cn.edu.hfut.coomall.web.merchant.bean.RemoveProductReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/7/14 22:00
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    CooMallConfig cooMallConfig;
    @Autowired
    ProductService productService;

    @LoginRequired
    @PostMapping("/add")
    public Message addProduct(@RequestBody @Valid AddProductReqBean addProductReqBean,
                              HttpSession httpSession) {

        String name = addProductReqBean.getName();
        Integer price = addProductReqBean.getPrice();
        Integer quantity = addProductReqBean.getQuantity();
        Integer category = addProductReqBean.getCategory();
        String detail = addProductReqBean.getDetail();

        Merchant merchant = (Merchant)httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer merchantID = merchant.getID();

        Product product = new Product(name, price, quantity, category, detail, merchantID);
        productService.saveProduct(product);

        return ResultUtil.success();
    }

    @LoginRequired
    @PostMapping("/remove")
    public Message removeProduct(@RequestBody @Valid RemoveProductReqBean removeProductReqBean,
                              HttpSession httpSession) {

        Integer productID = removeProductReqBean.getProductID();

        Merchant merchant = (Merchant)httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer merchantID = merchant.getID();

        Product product = productService.getProductByID(productID);

        if (product.getMerchantID().equals(merchantID)) {
            productService.removeProductByID(productID);
        } else {
            return ResultUtil.error(4200, "权限不足");
        }

        return ResultUtil.success();
    }

    @LoginRequired
    @PostMapping("/edit")
    public Message editProduct(@RequestBody @Valid EditProductReqBean editProductReqBean,
                               HttpSession httpSession) {

        Integer productID = editProductReqBean.getProductID();
        Integer price = editProductReqBean.getPrice();
        Integer quantity = editProductReqBean.getQuantity();
        String detail = editProductReqBean.getDetail();

        if (price == null && quantity == null && detail == null) {
            return ResultUtil.error(4001, "参数不足");
        }


        Merchant merchant = (Merchant)httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer merchantID = merchant.getID();

        Product product = productService.getProductByID(productID);

        if (product.getMerchantID().equals(merchantID)) {
            productService.editProduct(productID, price, quantity, detail);
        } else {
            return ResultUtil.error(4200, "权限不足");
        }

        return ResultUtil.success();
    }

}
