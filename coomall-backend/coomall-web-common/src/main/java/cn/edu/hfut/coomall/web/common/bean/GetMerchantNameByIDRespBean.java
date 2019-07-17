package cn.edu.hfut.coomall.web.common.bean;

public class GetMerchantNameByIDRespBean {

    private String shopName;
    private String intro;
    private Integer score;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
