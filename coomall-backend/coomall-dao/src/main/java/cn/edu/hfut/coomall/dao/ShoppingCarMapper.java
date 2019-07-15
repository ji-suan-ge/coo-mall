package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.ShoppingCar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
@Mapper
public interface ShoppingCarMapper {

    @Insert("insert into " +
            "shoppingcar(productID, customID, number)"+
            "values(#{productID}, #{customID}, #{number})")
    void insertPShoppingCar(ShoppingCar shoppingCar);
}
