package cn.edu.hfut.coomall.web.common.controller;

import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.Product;
import cn.edu.hfut.coomall.entity.ProductStyle;
import cn.edu.hfut.coomall.service.ProductService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.common.bean.*;
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
 * @date 2019/7/14 22:42
 */
@RequestMapping("/product")
@RestController
public class CommonProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/getByID")
    public Message getProductByID(@RequestBody @Valid
        GetProductByIDReqBean getProductByIDReqBean) {

        Integer productID = getProductByIDReqBean.getProductID();

        Product product = productService.getProductByID(productID);
        GetProductByIDRespBean getProductByIDRespBean = new GetProductByIDRespBean();
        getProductByIDRespBean.setProduct(product);

        return ResultUtil.success(getProductByIDRespBean);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/getByMerchantID")
    public Message getProductByMerchantID(@RequestBody @Valid
        GetProductByMerchantIDReqBean getProductByMerchantIDReqBean) {

        Integer merchantID = getProductByMerchantIDReqBean.getMerchantID();
        Integer currentPage = getProductByMerchantIDReqBean.getCurrentPage();
        Integer limit = getProductByMerchantIDReqBean.getLimit();

        Map<String, Object> map = productService.getProductByMerchantID(merchantID,
                currentPage, limit);
        Integer totalPage = (Integer) map.get("totalPage");
        List<Product> productList = (List<Product>) map.get("list");
        GetProductByMerchantIDRespBean getProductByMerchantIDRespBean =
                new GetProductByMerchantIDRespBean();
        getProductByMerchantIDRespBean.setProductList(productList);
        getProductByMerchantIDRespBean.setTotalPage(totalPage);

        return ResultUtil.success(getProductByMerchantIDRespBean);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/getByCategory")
    public Message getProductByCategory(@RequestBody @Valid
                                                GetProductByCategoryReqBean getProductByCategoryReqBean) {

        Integer category = getProductByCategoryReqBean.getCategory();
        Integer currentPage = getProductByCategoryReqBean.getCurrentPage();
        Integer limit = getProductByCategoryReqBean.getLimit();

        Map<String, Object> map = productService.getProductByCategory(category, currentPage, limit);
        Integer totalPage = (Integer) map.get("totalPage");
        List<Product> productList = (List<Product>) map.get("list");
        GetProductByCategoryRespBean getProductByCategoryRespBean =
                new GetProductByCategoryRespBean();
        getProductByCategoryRespBean.setProductList(productList);
        getProductByCategoryRespBean.setTotalPage(totalPage);

        return ResultUtil.success(getProductByCategoryRespBean);
    }

    @PostMapping("/getByRandom")
    public Message getProductByRandom(@RequestBody @Valid
                                              GetProductByRandomReqBean getProductByRandomReqBean) {

        Integer number = getProductByRandomReqBean.getNumber();

        List<Product> productList = productService.getProductByRandom(number);
        GetProductByRandomRespBean getProductByRandomRespBean =
                new GetProductByRandomRespBean();
        getProductByRandomRespBean.setProductList(productList);

        return ResultUtil.success(getProductByRandomRespBean);
    }

    @PostMapping("/getStyle")
    public Message getStyle(@RequestBody @Valid GetStyleReqBean getStyleReqBean) {

        Integer productID = getStyleReqBean.getProductID();

        List<ProductStyle> productStyleList = productService.getStyleByProductID(productID);

        GetStyleRespBean getStyleRespBean = new GetStyleRespBean();
        getStyleRespBean.setProductStyleList(productStyleList);

        return ResultUtil.success(getStyleRespBean);
    }

    @PostMapping("/getMerchantID")
    public Message getMerchantID(@RequestBody @Valid GetMerchantIDReqBean getMerchantIDReqBean) {

        Integer productID = getMerchantIDReqBean.getProductID();

        Integer merchantID = productService.getMerchantID(productID);
        GetMerchantIDRespBean getMerchantIDRespBean = new GetMerchantIDRespBean();
        getMerchantIDRespBean.setMerchantID(merchantID);

        return ResultUtil.success(getMerchantIDRespBean);
    }
}
