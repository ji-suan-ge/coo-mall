package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.AdminMapper;
import cn.edu.hfut.coomall.dao.BillMapper;
import cn.edu.hfut.coomall.entity.Bill;
import cn.edu.hfut.coomall.entity.InternetBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 郑力煽
 * @date 2019/7/16
 */
@Service
public class BillService {

    @Autowired
    BillMapper billMapper;

    /**
     * @author 郑力煽
     * @data 2019/7/16
     */
    public List<Bill> getBill(Integer merchantID, Integer year) {
        return billMapper.getBill(merchantID,year);
    }

    /**
     * @author 郑力煽
     * @data 2019/7/16
     */
    public InternetBill getInterneBill() {
        return billMapper.getInternetBill();
    }
}
