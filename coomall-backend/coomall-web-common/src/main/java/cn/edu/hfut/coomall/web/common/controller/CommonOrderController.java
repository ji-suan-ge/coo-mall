package cn.edu.hfut.coomall.web.common.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Admin;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.Order;
import cn.edu.hfut.coomall.service.OrderService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.common.bean.GetOrderByIDReqBean;
import cn.edu.hfut.coomall.web.common.bean.GetOrderByIDRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/7/15 16:09
 */
@RestController
@RequestMapping("/order")
public class CommonOrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    CooMallConfig cooMallConfig;

    @LoginRequired
    @PostMapping("/getByID")
    public Message getOrderByID(@RequestBody @Valid GetOrderByIDReqBean getOrderByIDReqBean,
                                HttpSession httpSession) {

        Integer orderID = getOrderByIDReqBean.getOrderID();
        Object object = httpSession.getAttribute(cooMallConfig.getIdentifier());
        if (object instanceof Admin) return ResultUtil.error(4200, "不能查看此订单");
        Order order = orderService.getOrderByID(orderID);
        if (object instanceof Custom) {
            Custom custom = (Custom) object;
            if (!custom.getID().equals(order.getCustomID())) {
                return ResultUtil.error(4200, "不能查看此订单");
            }
        }
        GetOrderByIDRespBean getOrderByIDRespBean = new GetOrderByIDRespBean();
        getOrderByIDRespBean.setOrder(order);
        return ResultUtil.success(getOrderByIDRespBean);
    }
}
