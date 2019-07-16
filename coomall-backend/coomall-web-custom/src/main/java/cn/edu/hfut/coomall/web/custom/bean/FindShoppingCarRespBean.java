package cn.edu.hfut.coomall.web.custom.bean;

import cn.edu.hfut.coomall.entity.ShoppingCar;

import java.util.List;

public class FindShoppingCarRespBean {

    private List<ShoppingCar> shoppingCarList;
    private Integer totalPage;

    public List<ShoppingCar> getShoppingCarList() {
        return shoppingCarList;
    }

    public void setShoppingCarList(List<ShoppingCar> shoppingCarList) {
        this.shoppingCarList = shoppingCarList;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
