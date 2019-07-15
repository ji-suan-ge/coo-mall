package cn.edu.hfut.coomall.web.admin.bean;

import javax.validation.constraints.NotNull;

public class GetAllCustomReqBean {
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
}
