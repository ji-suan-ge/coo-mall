package cn.edu.hfut.coomall.service.exception;

/**
 * @author 葛学文
 * @date 2019/7/14 21:56
 */
public class ProductNotFoundException extends BaseException {

    public ProductNotFoundException(Integer productID) {
        super("找不到商品, productID: " + productID);
    }
}
