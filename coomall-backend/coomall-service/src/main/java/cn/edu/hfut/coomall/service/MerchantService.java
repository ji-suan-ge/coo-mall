package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.MerchantMapper;
import cn.edu.hfut.coomall.entity.Admin;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.service.exception.InvalidPasswordException;
import cn.edu.hfut.coomall.service.exception.MerchantNotFoundException;
import cn.edu.hfut.coomall.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 获取所有商家列表
     */
    public List<Merchant> getAllMerchant() {

        return merchantMapper.selectAllMerchant();
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

}
