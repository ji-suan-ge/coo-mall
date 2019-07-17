package cn.edu.hfut.coomall.web.common.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.MerchantService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.common.bean.GetCustomByIDReqBean;
import cn.edu.hfut.coomall.web.common.bean.GetCustomByIDRespBean;
import cn.edu.hfut.coomall.web.common.bean.GetMerchantNameByIDReqBean;
import cn.edu.hfut.coomall.web.common.bean.GetMerchantNameByIDRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 郑力煽
 * @date 2019/7/16
 */
@RestController
@RequestMapping("/merchant")
public class CommonMerchantController {

    @Autowired
    MerchantService merchantService;
    @Autowired
    CooMallConfig cooMallConfig;

    @PostMapping("/getByID")
    public Message getMerchantNameByID(@RequestBody @Valid
                                               GetMerchantNameByIDReqBean getMerchantNameByIDReqBean) {

        Integer merchantID = getMerchantNameByIDReqBean.getMerchantID();

        Merchant merchant = merchantService.getMerchantByID(merchantID);
        GetMerchantNameByIDRespBean getMerchantNameByIDRespBean = new GetMerchantNameByIDRespBean();

        getMerchantNameByIDRespBean.setShopName(merchant.getShopName());
        getMerchantNameByIDRespBean.setIntro(merchant.getIntro());
        getMerchantNameByIDRespBean.setScore(merchant.getScore());

        return ResultUtil.success(getMerchantNameByIDRespBean);
    }
}


