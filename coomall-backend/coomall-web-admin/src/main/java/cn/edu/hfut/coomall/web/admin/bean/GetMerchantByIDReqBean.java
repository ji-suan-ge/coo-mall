package cn.edu.hfut.coomall.web.admin.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
public class GetMerchantByIDReqBean {
    @NotNull(message = "merchantID 不能为空")
    private Integer merchantID;

    public Integer getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(Integer merchantID) {
        this.merchantID = merchantID;
    }
}
