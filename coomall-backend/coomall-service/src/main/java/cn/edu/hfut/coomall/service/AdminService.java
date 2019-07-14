package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.AdminMapper;
import cn.edu.hfut.coomall.entity.Admin;
import cn.edu.hfut.coomall.service.exception.AdminNotFoundException;
import cn.edu.hfut.coomall.service.exception.InvalidPasswordException;
import cn.edu.hfut.coomall.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 10:22
 */
@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 保存管理员
     */
    public void saveAdmin(Admin admin) {

        adminMapper.insertAdmin(admin);
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 adminID 删除管理员
     */
    public void removeAdminByID(Integer adminID) {

        adminMapper.deleteAdminByID(adminID);
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 adminID 查找管理员
     */
    public Admin getAdminByID(Integer adminID) {

        Admin admin = adminMapper.selectAdminByID(adminID);
        if (admin == null) {
            throw new AdminNotFoundException(adminID);
        }
        return admin;
    }

    public Admin getAdminByPhoneNumber(String phoneNumber) {

        Admin admin = adminMapper.selectAdminByPhoneNumber(phoneNumber);
        if (admin == null) {
            throw new AdminNotFoundException(phoneNumber);
        }
        return admin;
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 获取所有管理员列表
     */
    public List<Admin> getAllAdmin() {

        return adminMapper.selectAllAdmin();
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 管理员登录
     */
    public Admin login(String phoneNumber, String password) {

        // 已经检查 admin 是否为空
        Admin admin = getAdminByPhoneNumber(phoneNumber);

        if (!PasswordUtil.checkPassword(password, admin.getPassword())) {
            throw new InvalidPasswordException(phoneNumber);
        }

        return admin;
    }
}
