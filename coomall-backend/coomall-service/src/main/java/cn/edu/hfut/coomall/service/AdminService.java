package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.entity.Admin;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 10:22
 */
public interface AdminService {

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 保存管理员
     */
    void saveAdmin(Admin admin);

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 adminID 删除管理员
     */
    void removeAdminByID(Integer adminID);

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 adminID 查找管理员
     */
    Admin getAdminByID(Integer adminID);

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 获取所有管理员列表
     */
    List<Admin> getAllAdmin();

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 获取所有管理员列表
     */
    Admin login(String phoneNumber, String password);
}
