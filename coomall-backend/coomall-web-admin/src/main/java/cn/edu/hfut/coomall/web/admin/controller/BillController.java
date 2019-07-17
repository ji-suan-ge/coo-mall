package cn.edu.hfut.coomall.web.admin.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.entity.InternetBill;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.BillService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.admin.bean.GetInternetBillRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑力煽
 * @date 2019/7/14 15:30
 */
@RequestMapping("/bill")
@RestController
public class BillController {

    @Autowired
    CooMallConfig cooMallConfig;
    @Autowired
    BillService billService;

    @PostMapping("/get")
    public Message login() {
        GetInternetBillRespBean getInternetBillRespBean = new GetInternetBillRespBean();
        InternetBill internetBill = billService.getInterneBill();
        Integer customNumber = internetBill.getCustomNumber();
        Integer allSale = internetBill.getAllSale();
        Integer merchantNumber = internetBill.getMerchantNumber();
        Integer productNumber = internetBill.getProductNumber();
        getInternetBillRespBean.setCustomNumber(customNumber);
        getInternetBillRespBean.setAllSale(allSale);
        getInternetBillRespBean.setMerchantNumber(merchantNumber);
        getInternetBillRespBean.setProductNumber(productNumber);
        return ResultUtil.success(getInternetBillRespBean);
    }
}
