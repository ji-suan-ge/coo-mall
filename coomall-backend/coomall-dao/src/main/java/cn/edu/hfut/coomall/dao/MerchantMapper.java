package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Merchant;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 郑力煽
 * @date 2019/7/14
 */
@Mapper
public interface MerchantMapper {

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Insert("insert into " +
            "merchant(shopName, ownerName, phoneNumber, intro, " +
            "password, address, identityNumber, identityPhoto, email, score) " +
            "values(#{shopName}, #{ownerName}, #{phoneNumber}, #{intro}, " +
            "#{password}, #{address}, #{identityNumber}, #{identityPhoto}, #{email}, #{score})")
    void insertMerchant(Merchant merchant);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Update("update merchant set state = 0 where id=#{merchantID}")
    void deleteMerchantByID(Integer merchantID);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from merchant where ID = #{merchantID} and state = 2")
    Merchant selectMerchantByID(Integer merchantID);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from merchant where phoneNumber = #{phoneNumber} and state = 2")
    Merchant selectMerchantByPhoneNumber(String phoneNumber);

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @Update("update merchant set state = 2 where id=#{merchantID}")
    void updateMerchantStateByID(Integer merchantID);

    /**
     * @author 葛学文
     * @date 2019/7/15
     */
    @Select("select * from merchant where state = #{state}")
    List<Merchant> selectMerchantByState(Integer state);
}
