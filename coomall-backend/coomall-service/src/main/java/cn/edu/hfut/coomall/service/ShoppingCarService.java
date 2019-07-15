package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.ShoppingCarMapper;
import cn.edu.hfut.coomall.entity.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ShoppingCar> findShoppingCar(Integer customID){
        return shoppingCarMapper.findShoppingCar(customID);
    }

}



