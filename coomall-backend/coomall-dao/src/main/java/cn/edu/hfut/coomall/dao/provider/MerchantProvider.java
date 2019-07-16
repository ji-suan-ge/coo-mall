package cn.edu.hfut.coomall.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;


    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    public class MerchantProvider {
        public String updateMerchant(Map<String, Object> para) {

            Integer merchantID = (Integer) para.get("merchantID");
            String shopName = (String) para.get("shopName");
            String phoneNumber = (String) para.get("phoneNumber");
            String intro = (String) para.get("intro");
            String address = (String) para.get("address");
            String email = (String) para.get("email");
            return new SQL(){{
                UPDATE("merchant");
                if (shopName != null) {
                    SET("shopName= #{shopName}");
                }
                if (phoneNumber != null) {
                    SET("phoneNumber = #{phoneNumber}");
                }
                if (intro != null) {
                    SET("intro = #{intro}");
                }
                if (address != null) {
                    SET("address = #{address}");
                }
                if (email != null) {
                    SET("email = #{email}");
                }
                WHERE("ID = #{merchantID}");
            }}.toString();
        }
    }

