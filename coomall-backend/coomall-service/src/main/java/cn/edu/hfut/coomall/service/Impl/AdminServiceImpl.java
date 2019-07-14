package cn.edu.hfut.coomall.service.Impl;

import cn.edu.hfut.coomall.dao.AdminMapper;
import cn.edu.hfut.coomall.entity.Admin;
import cn.edu.hfut.coomall.service.AdminService;
import cn.edu.hfut.coomall.service.Impl.exception.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 15:16
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {

        adminMapper.insertAdmin(admin);
    }

    @Override
    public void removeAdminByID(Integer adminID) {

        adminMapper.deleteAdminByID(adminID);
    }

    @Override
    public Admin getAdminByID(Integer adminID) {

        Admin admin = adminMapper.selectAdminByID(adminID);
        if (admin == null) {
            throw new AdminNotFoundException(adminID);
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() {

        return adminMapper.selectAllAdmin();
    }
}
