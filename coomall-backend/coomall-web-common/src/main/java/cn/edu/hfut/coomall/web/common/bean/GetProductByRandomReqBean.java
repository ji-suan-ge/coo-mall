package cn.edu.hfut.coomall.web.common.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/7/15 23:53
 */
public class GetProductByRandomReqBean {

    @NotNull(message = "number 不能为空")
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
