package cn.edu.hfut.coomall.web.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/7/14 22:06
 */
public class GetProductByMerchantIDReqBean {

    @NotNull(message = "merchantID 不能为空")
    private Integer merchantID;
    @NotNull(message = "currentPage 不能为空")
    private Integer currentPage;
    @NotNull(message = "pageSize 不能为空")
    private Integer limit;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(Integer merchantID) {
        this.merchantID = merchantID;
    }
}
