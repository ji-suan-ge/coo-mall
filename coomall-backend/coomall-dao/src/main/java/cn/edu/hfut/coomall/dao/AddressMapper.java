package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Address;
import cn.edu.hfut.coomall.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 郑力煽
 * @date 2019/7/16
 */
@Mapper
public interface AddressMapper {

    /**
     * @author 郑力煽
     * @date 2019/7/16
     */
    @Insert("insert into " +
            "address(customID, address, phoneNumber, name) " +
            "values(#{customID}, #{address}, #{phoneNumber}, #{name})")
    void insertAddress(Address address);

    /**
     * @author 郑力煽
     * @date 2019/7/16
     */
    @Update("update " +
            "address set state = 0 " +
            "where ID = #{addressID} ")
    void deleteAddress(Integer addressID);

    /**
     * @author 郑力煽
     * @date 2019/7/16
     */
    @Select("select * from " +
            "address " +
            "where customID = #{customID} ")
    List<Address> findAddress(Integer customID);
}
