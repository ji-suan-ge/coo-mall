package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.AddressMapper;
import cn.edu.hfut.coomall.entity.Address;
import cn.edu.hfut.coomall.entity.Merchant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void deleteAddress(Integer addressID) {

        addressMapper.deleteAddress(addressID);
    }

    public Map<String, Object> findAddress(Integer customID, Integer currentPage, Integer limit) {

        Page page = PageHelper.startPage(currentPage, limit);
        List<Address> addressList = addressMapper.findAddress(customID);

        Map<String , Object> map = new HashMap<>();
        map.put("list", addressList);
        map.put("totalPage", page.getPages());
        return map;
    }


}
