package cn.edu.hfut.coomall.web.merchant.bean;

import javax.validation.constraints.NotNull;

public class GetByOrderMerchantIDAndStateAndTimeBean {

    @NotNull(message = "currentPage 不能为空")
    private Integer currentPage;
    @NotNull(message = "limit 不能为空")
    private Integer limit;
    @NotNull(message = "state 不能为空")
    private Integer state;
    @NotNull(message = "state 不能为空")
    private String beginTime;
    @NotNull(message = "state 不能为空")
    private String endTime;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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
