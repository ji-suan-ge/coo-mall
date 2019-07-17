package cn.edu.hfut.coomall.web.merchant.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/7/15 9:46
 */
public class AddProductReqBean {

    @NotNull(message = "name 不能为空")
    private String name;
    @NotNull(message = "price 不能为空")
    private Integer price;
    @NotNull(message = "quantity 不能为空")
    private Integer quantity;
    @NotNull(message = "category 不能为空")
    private Integer category;
    @NotNull(message = "detail 不能为空")
    private String detail;
    @NotNull(message = "avatar 不能为空")
    private String avatar;

    @Override
    public String toString() {
        return "AddProductReqBean{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                ", detail='" + detail + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
