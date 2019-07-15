package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.OrderMapper;
import cn.edu.hfut.coomall.entity.Order;
import cn.edu.hfut.coomall.service.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
