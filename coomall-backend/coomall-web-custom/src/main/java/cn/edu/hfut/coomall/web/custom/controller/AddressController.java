package cn.edu.hfut.coomall.web.custom.controller;

import cn.edu.hfut.coomall.config.CooMallConfig;
import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.entity.Address;
import cn.edu.hfut.coomall.entity.Custom;
import cn.edu.hfut.coomall.entity.Message;
import cn.edu.hfut.coomall.service.AddressService;
import cn.edu.hfut.coomall.util.ResultUtil;
import cn.edu.hfut.coomall.web.custom.bean.AddAddressReqBean;
import cn.edu.hfut.coomall.web.custom.bean.DeleteAddressReqBean;
import cn.edu.hfut.coomall.web.custom.bean.FindAddressReqBean;
import cn.edu.hfut.coomall.web.custom.bean.FindAddressRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author 郑力煽
 * @date 2019/7/16
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    CooMallConfig cooMallConfig;
    @Autowired
    AddressService addressService;

    @LoginRequired
    @PostMapping("/add")
    public Message addAddress(@RequestBody @Valid AddAddressReqBean addAddressReqBean,
                         HttpSession httpSession) {
        String getaddress = addAddressReqBean.getAddress();
        String phoneNumber = addAddressReqBean.getPhoneNumber();
        String name = addAddressReqBean.getName();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();

        Address address =  new Address(customID,getaddress,phoneNumber,name);
        addressService.saveAddress(address);
        return ResultUtil.success();
    }

    @LoginRequired
    @PostMapping("/delete")
    public Message deleteAddress(@RequestBody @Valid DeleteAddressReqBean deleteAddressReqBean,
                              HttpSession httpSession) {
        Integer addressID = deleteAddressReqBean.getAddressID();
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();

        addressService.deleteAddress(addressID);
        return ResultUtil.success();
    }

    @LoginRequired
    @PostMapping("/find")
    public Message findAddress(@RequestBody @Valid FindAddressReqBean findAddressReqBean,
                               HttpSession httpSession) {
        Custom custom = (Custom) httpSession.getAttribute(cooMallConfig.getIdentifier());
        Integer customID = custom.getID();


        Integer currentPage = findAddressReqBean.getCurrentPage();
        Integer limit = findAddressReqBean.getLimit();

        Map<String, Object> map = addressService.findAddress(customID, currentPage, limit);

        Integer totalPage = (Integer) map.get("totalPage");
        List<Address> addressList = (List<Address>) map.get("list");
        FindAddressRespBean findAddressRespBean =
                new FindAddressRespBean();
        findAddressRespBean.setAddressList(addressList);
        findAddressRespBean.setTotalPage(totalPage);

        return ResultUtil.success(findAddressRespBean);
    }
}