package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.dao.provider.MerchantProvider;
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

    @UpdateProvider(type = MerchantProvider.class, method = "updateMerchant")
    void updateMerchant(Integer merchantID, String shopName ,String phoneNumber ,String intro ,String address ,String email) ;

    /**
     * @author 葛学文
     * @date 2019/7/15
     */
    @Select("select * from merchant where state = #{state}")
    List<Merchant> selectMerchantByState(Integer state);

    @Select("select * from merchant where " +
            "(`shopName` like concat('%', #{shopName} ,'%') or " +
            "`ownerName` like concat('%', #{ownerName} ,'%') or " +
            "`address` like concat('%', #{address} ,'%') or " +
            "`identityNumber` like concat('%', #{identityNumber} ,'%') or " +
            " `email` like concat('%', #{email} ,'%')) and state = 2")
    List<Merchant> search(String shopName, String ownerName,String intro, String address,String identityNumber
            ,String email);

    @Update("update merchant set password = #{encodePassword} where email = #{email}")
    void updatePasswordByEmail(String email, String encodePassword);

    @Select("select * from merchant where email = #{email}")
    Merchant selectMerchantByEmail(String email);

}
