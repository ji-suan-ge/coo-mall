package cn.edu.hfut.coomall.web.admin.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
public class RemoveCustomByIDReqBean {
    @NotNull(message = "customID 不能为空")
    private Integer customID;

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }
}
