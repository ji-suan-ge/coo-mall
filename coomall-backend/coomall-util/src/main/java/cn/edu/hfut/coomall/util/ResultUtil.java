package cn.edu.hfut.coomall.util;


import cn.edu.hfut.coomall.entity.Message;

/**
 * @author 葛学文
 * @date 2019/7/14 11:16
 */
public class ResultUtil {

    private ResultUtil(){
    }

    /**
     * 接口请求成功返回
     */
    public static Message success(Object object){
        Message message = new Message();
        message.setCode("0000");
        message.setMsg("请求成功");
        message.setData(object);
        return message;
    }

    /**
     * 接口请求失败返回
     */
    public static Message error(Integer code, String resultMessage){
        Message message = new Message();
        message.setCode(code.toString());
        message.setMsg(resultMessage);
        return message;
    }
}
