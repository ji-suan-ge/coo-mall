package cn.edu.hfut.coomall.service.Impl;

import cn.edu.hfut.coomall.dao.MerchantMapper;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.service.Impl.exception.MerchantNotFoundException;
import cn.edu.hfut.coomall.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 15:18
 */
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantMapper merchantMapper;

    @Override
    public void saveMerchant(Merchant merchant) {

        merchantMapper.insertMerchant(merchant);
    }

    @Override
    public void removeMerchantByID(Integer merchantID) {

        merchantMapper.deleteMerchantByID(merchantID);
    }

    @Override
    public Merchant getMerchantByID(Integer merchantID) {

        Merchant merchant = merchantMapper.selectMerchantByID(merchantID);
        if (merchant == null) {
           throw new MerchantNotFoundException(merchantID);
        }
        return merchant;
    }

    @Override
    public List<Merchant> getAllMerchant() {

        return merchantMapper.selectAllMerchant();
    }
}
