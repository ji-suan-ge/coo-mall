package cn.edu.hfut.coomall.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author 葛学文
 * @date 2019/7/15 10:32
 */
public class ProductProvider {

    public String updateProduct(Map<String, Object> para) {

        Integer productID = (Integer) para.get("productID");
        Integer price = (Integer) para.get("price");
        Integer quantity = (Integer) para.get("quantity");
        String detail = (String) para.get("detail");

        return new SQL(){{
            UPDATE("product");
            if (price != null) {
                SET("price = #{price}");
            }
            if (quantity != null) {
                SET("quantity = #{quantity}");
            }
            if (detail != null) {
                SET("detail = #{detail}");
            }
            WHERE("ID = #{productID}");
        }}.toString();
    }
}
