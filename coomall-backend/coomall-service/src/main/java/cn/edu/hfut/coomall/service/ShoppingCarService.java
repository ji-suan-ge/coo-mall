package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.ShoppingCarMapper;
import cn.edu.hfut.coomall.entity.ShoppingCar;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 葛学文
 * @date 2019/7/14 21:53
 */
@Service
public class ShoppingCarService {
    @Autowired
    ShoppingCarMapper shoppingCarMapper;

    public void saveShoppingCar(ShoppingCar shoppingCar) {
        shoppingCarMapper.insertShoppingCar(shoppingCar);
    }

    public void deleteShoppingCar(ShoppingCar shoppingCar){
        shoppingCarMapper.deleteShoppingCar(shoppingCar);
    }

    public Map<String, Object> findShoppingCar(Integer customID,Integer currentPage,Integer limit){
        Page page = PageHelper.startPage(currentPage, limit);
        List<ShoppingCar> shoppingCarList = shoppingCarMapper.findShoppingCar(customID);

        Map<String , Object> map = new HashMap<>();
        map.put("list", shoppingCarList);
        map.put("totalPage", page.getPages());
        return map;
    }

    public void updateShoppingCar(Integer customID, Integer productID, Integer changeNumber){
        shoppingCarMapper.updateShoppingCar(customID, productID, changeNumber);
    }

    public ShoppingCar selectShoppingCar(Integer customID, Integer productID){
        return shoppingCarMapper.selectShoppingCarNumber(customID, productID);
    }

}



