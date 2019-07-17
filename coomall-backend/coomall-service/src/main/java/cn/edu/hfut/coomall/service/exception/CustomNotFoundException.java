package cn.edu.hfut.coomall.service.exception;

public class CustomNotFoundException extends BaseException {

    public CustomNotFoundException(Integer customID) {

        super("找不到用户 ID：" + customID);
    }

    public CustomNotFoundException(String customPhoneNumber) {

        super("找不到用户 PhoneNumber：" + customPhoneNumber);
    }
}
