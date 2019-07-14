package cn.edu.hfut.coomall.service.exception;

public class MerchantNotFoundException extends BaseException {

    public MerchantNotFoundException(Integer merchantID) {

        super("找不到商家, merchantID: " + merchantID);
    }
}
