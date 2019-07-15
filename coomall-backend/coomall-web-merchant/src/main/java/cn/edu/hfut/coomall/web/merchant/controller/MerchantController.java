package cn.edu.hfut.coomall.web.merchant.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.MerchantService;
import cn.edu.hfut.coomall.service.exception.BaseException;
import cn.edu.hfut.coomall.service.exception.MerchantNotFoundException;
import cn.edu.hfut.coomall.util.PasswordUtil;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.merchant.bean.EditMerchantReqBean;
import cn.edu.hfut.coomall.web.merchant.bean.LoginReqBean;
import cn.edu.hfut.coomall.web.merchant.bean.RegisterMerchantReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/7/14 20:56
 */
@RequestMapping("/merchant")
@RestController
public class MerchantController {

    @Autowired
    CooMallConfig cooMallConfig;
    @Autowired
    MerchantService merchantService;

    @PostMapping("/login")
    public Message login(@RequestBody @Valid LoginReqBean loginReqBean,
                         HttpSession httpSession) {

        String phoneNumber = loginReqBean.getPhoneNumber();
        String password = loginReqBean.getPassword();

        Merchant merchant;
        try {
            merchant = merchantService.login(phoneNumber, password);
        } catch (MerchantNotFoundException e) {
            return ResultUtil.error(4101, e.getMessage());
        } catch (BaseException e) {
            return ResultUtil.error(4102, e.getMessage());
        }

        httpSession.setAttribute(cooMallConfig.getIdentifier(), merchant);
        merchant.setPassword(null);
        return ResultUtil.success(merchant);
    }

    @PostMapping("/logout")
    public Message login(HttpSession httpSession) {

        httpSession.removeAttribute(cooMallConfig.getIdentifier());
        return ResultUtil.success();
    }

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @PostMapping("/add")
    public Message registerMerchant(@RequestBody @Valid RegisterMerchantReqBean registerMerchantReqBean) {
        String shopName = registerMerchantReqBean.getShopName();
        String ownerName = registerMerchantReqBean.getOwnerName();
        String phoneNumber = registerMerchantReqBean.getPhoneNumber();
        String intro = registerMerchantReqBean.getIntro();
        String password = registerMerchantReqBean.getPassword();
        String address = registerMerchantReqBean.getAddress();
        String identityNumber = registerMerchantReqBean.getIdentityNumber();
        String identityPhoto = registerMerchantReqBean.getIdentityPhoto();
        String email = registerMerchantReqBean.getEmail();

        //加密存储
        password = PasswordUtil.encode(password);

        Merchant merchant = new Merchant(shopName, ownerName, phoneNumber, intro, password,
                address, identityNumber, identityPhoto, email);
        merchantService.saveMerchant(merchant);

        return ResultUtil.success();
    }

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @LoginRequired
    @PostMapping("/edit")
    public Message editMerchant(@RequestBody @Valid EditMerchantReqBean editMerchantReqBean,
                              HttpSession httpSession) {

        String shopName = editMerchantReqBean.getShopName();
        String phoneNumber = editMerchantReqBean.getPhoneNumber();
        String intro = editMerchantReqBean.getIntro();
        String address = editMerchantReqBean.getAddress();
        String email = editMerchantReqBean.getEmail();


        if (shopName == null && phoneNumber == null && intro == null
                && address == null && email == null) {
            return ResultUtil.error(4001, "参数不足");
        }
        Merchant merchant = (Merchant) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer merchantID = merchant.getID();
        merchantService.editMerchant(merchantID, shopName, phoneNumber, intro, address, email);
        return ResultUtil.success();
    }
}
