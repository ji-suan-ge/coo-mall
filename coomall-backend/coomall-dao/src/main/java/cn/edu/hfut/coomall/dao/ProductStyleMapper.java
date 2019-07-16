package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.ProductStyle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/16 2:19
 */
@Mapper
public interface ProductStyleMapper {

    @Select("select * from `product_style` where productID = #{productID}")
    List<ProductStyle> selectProductStyleByProductID(Integer productID);

    @Insert("insert into `product_style`(`productID`, `style`) values(#{productID}, #{style})")
    void saveStyle(ProductStyle productStyle);

    @Select("select merchantID from product where ID = #{productID}")
    Integer getMerchantID(Integer productID);
}
