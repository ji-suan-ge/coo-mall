package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.AddressMapper;
import cn.edu.hfut.coomall.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 郑力煽
 * @date 2019/7/16
 */
@Service
public class AddressService {

    @Autowired
    AddressMapper addressMapper;
    public void saveAddress(Address address) {

        addressMapper.insertAddress(address);
    }
}
