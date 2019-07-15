package cn.edu.hfut.coomall.web.admin.controller;

import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.MerchantService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.admin.bean.GetAllMerchantReqBean;
import cn.edu.hfut.coomall.web.admin.bean.GetAllMerchantRespBean;
import cn.edu.hfut.coomall.web.admin.bean.GetMerchantByIDReqBean;
import cn.edu.hfut.coomall.web.admin.bean.RemoveMerchantByIDReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @LoginRequired
    @PostMapping("/remove")
    public Message removeMerchantByID(@RequestBody @Valid
                                              RemoveMerchantByIDReqBean removeCustomByIDReqBean) {

        Integer merchantID = removeCustomByIDReqBean.getMerchantID();
        merchantService.removeMerchantByID(merchantID);
        return ResultUtil.success();
    }

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/getAll")
    public Message getAllMerchant(@RequestBody @Valid
                                          GetAllMerchantReqBean getAllMerchantReqBean) {

        Integer currentPage = getAllMerchantReqBean.getCurrentPage();
        Integer limit = getAllMerchantReqBean.getLimit();
        Map<String, Object> map = merchantService.getAllMerchant(currentPage, limit);

        Integer totalPage = (Integer) map.get("totalPage");
        List<Merchant> merchantList = (List<Merchant>) map.get("list");
        GetAllMerchantRespBean getAllMerchantRespBean =
                new GetAllMerchantRespBean();
        getAllMerchantRespBean.setMerchantList(merchantList);
        getAllMerchantRespBean.setTotalPage(totalPage);

        return ResultUtil.success(getAllMerchantRespBean);
    }

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/agree")
    public Message updateMerchantState(@RequestBody @Valid
                                               GetMerchantByIDReqBean getMerchantReqBean) {

        Integer merchantID = getMerchantReqBean.getMerchantID();
        merchantService.updateMerchantState(merchantID);

        return ResultUtil.success();
    }
}
