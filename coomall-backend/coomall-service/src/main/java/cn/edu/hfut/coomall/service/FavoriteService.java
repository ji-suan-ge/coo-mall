package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.FavoriteMapper;
import cn.edu.hfut.coomall.entity.Admin;
import cn.edu.hfut.coomall.entity.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Favorite> getFavoriteByID(Integer customID){

        return favoriteMapper.selectFavoriteByID(customID);
    }
}
