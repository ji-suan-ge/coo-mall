package cn.edu.hfut.coomall.service.exception;

public class InvalidPasswordException extends BaseException {

    public InvalidPasswordException(String phoneNumber) {
        super("用户密码错误,  phoneNumber: " + phoneNumber);
    }
}
