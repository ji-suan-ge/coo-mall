package cn.edu.hfut.coomall.service.Impl.exception;

public class AdminNotFoundException extends BaseException {

    public AdminNotFoundException(Integer adminID) {

        super("找不到管理员, adminID: " + adminID);
    }

    public AdminNotFoundException(String phoneNumber) {

        super("找不到管理员, phoneNumber: " + phoneNumber);
    }
}
