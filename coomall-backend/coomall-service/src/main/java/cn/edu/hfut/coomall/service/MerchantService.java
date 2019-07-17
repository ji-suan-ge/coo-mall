package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.MerchantMapper;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.service.exception.InvalidPasswordException;
import cn.edu.hfut.coomall.service.exception.MerchantNotFoundException;
import cn.edu.hfut.coomall.util.PasswordUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 葛学文
 * @date 2019/7/14 15:00
 */
@Service
public class MerchantService {

    @Autowired
    MerchantMapper merchantMapper;

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 保存商家
     */
    public void saveMerchant(Merchant merchant) {

        merchantMapper.insertMerchant(merchant);
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 merchantID 删除商家
     */
    public void removeMerchantByID(Integer merchantID) {

        merchantMapper.deleteMerchantByID(merchantID);
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 merchantID 查找商家
     */
    public Merchant getMerchantByID(Integer merchantID) {

        Merchant merchant = merchantMapper.selectMerchantByID(merchantID);
        if (merchant == null) {
            throw new MerchantNotFoundException(merchantID);
        }
        return merchant;
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 phoneNumber 查找商家
     */
    private Merchant getMerchantByPhoneNumber(String phoneNumber) {

        Merchant merchant = merchantMapper.selectMerchantByPhoneNumber(phoneNumber);
        if (merchant == null) {
            throw new MerchantNotFoundException(phoneNumber);
        }
        return merchant;
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 state 查找商家
     */
    private List<Merchant> getMerchantByState(Integer state) {
        return merchantMapper.selectMerchantByState(state);
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 获取所有商家列表
     * 修改 by 郑力煽 7/15
     */
    public Map<String, Object> getMerchantByState(Integer state, Integer currentPage, Integer limit) {

        Page page = PageHelper.startPage(currentPage, limit);
        List<Merchant> merchantList = merchantMapper.selectMerchantByState(state);

        for (Merchant merchant :
                merchantList) {
            merchant.setPassword(null);
        }

        Map<String , Object> map = new HashMap<>();
        map.put("list", merchantList);
        map.put("totalPage", page.getPages());
        return map;
    }

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 商家登录
     */
    public Merchant login(String phoneNumber, String password) {

        // 已经检查 merchant 是否为空
        Merchant merchant = getMerchantByPhoneNumber(phoneNumber);

        if (!PasswordUtil.checkPassword(password, merchant.getPassword())) {
            throw new InvalidPasswordException(phoneNumber);
        }

        return merchant;
    }

    /**
     * @author 郑力煽
     * @data 2019/7/15
     * 商家状态修改
     */
    public void updateMerchantState(Integer merchantID) {

        merchantMapper.updateMerchantStateByID(merchantID);
    }

    /**
     * @author 郑力煽
     * @data 2019/7/15
     * 商家信息修改
     */
    public void editMerchant(Integer merchantID, String shopName, String phoneNumber, String intro,
                             String address, String email) {
        merchantMapper.updateMerchant(merchantID, shopName,phoneNumber,intro,address,email);
    }

    /**
     * @author 郑力煽
     * @data 2019/7/16
     */
    public Map<String, Object> search(String shopName, String ownerName,String intro, String address,String identityNumber
                       ,String email,Integer limit, Integer currentPage) {
        Page page = PageHelper.startPage(currentPage, limit);
        List<Merchant> merchantList = merchantMapper.search(shopName,ownerName,intro,address,identityNumber,email);
        for (Merchant merchant :
                merchantList) {
            merchant.setPassword(null);
        }
        Map<String , Object> map = new HashMap<>();
        map.put("totalPage", page.getPages());
        map.put("list", merchantList);
        return map;

    }
    public void editPassword(String email, String newPassword) {

        String encodePassword = PasswordUtil.encode(newPassword);
        merchantMapper.updatePasswordByEmail(email, encodePassword);
    }

    public Merchant getMerchantByEmail(String email) {
        return merchantMapper.selectMerchantByEmail(email);
    }
}
