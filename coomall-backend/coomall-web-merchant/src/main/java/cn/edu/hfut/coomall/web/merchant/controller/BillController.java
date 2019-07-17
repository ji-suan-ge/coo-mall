package cn.edu.hfut.coomall.web.merchant.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.BillService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.merchant.bean.GetBillReqBean;
import cn.edu.hfut.coomall.web.merchant.bean.GetBillRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 郑力煽
 * @date 2019/7/16
 */
@RequestMapping("/bill")
@RestController
public class BillController {

    @Autowired
    CooMallConfig cooMallConfig;
    @Autowired
    BillService billService;

    @LoginRequired
    @PostMapping("/get")
    public Message get(@RequestBody @Valid GetBillReqBean getBillReqBean,
                       HttpSession httpSession) {

        Merchant merchant = (Merchant) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer merchantID = merchant.getID();
        Integer year = getBillReqBean.getYear();
        GetBillRespBean getBillRespBean = new GetBillRespBean();
        getBillRespBean.setBillList(billService.getBill(merchantID,year));
        return ResultUtil.success(getBillRespBean);
    }
}
