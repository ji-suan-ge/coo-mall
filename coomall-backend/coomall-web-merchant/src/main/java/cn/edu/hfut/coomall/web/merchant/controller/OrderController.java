package cn.edu.hfut.coomall.web.merchant.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Merchant;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.Order;
import cn.edu.hfut.coomall.entity.OrderReturn;
import cn.edu.hfut.coomall.service.OrderService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.merchant.bean.ChangeOrderStateReqBean;
import cn.edu.hfut.coomall.web.merchant.bean.GetByMerchantIDAndStateRespBean;
import cn.edu.hfut.coomall.web.merchant.bean.GetByOrderMerchantIDAndStateAndTimeBean;
import cn.edu.hfut.coomall.web.merchant.bean.GetByOrderMerchantIDAndStateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 葛学文
 * @date 2019/7/15 16:08
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    CooMallConfig cooMallConfig;

    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/getByMerchantIDAndState")
    public Message getByOrderMerchantIDAndState(@RequestBody @Valid GetByOrderMerchantIDAndStateBean get,
                                                HttpSession httpSession) {

        Integer state = get.getState();
        Integer currentPage = get.getCurrentPage();
        Integer limit = get.getLimit();
        Merchant merchant = (Merchant) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer merchantID = merchant.getID();
        Map<String, Object> map = orderService.getOrderByMerchantIDAndState(merchantID, state, currentPage, limit);
        Integer totalPage = (Integer) map.get("totalPage");
        List<OrderReturn> orderReturnList = (List<OrderReturn>) map.get("list");
        GetByMerchantIDAndStateRespBean getResp = new GetByMerchantIDAndStateRespBean();
        getResp.setOrderReturnList(orderReturnList);
        getResp.setTotalPage(totalPage);
        return ResultUtil.success(getResp);
    }

    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/getByTime")
    public Message getByOrderMerchantIDAndStateAndTime(@RequestBody @Valid GetByOrderMerchantIDAndStateAndTimeBean get,
                                                HttpSession httpSession) {

        String beginTime = get.getBeginTime();
        String endTime = get.getEndTime();
        Integer state = get.getState();
        Integer currentPage = get.getCurrentPage();
        Integer limit = get.getLimit();
        Merchant merchant = (Merchant) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer merchantID = merchant.getID();
        Map<String, Object> map = orderService.selectOrderByMerchantIDAndStateAndTime(merchantID,state,
                currentPage,limit,beginTime,endTime);
        Integer totalPage = (Integer) map.get("totalPage");
        List<OrderReturn> orderReturnList = (List<OrderReturn>) map.get("list");
        GetByMerchantIDAndStateRespBean getResp = new GetByMerchantIDAndStateRespBean();
        getResp.setTotalPage(totalPage);
        getResp.setOrderReturnList(orderReturnList);
        return ResultUtil.success(getResp);
    }

        @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/changeState")
    public Message changeOrderState(@RequestBody @Valid ChangeOrderStateReqBean changeOrderStateReqBean,
                                                HttpSession httpSession) {

        Integer state = changeOrderStateReqBean.getState();
        Integer orderID = changeOrderStateReqBean.getOrderID();
        Order order = orderService.getOrderByID(orderID);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendTime = order.getSendTime();
            if (state == 3) {
                sendTime = df.format(new Date());
                order.setSendTime(sendTime);
            };
        String completeTime = order.getCompleteTime();
            if (state == 5) {
                completeTime = df.format(new Date());
                order.setCompleteTime(completeTime);
            };
        String cancelTime = order.getCancelTime();
            if (state == 0) {
                cancelTime = df.format(new Date());
                order.setCancelTime(cancelTime);
            }
        String returnTime = order.getReturnTime();
            if (state == 8) {
                returnTime = df.format(new Date());
                order.setReturnTime(returnTime);
            }
        Merchant merchant = (Merchant) httpSession.getAttribute(cooMallConfig.getIdentifier());
        if (!order.getMerchantID().equals(merchant.getID())) {
            return ResultUtil.error(4200, "不能修改此订单");
        }
        orderService.changeStateByOrderID(orderID,state,sendTime,completeTime,cancelTime,returnTime);
        return ResultUtil.success();
    }
}
