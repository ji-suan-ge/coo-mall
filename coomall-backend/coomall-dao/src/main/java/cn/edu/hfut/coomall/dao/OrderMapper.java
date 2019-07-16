package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Order;
import cn.edu.hfut.coomall.entity.OrderReturn;
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

    @Select("select   \n" +
            "`order`.ID as orderID,\n" +
            "`address`.`name` as customName,\n" +
            "`product`.`name` as productName,\n" +
            "`product`.ID as productID,\n" +
            "`order_product`.style as productStyle,\n" +
            "`address`.phoneNUmber as phoneNumber,\n" +
            "`address`.address as address,\n" +
            "`order`.remark as remark,\n" +
            "`order`.createTime as createTime,\n" +
            "`order`.sendTime as sendTime,\n" +
            "`order`.returnTime as returnTime,\n" +
            "`order`.completeTime as completeTime,\n" +
            "`product`.price as price,\n" +
            "`order_product`.amount as amount,\n" +
            "`order`.state as state,\n" +
            "`product`.avatar as avatar,\n" +
            "`product`.detail as detail,\n" +
            "`product`.category as category  \n" +
            "from\n" +
            "`order`,`order_product`,product,address\n" +
            "where address.ID = `order`.addressID and `order_product`.productID = product.ID and `order`.ID = `order_product`.orderID\n" +
            "and `order`.state = #{state} and `order`.customID = #{customID}")
    List<OrderReturn> selectOrderByCustomIDAndState(Integer customID, Integer state);

    @Select("select   \n" +
            "`order`.ID as orderID,\n" +
            "`address`.`name` as customName,\n" +
            "`product`.`name` as productName,\n" +
            "`product`.ID as productID,\n" +
            "`order_product`.style as productStyle,\n" +
            "`address`.phoneNUmber as phoneNumber,\n" +
            "`address`.address as address,\n" +
            "`order`.remark as remark,\n" +
            "`order`.createTime as createTime,\n" +
            "`order`.sendTime as sendTime,\n" +
            "`order`.returnTime as returnTime,\n" +
            "`order`.completeTime as completeTime,\n" +
            "`product`.price as price,\n" +
            "`order_product`.amount as amount,\n" +
            "`order`.state as state,\n" +
            "`product`.avatar as avatar,\n" +
            "`product`.detail as detail,\n" +
            "`product`.category as category  \n" +
            "from\n" +
            "`order`,`order_product`,product,address\n" +
            "where address.ID = `order`.addressID and " +
            "`order_product`.productID = product.ID and `order`.ID = `order_product`.orderID\n" +
            "and `order`.state = #{state} and `order`.customID = #{customID} and (completeTime between  #{beginTime}  and #{endTime})")
    List<OrderReturn> selectOrderByCustomIDAndStateAndTime(
            Integer customID, Integer state, String beginTime, String endTime);

    @Select("select   \n" +
            "`order`.ID as orderID,\n" +
            "`address`.`name` as customName,\n" +
            "`product`.`name` as productName,\n" +
            "`product`.ID as productID,\n" +
            "`order_product`.style as productStyle,\n" +
            "`address`.phoneNUmber as phoneNumber,\n" +
            "`address`.address as address,\n" +
            "`order`.remark as remark,\n" +
            "`order`.createTime as createTime,\n" +
            "`order`.sendTime as sendTime,\n" +
            "`order`.returnTime as returnTime,\n" +
            "`order`.completeTime as completeTime,\n" +
            "`product`.price as price,\n" +
            "`order_product`.amount as amount,\n" +
            "`order`.state as state,\n" +
            "`product`.avatar as avatar,\n" +
            "`product`.detail as detail,\n" +
            "`product`.category as category  \n" +
            "from\n" +
            "`order`,`order_product`,product,address\n" +
            " where address.ID = `order`.addressID and `order_product`.productID = product.ID " +
            "and `order`.ID = `order_product`.orderID and"+
             " `order`.state = #{state} and `order`.merchantID = #{merchantID}")
    List<OrderReturn> selectOrderByMerchantIDAndState(Integer merchantID, Integer state);

    @Select("select   \n" +
            "`order`.ID as orderID,\n" +
            "`address`.`name` as customName,\n" +
            "`product`.`name` as productName,\n" +
            "`product`.ID as productID,\n" +
            "`order_product`.style as productStyle,\n" +
            "`address`.phoneNUmber as phoneNumber,\n" +
            "`address`.address as address,\n" +
            "`order`.remark as remark,\n" +
            "`order`.createTime as createTime,\n" +
            "`order`.sendTime as sendTime,\n" +
            "`order`.returnTime as returnTime,\n" +
            "`order`.completeTime as completeTime,\n" +
            "`product`.price as price,\n" +
            "`order_product`.amount as amount,\n" +
            "`order`.state as state,\n" +
            "`product`.avatar as avatar,\n" +
            "`product`.detail as detail,\n" +
            "`product`.category as category  \n" +
            "from\n" +
            "`order`,`order_product`,product,address\n" +
            " where address.ID = `order`.addressID and `order_product`.productID = product.ID " +
            "and `order`.ID = `order_product`.orderID and"+
            " `order`.state = #{state} and `order`.merchantID = #{merchantID} " +
            "and (completeTime between  #{beginTime}  and #{endTime})")
    List<OrderReturn> selectOrderByMerchantIDAndStateAndTime(Integer merchantID, Integer state,String beginTime,String endTime);
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
