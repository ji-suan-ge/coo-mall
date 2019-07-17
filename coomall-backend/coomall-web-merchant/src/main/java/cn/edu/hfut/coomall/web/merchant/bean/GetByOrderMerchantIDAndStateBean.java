package cn.edu.hfut.coomall.web.merchant.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/7/15 17:05
 */
public class GetByOrderMerchantIDAndStateBean {

    @NotNull(message = "currentPage 不能为空")
    private Integer currentPage;
    @NotNull(message = "limit 不能为空")
    private Integer limit;
    @NotNull(message = "state 不能为空")
    private Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
