package cn.edu.hfut.coomall.web.common.controller;

import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.Product;
import cn.edu.hfut.coomall.service.ProductService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.common.bean.GetProductByIDReqBean;
import cn.edu.hfut.coomall.web.common.bean.GetProductByIDRespBean;
import cn.edu.hfut.coomall.web.common.bean.GetProductByMerchantIDReqBean;
import cn.edu.hfut.coomall.web.common.bean.GetProductByMerchantIDRespBean;
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
}
