package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author 郑力煽
 * @date 2019/7/16
 */
@Mapper
public interface BillMapper {

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("SELECT " +
            "max(amount * price) as highPrice," +
            "min(amount * price) as lowPrice," +
            "sum(price) as monthSale ," +
            "sum(amount) as monthAmount ," +
            "MONTH(completeTime) as month " +
            "from `order` , order_product , product  " +
            "where `order`.ID = order_product.orderID " +
            "and productID = product.ID " +
            "and `order`.merchantID = #{merchantID} " +
            "and order_product.productID = product.ID " +
            "and `order`.state = 2 " +
            "and YEAR(completeTime) = #{year} " +
            "GROUP BY month(completeTime)")
    List<Bill> getBill(Integer merchantID, Integer year);
}
