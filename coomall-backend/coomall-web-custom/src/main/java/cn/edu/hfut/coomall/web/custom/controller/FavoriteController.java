package cn.edu.hfut.coomall.web.custom.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Favorite;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.FavoriteService;
import cn.edu.hfut.coomall.service.exception.BaseException;
import cn.edu.hfut.coomall.service.exception.CustomNotFoundException;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.custom.bean.AddFavoriteReqBean;
import cn.edu.hfut.coomall.web.custom.bean.DeleteFavoriteReqBean;
import cn.edu.hfut.coomall.web.custom.bean.GetFavoriteRespBean;
import cn.edu.hfut.coomall.web.custom.bean.getFavoriteReqBean;
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
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    CooMallConfig cooMallConfig;
    @Autowired
    FavoriteService favoriteService;

    @LoginRequired
    @PostMapping("/add")
    public Message addFavorite(@RequestBody @Valid AddFavoriteReqBean addFavoriteReqBean,
                         HttpSession httpSession) {

        Integer productID = addFavoriteReqBean.getProductID();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();

        httpSession.setAttribute(cooMallConfig.getIdentifier(), custom);
        Favorite favorite = new Favorite(productID, customID);
        favoriteService.saveFavorite(favorite);

        return ResultUtil.success();
    }

    @LoginRequired
    @PostMapping("/get")
    public Message getFavoriteByCustomID(HttpSession httpSession) {

        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();
        List<Favorite> favoriteList =  favoriteService.getFavoriteByID(customID);

        //GetFavoriteRespBean getFavoriteRespBean = new GetFavoriteRespBean();
        //getFavoriteRespBean.getFavorite(favoriteList);

        return ResultUtil.success(favoriteList);

    }

    @LoginRequired
    @PostMapping("/delete")
    public Message deleteFavoriteByProductID(@RequestBody @Valid DeleteFavoriteReqBean
                                                         deleteFavoriteReqBean,HttpSession httpSession) {

        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();
        Integer productID = deleteFavoriteReqBean.getProductID();
        Favorite favorite = new Favorite(productID, customID);
        favoriteService.deleteFavoriteByProductID(favorite);
        return ResultUtil.success();

    }
}
