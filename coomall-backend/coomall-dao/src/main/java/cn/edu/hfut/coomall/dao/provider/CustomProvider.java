package cn.edu.hfut.coomall.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
public class CustomProvider {
    public String updateCustom(Map<String, Object> para) {

        Integer customID = (Integer) para.get("customID");
        String nickname = (String) para.get("nickname");
        Integer gender = (Integer) para.get("gender");
        String avatar = (String) para.get("avatar");
        String phoneNumber = (String) para.get("phoneNumber");
        String email = (String) para.get("email");
        return new SQL(){{
            UPDATE("custom");
            if (nickname != null) {
                SET("nickname = #{nickname}");
            }
            if (gender != null) {
                SET("gender= #{gender}");
            }
            if (avatar != null) {
                SET("avatar = #{avatar}");
            }
            if (phoneNumber != null) {
                SET("phoneNumber = #{phoneNumber}");
            }
            if (email != null) {
                SET("email = #{email}");
            }
            WHERE("ID = #{customID}");
        }}.toString();
    }
}
