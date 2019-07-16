package cn.edu.hfut.coomall.service.exception;

/**
 * @author 葛学文
 * @date 2019/7/15 16:25
 */
public class OrderNotFoundException extends BaseException {
    public OrderNotFoundException(Integer orderID) {
        super("找不到订单, orderID: " + orderID);
    }
}
