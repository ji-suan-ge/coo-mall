package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Order;
import cn.edu.hfut.coomall.entity.Order_Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/15 16:21
 */
@Mapper
public interface OrderMapper {

    @Select("select * from `order` where ID = #{orderID}")
    Order selectOrderByID(Integer orderID);

    @Select("select * from `order` where state = #{state}")
    List<Order> selectOrderByState(Integer state);

    @Select("select * from `order` where state = #{state} and customID = #{customID}")
    List<Order> selectOrderByCustomIDAndState(Integer customID, Integer state);

    @Select("select * from `order` where state = #{state} and merchantID = #{merchantID}")
    List<Order> selectOrderByMerchantIDAndState(Integer merchantID, Integer state);

    @Insert("insert into " +
            "`order`(customID, merchantID, addressID, remark) " +
            "values(#{customID}, #{merchantID}, #{addressID}, #{remark})")
    void insertOrder(Order order);

    @Select("select ID FROM `order` ORDER BY createTime DESC LIMIT 1")
    Integer getOrderID();

    @Insert("insert into " +
            "`order_product`(orderID, productID, amount, style) " +
            "values(#{orderID}, #{productID}, #{amount}, #{style})")
    void insertOrder_Product(Order_Product order_product);

    @Update("update  `order` set state = #{state} ,sendtime = #{sendTime},completeTime = #{completeTime}" +
            ",cancelTime =#{cancelTime}, returnTime = #{returnTime} " +
            " where ID = #{orderID}")
    void changeStateByOrderID(Integer orderID, Integer state, String sendTime,
                              String completeTime, String cancelTime, String returnTime);
}
