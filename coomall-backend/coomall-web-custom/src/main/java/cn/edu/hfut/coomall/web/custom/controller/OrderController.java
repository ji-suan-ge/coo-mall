package cn.edu.hfut.coomall.web.custom.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.Order;
import cn.edu.hfut.coomall.service.OrderService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.custom.bean.GetByCustomIDAndStateRespBean;
import cn.edu.hfut.coomall.web.custom.bean.GetByOrderCustomIDAndStateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
        List<Order> orderList = (List<Order>) map.get("list");
        GetByCustomIDAndStateRespBean getResp = new GetByCustomIDAndStateRespBean();
        getResp.setOrderList(orderList);
        getResp.setTotalPage(totalPage);
        return ResultUtil.success(getResp);
    }
}
