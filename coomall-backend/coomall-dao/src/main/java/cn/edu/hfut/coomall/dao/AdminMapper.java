package cn.edu.hfut.coomall.dao;

import cn.edu.hfut.coomall.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 10:22
 */
@Mapper
public interface AdminMapper {

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Insert("insert into " +
            "admin(name, gender, password, phoneNumber, email) " +
            "values(#{name}, #{gender}, #{password}, #{phoneNumber}, #{email}")
    void insertAdmin(Admin admin);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Delete("delete from " +
            "admin where id=#{adminID}")
    void deleteAdminByID(Integer adminID);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from admin")
    List<Admin> selectAllAdmin();

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from admin where ID = #{adminID}")
    Admin selectAdminByID(Integer adminID);

    /**
     * @author 郑力煽
     * @date 2019/7/14
     */
    @Select("select * from admin where phoneNumber = #{AdminPhoneNumber}")
    Admin selectAdminByPhoneNumber(String AdminPhoneNumber);
}
