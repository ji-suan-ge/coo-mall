package cn.edu.hfut.coomall.web.admin.controller;

import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.MerchantService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.admin.bean.RemoveMerchantByIDReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @PostMapping("/remove")
    public Message removeMerchantByID(@RequestBody @Valid
                                              RemoveMerchantByIDReqBean removeCustomByIDReqBean) {

        Integer merchantID = removeCustomByIDReqBean.getMerchantID();
        merchantService.removeMerchantByID(merchantID);
        return ResultUtil.success();
    }
}
