package cn.edu.hfut.coomall.web.custom.bean;

import cn.edu.hfut.coomall.entity.Order;
import cn.edu.hfut.coomall.entity.OrderReturn;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/7/15 17:12
 */
public class GetByCustomIDAndStateRespBean {

    private Integer totalPage;
    private List<OrderReturn> orderReturnList;

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<OrderReturn> getOrderReturnList() {
        return orderReturnList;
    }

    public void setOrderReturnList(List<OrderReturn> orderReturnList) {
        this.orderReturnList = orderReturnList;
    }
}
