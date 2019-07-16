package cn.edu.hfut.coomall.web.admin.controller;

import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.CustomService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.admin.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    CustomService customService;

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/getByState")
    public Message getCustomByState(@RequestBody @Valid
                                        GetAllCustomReqBean getAllCustomReqBean) {

        Integer currentPage = getAllCustomReqBean.getCurrentPage();
        Integer limit = getAllCustomReqBean.getLimit();
        Integer state = getAllCustomReqBean.getState();
        Map<String, Object> map = customService.getCustomByState(state, currentPage, limit);

        Integer totalPage = (Integer) map.get("totalPage");
        List<Custom> customList = (List<Custom>) map.get("list");
        GetAllCustomRespBean getAllCustomRespBean =
                new GetAllCustomRespBean();
        getAllCustomRespBean.setCustomList(customList);
        getAllCustomRespBean.setTotalPage(totalPage);

        return ResultUtil.success(getAllCustomRespBean);
    }

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @LoginRequired
    @PostMapping("/remove")
    public Message removeCustomByID(@RequestBody @Valid
                                            RemoveCustomByIDReqBean removeCustomByIDReqBean) {

        Integer customID = removeCustomByIDReqBean.getCustomID();
        customService.removeCustomByID(customID);
        return ResultUtil.success();
    }

    /**
     * @author 郑力煽
     * @date 2019/7/15
     */
    @SuppressWarnings("unchecked")
    @LoginRequired
    @PostMapping("/search")
    public Message getByNickNameOrPhoneNumberOrEmail(@RequestBody @Valid
                                                             GetByNickNameOrPhoneNumberOrEmailReqBean getByNickNameOrPhoneNumberOrEmailReqBean) {

        String nickName = getByNickNameOrPhoneNumberOrEmailReqBean.getNickName();
        String phoneNumber = getByNickNameOrPhoneNumberOrEmailReqBean.getPhoneNumber();
        String email = getByNickNameOrPhoneNumberOrEmailReqBean.getEmail();
        Integer limit = getByNickNameOrPhoneNumberOrEmailReqBean.getLimit();
        Integer currentPage = getByNickNameOrPhoneNumberOrEmailReqBean.getCurrentPage();

        if (nickName == null && phoneNumber == null && email == null) {
            return ResultUtil.error(4001, "参数不足");
        }
        Map<String, Object> map = customService.getByNickNameOrPhoneNumberOrEmail(
                nickName,phoneNumber,email,currentPage,limit);

        List<Custom> customList = (List<Custom>) map.get("list");
        Integer totalPage = (Integer) map.get("totalPage");
        GetByNickNameOrPhoneNumberOrEmailRespBean getByNickNameOrPhoneNumberOrEmailRespBean = new GetByNickNameOrPhoneNumberOrEmailRespBean();
        getByNickNameOrPhoneNumberOrEmailRespBean.setCustomList(customList);
        getByNickNameOrPhoneNumberOrEmailRespBean.setTotalPage(totalPage);

        return ResultUtil.success(getByNickNameOrPhoneNumberOrEmailRespBean);

    }
}
