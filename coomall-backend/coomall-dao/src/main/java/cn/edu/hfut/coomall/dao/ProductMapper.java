package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.dao.provider.ProductProvider;
import cn.edu.hfut.coomall.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 21:45
 */
@Mapper
public interface ProductMapper {

    @Insert("insert into " +
            "`product`(`name`, `price`, `quantity`, `sale`," +
            "`category`, `detail`, `state`, `merchantID`, `avatar`) " +
            "values(#{name}, #{price}, #{quantity}, 0," +
            "#{category}, #{detail}, 1, #{merchantID}, #{avatar})")
    void insertProduct(Product product);

    @Select("select * from `product`")
    List<Product> selectAllProduct();

    @Select("select * from `product` where ID = #{productID}")
    Product selectProductByID(Integer productID);

    @Update("update `product` set `state` = 0 where `ID` = #{productID}")
    void deleteProduct(Integer productID);

    @Select("select * from `product` where merchantID = #{merchantID} and `state` = 1")
    List<Product> selectProductByMerchantID(Integer merchantID);

    @UpdateProvider(type = ProductProvider.class, method = "updateProduct")
    void updateProduct(Integer productID, Integer price, Integer quantity, String detail);

    @Select("select * from `product` where `name` like concat('%',#{keyword},'%')")
    List<Product> search(String keyword);

    @Select("select * from `product` where category = #{category} and `state` = 1")
    List<Product> selectProductByCategory(Integer category);

    @Select("SELECT *\n" +
            "FROM `product`\n" +
            "WHERE `ID` >= (SELECT FLOOR( MAX(`ID`) * RAND()) FROM `product`) AND `state` = 1\n" +
            "ORDER BY `ID` LIMIT #{number}")
    List<Product> selectProductByRandom(Integer number);
}
