package cn.edu.hfut.coomall.web.admin.bean;

import cn.edu.hfut.coomall.entity.Custom;

import java.util.List;

/**
 * @author 郑力煽
 * @date 2019/7/15
 */
public class GetAllCustomRespBean {

    private Integer totalPage;
    private List<Custom> customList;

    public List<Custom> getCustomList() {
        return customList;
    }

    public void setCustomList(List<Custom> customList) {
        this.customList = customList;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}
