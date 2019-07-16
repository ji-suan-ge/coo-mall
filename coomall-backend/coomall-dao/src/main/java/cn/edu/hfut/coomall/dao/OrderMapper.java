package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
