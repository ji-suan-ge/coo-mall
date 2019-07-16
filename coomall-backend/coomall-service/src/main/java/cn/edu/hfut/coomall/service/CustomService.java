package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.CustomMapper;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.service.exception.CustomNotFoundException;
import cn.edu.hfut.coomall.service.exception.InvalidPasswordException;
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
    public Map<String, Object> getCustomByState(Integer state, Integer currentPage, Integer limit) {
        Page page = PageHelper.startPage(currentPage, limit);
        List<Custom> customList = customMapper.selectCustomByState(state);

        for (Custom custom :
                customList) {
            custom.setPassword(null);
        }

        Map<String , Object> map = new HashMap<>();
        map.put("list", customList);
        map.put("totalPage", page.getPages());
        return map;
    }

    public Custom login(String phoneNumber, String password) {

        // 已经检查 custom 是否为空
        Custom custom = getCustomByPhoneNumber(phoneNumber);

        if (!PasswordUtil.checkPassword(password, custom.getPassword())) {
            throw new InvalidPasswordException(phoneNumber);
        }

        return custom;
    }

    /**
     * @author 郑力煽
     * @data 2019/7/14
     * 修改客户信息
     */
    public void editCustom(Integer customID, String nickname, Integer gender, String avatar,
                           String phoneNumber, String email) {
        customMapper.updateProduct(customID,nickname,gender,avatar,phoneNumber,email);

    }

    /**
     * @author 郑力煽
     * @data 2019/7/14
     */
    public Map<String, Object> getByNickNameOrPhoneNumberOrEmail(String nickName, String phoneNumber, String email,Integer currentPage, Integer limit){

        Page page = PageHelper.startPage(currentPage, limit);
        List<Custom> customList = customMapper.getByNickNameOrPhoneNumberOrEmail(nickName,phoneNumber,email);
        for (Custom custom :
                customList) {
            custom.setPassword(null);
        }
        Map<String , Object> map = new HashMap<>();
        map.put("totalPage", page.getPages());
        map.put("list", customList);
        return map;

    }
}
