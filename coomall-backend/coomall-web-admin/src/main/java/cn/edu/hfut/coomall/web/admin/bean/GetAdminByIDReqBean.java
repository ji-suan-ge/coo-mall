package cn.edu.hfut.coomall.web.admin.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
public class GetAdminByIDReqBean {

    @NotNull(message = "adminID 不能为空")
    private Integer adminID;

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }
}
