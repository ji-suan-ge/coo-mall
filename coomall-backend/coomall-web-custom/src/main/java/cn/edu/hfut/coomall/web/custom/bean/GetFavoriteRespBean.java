package cn.edu.hfut.coomall.web.custom.bean;

import cn.edu.hfut.coomall.entity.Favorite;
import cn.edu.hfut.coomall.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class GetFavoriteRespBean {

    private List<List<Product> > productLists;

    public List<List<Product>> getProductLists() {
        return productLists;
    }

    public void setProductLists(List<List<Product>> productLists) {
        this.productLists = productLists;
    }

    public List<List<Integer>> getFavorite(List<Favorite> favoriteList){
        List<List<Integer> > productsList = null;
        Integer merchantID = favoriteList.get(0).getMerchantID();
        List<Integer> products = new ArrayList<Integer>();
        products.add(favoriteList.get(0).getProductID());
        for (int i = 1;i < favoriteList.size();i++)
        {
            if(merchantID.equals(favoriteList.get(i).getMerchantID())){
                productsList.add(products);
                products = null;
                products.add(favoriteList.get(i).getProductID());
            }else {
                products.add(favoriteList.get(i).getProductID());
            }
        }

        return productsList;
    }

}
