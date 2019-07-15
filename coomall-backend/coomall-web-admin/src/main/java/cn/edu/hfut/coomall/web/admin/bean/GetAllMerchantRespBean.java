package cn.edu.hfut.coomall.web.admin.bean;

import cn.edu.hfut.coomall.entity.Merchant;

import java.util.List;

public class GetAllMerchantRespBean {

    private Integer totalPage;
    private List<Merchant> merchantList;

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
