package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 21:45
 */
@Mapper
public interface ProductMapper {

    @Insert("insert into " +
            "`product`(`name`, `price`, `quantity`, `sale`," +
            "`category`, `detail`, `state`, `merchantID`) " +
            "values(#{name}, #{price}, #{quantity}, 0," +
            "#{category}, #{detail}, 1, #{merchantID})")
    void insertProduct(Product product);

    @Select("select * from `product`")
    List<Product> selectAllProduct();

    @Select("select * from `product` where ID = #{productID}")
    Product selectProductByID(Integer productID);

    @Update("update `product` set `state` = 0 where `ID` = #{productID}")
    void deleteProduct(Integer productID);

    @Select("select * from `product` where merchantID = #{merchantID} and `state` = 1")
    List<Product> selectProductByMerchantID(Integer merchantID);
}
