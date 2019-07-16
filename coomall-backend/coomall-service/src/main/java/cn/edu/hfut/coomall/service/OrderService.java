package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.OrderMapper;
import cn.edu.hfut.coomall.entity.Order;
import cn.edu.hfut.coomall.entity.Order_Product;
import cn.edu.hfut.coomall.service.exception.OrderNotFoundException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 葛学文
 * @date 2019/7/15 16:22
 */
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public List<Order> getOrderByState(Integer state) {
        return orderMapper.selectOrderByState(state);
    }

    public Order getOrderByID(Integer orderID) {
        Order order = orderMapper.selectOrderByID(orderID);
        if (order == null) {
            throw new OrderNotFoundException(orderID);
        }
        return order;
    }

    public Map<String, Object> getOrderByCustomIDAndState(Integer customID, Integer state,
                                                          Integer currentPage, Integer limit) {
        Page page = PageHelper.startPage(currentPage, limit);
        List<Order> orderList = orderMapper.selectOrderByCustomIDAndState(customID, state);
        Integer totalPage = page.getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("list", orderList);
        map.put("totalPage", totalPage);
        return map;
    }

    public Map<String, Object> getOrderByMerchantIDAndState(Integer merchantID, Integer state,
                                                          Integer currentPage, Integer limit) {
        Page page = PageHelper.startPage(currentPage, limit);
        List<Order> orderList = orderMapper.selectOrderByMerchantIDAndState(merchantID, state);
        Integer totalPage = page.getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("list", orderList);
        map.put("totalPage", totalPage);
        return map;
    }

    public Map<String, Object> getByCustomIDAndStateAndTime(Integer merchantID, Integer state,
                                                            Integer currentPage, Integer limit, String beginTime, String endTime) {
        Page page = PageHelper.startPage(currentPage, limit);
        List<Order> orderList = orderMapper.selectOrderByCustomIDAndStateAndTime(merchantID, state,beginTime,endTime);
        Integer totalPage = page.getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("list", orderList);
        map.put("totalPage", totalPage);
        return map;
    }

    public Integer addOrderByProduct(Order order) {
         orderMapper.insertOrder(order);
         Integer orderID = orderMapper.getOrderID();
         return orderID;
    }

    public void addOrder_Product(Order_Product order_product) {
        orderMapper.insertOrder_Product(order_product);
    }

    public void changeStateByOrderID(Integer orderID, Integer state, String sendTime,
                                     String completeTime, String cancelTime, String returnTime){
        orderMapper.changeStateByOrderID(orderID,state,sendTime,completeTime,cancelTime,returnTime);
    }
}
