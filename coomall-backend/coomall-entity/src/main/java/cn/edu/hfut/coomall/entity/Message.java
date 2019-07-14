package cn.edu.hfut.coomall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author 葛学文
 * @date 2019/4/3 16:05
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    private String code;
    private String msg;
    private Object data;

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
