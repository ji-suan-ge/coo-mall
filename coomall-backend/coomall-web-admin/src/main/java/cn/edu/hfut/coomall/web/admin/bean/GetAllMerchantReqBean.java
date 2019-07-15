package cn.edu.hfut.coomall.web.admin.bean;

import javax.validation.constraints.NotNull;

public class GetAllMerchantReqBean {

    @NotNull(message = "state 不能为空")
    private Integer state;
    @NotNull(message = "currentPage 不能为空")
    private Integer currentPage;
    @NotNull(message = "pageSize 不能为空")
    private Integer limit;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
