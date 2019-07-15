package cn.edu.hfut.coomall.web.custom.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.entity.ShoppingCar;
import cn.edu.hfut.coomall.service.ShoppingCarService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.custom.bean.AddShoppingCarReqBean;
import cn.edu.hfut.coomall.web.custom.bean.DeleteShoppingCarReqBean;
import cn.edu.hfut.coomall.web.custom.bean.UpdateShoppingCarReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */

@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCarController {

    @Autowired
    CooMallConfig cooMallConfig;
    @Autowired
    ShoppingCarService shoppingCarService;

    @LoginRequired
    @PostMapping("/add")
    public Message addShoppingCar(@RequestBody @Valid AddShoppingCarReqBean addShoppingCarReqBean,
                                  HttpSession httpSession) {

        Integer productID = addShoppingCarReqBean.getProductID();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();

        ShoppingCar shoppingCar = new ShoppingCar(productID, customID, 1);
        shoppingCarService.saveShoppingCar(shoppingCar);

        return ResultUtil.success();
    }

    @LoginRequired
    @PostMapping("/delete")
    public Message deleteShoppingCar(@RequestBody @Valid DeleteShoppingCarReqBean deleteShoppingCarReqBean,
                                  HttpSession httpSession) {

        Integer productID = deleteShoppingCarReqBean.getProductID();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();
        ShoppingCar shoppingCar = new ShoppingCar(productID, customID, 0);
        shoppingCarService.deleteShoppingCar(shoppingCar);

        return ResultUtil.success();
    }

    @LoginRequired
    @PostMapping("/find")
    public Message findShoppingCar(HttpSession httpSession) {

        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();
        List<ShoppingCar> shoppingCarList = shoppingCarService.findShoppingCar(customID);

        return ResultUtil.success(shoppingCarList);
    }

    @LoginRequired
    @PostMapping("/update")
    public Message updateShoppingCar(@RequestBody @Valid UpdateShoppingCarReqBean updateShoppingCarReqBean,
                                     HttpSession httpSession) {

        Integer productID = updateShoppingCarReqBean.getProductID();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();
        Integer changeNumber = updateShoppingCarReqBean.getChangeNumber();
        ShoppingCar shoppingCar = shoppingCarService.selectShoppingCar(customID, productID);
        Integer number =shoppingCar.getNumber();
        changeNumber = changeNumber + number;
        if (changeNumber <= 0){
            return ResultUtil.error(4300,"商品数量小于1");
        }
        shoppingCarService.updateShoppingCar(customID,productID,changeNumber);
        return ResultUtil.success();
    }
}

