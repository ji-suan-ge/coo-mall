package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.ShoppingCar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
@Mapper
public interface ShoppingCarMapper {

    @Insert("insert into " +
            "shoppingcar(productID, customID, number)"+
            "values(#{productID}, #{customID}, #{number})")
    void insertShoppingCar(ShoppingCar shoppingCar);

    @Delete("delete from " +
            "shoppingcar "+
            "where productID = #{productID} and customID = #{customID}")
    void deleteShoppingCar(ShoppingCar shoppingCar);

    @Select("select * from " +
            "shoppingcar "+
            "where customID = #{customID}")
    List<ShoppingCar> findShoppingCar(Integer customID);

}
