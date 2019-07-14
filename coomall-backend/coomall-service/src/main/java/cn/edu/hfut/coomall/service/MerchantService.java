package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.entity.Merchant;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/14 15:00
 */
public interface MerchantService {

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 保存商家
     */
    void saveMerchant(Merchant merchant);

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 merchantID 删除商家
     */
    void removeMerchantByID(Integer merchantID);

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 根据 merchantID 查找商家
     */
    Merchant getMerchantByID(Integer merchantID);

    /**
     * @author 葛学文
     * @data 2019/7/14
     * 获取所有商家列表
     */
    List<Merchant> getAllMerchant();

}
