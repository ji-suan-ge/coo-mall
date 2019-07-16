package cn.edu.hfut.coomall.web.admin.bean;

import cn.edu.hfut.coomall.entity.Merchant;

import java.util.List;

public class SearchRespBean {

    private List<Merchant> merchantList;
    private Integer totalPage;

    public List<Merchant> getMerchantList() {
        return merchantList;
    }

    public void setMerchantList(List<Merchant> merchantList) {
        this.merchantList = merchantList;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
