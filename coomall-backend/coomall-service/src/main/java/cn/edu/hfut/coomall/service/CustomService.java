package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.CustomMapper;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Product;
import cn.edu.hfut.coomall.service.exception.CustomNotFoundException;
import cn.edu.hfut.coomall.util.PasswordUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郑力煽
 * @date 2019/7/14
 */
@Service
public class CustomService {

    @Autowired
    CustomMapper customMapper;

    /**
     * @author 郑力煽
     * @data 2019/7/14
     * 保存客户
     */
    public void saveCustom(Custom custom) {
        customMapper.insertCustom(custom);
    }

    /**
     * @author 郑力煽
     * @data 2019/7/14
     * 删除客户按ID
     */
    public void removeCustomByID(Integer customID) {

        customMapper.deleteCustomByID(customID);
    }

    /**
     * @author 郑力煽
     * @data 2019/7/14
     * 删除客户按手机号
     */
    public void removeCustomByPhoneNumber(String customPhoneNumber) {

        customMapper.deleteCustomByPhoneNumber(customPhoneNumber);
    }

    /**
     * @author 郑力煽
     * @data 2019/7/14
     * 查找客户按ID
     */
    public Custom getCustomByID(Integer customID) {

        Custom custom = customMapper.selectCustomByID(customID);
        if (custom == null) {
            throw new CustomNotFoundException(customID);
        }
        return custom;
    }


    /**
     * @author 郑力煽
     * @data 2019/7/14
     * 查找客户按手机号
     */
    public Custom getCustomByPhoneNumber(String phoneNumber) {

        Custom custom = customMapper.selectCustomByPhoneNumber(phoneNumber);
        if (custom == null) {
            throw new CustomNotFoundException(phoneNumber);
        }
        return custom;
    }

    /**
     * @author 郑力煽
     * @data 2019/7/14
     * 查找所有客户
     */
    public Map<String, Object> getAllCustom(Integer currentPage, Integer limit) {
        Page page = PageHelper.startPage(currentPage, limit);
        List<Custom> customList = customMapper.selectAllCustom();

        for (Custom custom :
                customList) {
            custom.setPassword(null);
        }

        Map<String , Object> map = new HashMap<>();
        map.put("list", customList);
        map.put("totalPage", page.getPages());
        return map;
    }

}
