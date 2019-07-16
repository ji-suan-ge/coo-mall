package cn.edu.hfut.coomall.web.common.controller;

import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.CustomService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.common.bean.GetCustomByIDReqBean;
import cn.edu.hfut.coomall.web.common.bean.GetCustomByIDRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/custom")
public class CommonCustomController {

    @Autowired
    CustomService customService;

    @LoginRequired
    @PostMapping("/getByID")
    public Message getCustomByID(@RequestBody @Valid
                                         GetCustomByIDReqBean getCustomByIDReqBean) {

        Integer customID = getCustomByIDReqBean.getCustomID();

        Custom custom = customService.getCustomByID(customID);
        GetCustomByIDRespBean getProductByIDRespBean = new GetCustomByIDRespBean();
        getProductByIDRespBean.setCustom(custom);

        return ResultUtil.success(getProductByIDRespBean);
    }
}
