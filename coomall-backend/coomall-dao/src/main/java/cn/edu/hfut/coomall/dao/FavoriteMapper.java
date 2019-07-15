package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Favorite;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
@Mapper
public interface FavoriteMapper {

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @Insert("insert into " +
            "favorite(productID, customID) " +
            "values(#{productID}, #{customID})")
    void insertFavorite(Favorite favorite);
}
