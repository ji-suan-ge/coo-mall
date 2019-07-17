package cn.edu.hfut.coomall.web.custom.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.*;
import cn.edu.hfut.coomall.service.OrderService;
import cn.edu.hfut.coomall.service.ProductService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.custom.bean.*;
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
    ProductService productService;
    @Autowired
    CooMallConfig cooMallConfig;


    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/addByProduct")
    public Message addOrderByProduct(@RequestBody @Valid AddOrderByProductReqBean addOrderByProductReqBean,
                                              HttpSession httpSession) {

        Integer amount = addOrderByProductReqBean.getAmount();
        String style = addOrderByProductReqBean.getStyle();
        Integer productID = addOrderByProductReqBean.getProductID();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();
        Integer merchantID = productService.getMerchantID(productID);
        Integer addressID = addOrderByProductReqBean.getAddressID();
        String remark = addOrderByProductReqBean.getRemark();

        Order order = new Order(customID,merchantID,addressID,remark);
        Integer orderID = orderService.addOrderByProduct(order);

        Order_Product order_product = new Order_Product(orderID,productID,style, amount);
        orderService.addOrder_Product(order_product);
        return ResultUtil.success();
    }
    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/getByCustomIDAndState")
    public Message getByOrderCustomIDAndState(@RequestBody @Valid GetByOrderCustomIDAndStateBean get,
                                                HttpSession httpSession) {

        Integer state = get.getState();
        Integer customID = get.getCustomID();
        Integer currentPage = get.getCurrentPage();
        Integer limit = get.getLimit();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        if (!customID.equals(custom.getID())) {
            return ResultUtil.error(4200, "不能查看此订单");
        }
        Map<String, Object> map = orderService.getOrderByCustomIDAndState(customID, state, currentPage, limit);
        Integer totalPage = (Integer) map.get("totalPage");
        List<OrderReturn> orderReturnList = (List<OrderReturn>) map.get("list");
        GetByCustomIDAndStateRespBean getResp = new GetByCustomIDAndStateRespBean();
        getResp.setOrderReturnList(orderReturnList);
        getResp.setTotalPage(totalPage);
        return ResultUtil.success(getResp);
    }

    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/getByCustomIDAndStateAndTime")
    public Message getByCustomIDAndStateAndTime(@RequestBody @Valid GetByCustomIDAndStateAndTimeBean get,
                                              HttpSession httpSession) {

        Integer state = get.getState();
        Integer currentPage = get.getCurrentPage();
        Integer limit = get.getLimit();
        String beginTime = get.getBeginTime();
        String endTime = get.getEndTime();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();
        if (!customID.equals(custom.getID())) {
            return ResultUtil.error(4200, "不能查看此订单");
        }
        Map<String, Object> map = orderService.getByCustomIDAndStateAndTime(customID, state, currentPage,
                limit ,beginTime,endTime);
        Integer totalPage = (Integer) map.get("totalPage");
        List<OrderReturn> orderReturnList = (List<OrderReturn>) map.get("list");
        GetByCustomIDAndStateRespBean getResp = new GetByCustomIDAndStateRespBean();
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
            Order_Product order_product = productService.getStyleByOrderID(order.getID());
            Integer productID = order_product.getProductID();
            Integer number = order_product.getAmount();
            productService.updateProductNumber(productID,number);
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
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        if (!order.getCustomID().equals(custom.getID())) {
            return ResultUtil.error(4200, "不能修改此订单");
        }
        orderService.changeStateByOrderID(orderID,state,sendTime,completeTime,cancelTime,returnTime);
        return ResultUtil.success();
    }
}
