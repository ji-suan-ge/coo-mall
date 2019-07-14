package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Merchant;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
            "#{password}, #{address}, #{identityNumber}, #{identityPhoto}, #{email}, #{score}")
    void insertMerchant(Merchant merchant);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Delete("delete from " +
            "merchant where id=#{merchantID}")
    void deleteMerchantByID(Integer merchantID);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from merchant")
    List<Merchant> selectAllMerchant();

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from merchant where ID = #{merchantID}")
    Merchant selectMerchantByID(Integer merchantID);
}
