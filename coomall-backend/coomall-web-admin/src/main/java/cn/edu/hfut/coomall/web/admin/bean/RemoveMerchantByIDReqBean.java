package cn.edu.hfut.coomall.web.admin.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
public class RemoveMerchantByIDReqBean {
    @NotNull(message = "MerchantID 不能为空")
    private int merchantID;

    public int getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(int merchantID) {
        this.merchantID = merchantID;
    }
}
