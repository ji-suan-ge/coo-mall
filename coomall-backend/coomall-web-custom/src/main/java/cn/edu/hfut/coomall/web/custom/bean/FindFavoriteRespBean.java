package cn.edu.hfut.coomall.web.custom.bean;


import cn.edu.hfut.coomall.entity.Favorite;

import java.util.List;

public class FindFavoriteRespBean {

    private List<Favorite> favoriteList;
    private Integer totalPage;

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<Favorite> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }
}
