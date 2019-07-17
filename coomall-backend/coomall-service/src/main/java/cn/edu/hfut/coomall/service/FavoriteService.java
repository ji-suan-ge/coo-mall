package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.FavoriteMapper;
import cn.edu.hfut.coomall.entity.Admin;
import cn.edu.hfut.coomall.entity.Favorite;
import cn.edu.hfut.coomall.entity.Product;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
@Service
public class FavoriteService {

    @Autowired
    FavoriteMapper favoriteMapper;

    public void saveFavorite(Favorite favorite) {

        favoriteMapper.insertFavorite(favorite);
    }

    public Map<String, Object> getFavoriteByID(Integer customID, Integer currentPage, Integer limit){


            Page page = PageHelper.startPage(currentPage, limit);
            List<Favorite> favoriteList = favoriteMapper.selectFavoriteByID(customID);

            Map<String , Object> map = new HashMap<>();
            map.put("list", favoriteList);
            map.put("totalPage", page.getPages());
            return map;
    }

    public void deleteFavoriteByProductID(Favorite favorite){

        favoriteMapper.deleteFavorite(favorite);
    }
}
