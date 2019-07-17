package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.ShoppingCar;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from " +
            "shoppingcar "+
            "where customID = #{customID} and productID = #{productID}")
    ShoppingCar selectShoppingCarNumber(Integer customID,Integer productID);

    @Update("update " +
            "shoppingcar "+
            "set number = #{changeNumber} " +
            "where customID = #{customID} and productID = #{productID}")
    void updateShoppingCar(Integer customID, Integer productID, Integer changeNumber);

}
