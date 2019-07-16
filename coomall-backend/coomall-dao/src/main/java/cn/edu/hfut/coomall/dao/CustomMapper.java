package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.dao.provider.CustomProvider;
import cn.edu.hfut.coomall.entity.Custom;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 郑力煽
 * @date 2019/7/14
 */
@Mapper
public interface CustomMapper {

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Insert("insert into " +
            "custom(nickname, gender, avatar, phoneNumber, email, password) " +
            "values(#{nickname}, #{gender}, #{avatar}, #{phoneNumber}, #{email}, #{password})")
    void insertCustom(Custom custom);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Update("update custom set state = 0 where id=#{customID}")
    void deleteCustomByID(Integer customID);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Update("update custom set state = 0 where phoneNumber=#{customPhoneNumber}")
    void deleteCustomByPhoneNumber(String customPhoneNumber);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from custom where ID = #{customID} and state = 1")
    Custom selectCustomByID(Integer customID);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from custom where phoneNumber = #{CustomPhoneNumber} and state = 1")
    Custom selectCustomByPhoneNumber(String customPhoneNumber);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */

    @UpdateProvider(type = CustomProvider.class, method = "updateCustom")
    void updateProduct(Integer customID, String nickname, Integer gender, String avatar,
                       String phoneNumber, String email) ;
    @Select("select * from custom where state = #{state}")
    List<Custom> selectCustomByState(Integer state);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from custom where " +
            "(`nickName` like concat('%', #{nickName} ,'%') or " +
            "`phoneNumber` like concat('%', #{phoneNumber} ,'%') or " +
            " `email` like concat('%', #{email} ,'%')) and state = 1")
    List<Custom> getByNickNameOrPhoneNumberOrEmail(String nickName, String phoneNumber, String email);
}
