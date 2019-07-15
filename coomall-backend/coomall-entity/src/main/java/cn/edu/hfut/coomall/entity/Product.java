package cn.edu.hfut.coomall.entity;

/**
 * @author 葛学文
 * @date 2019/7/14 21:29
 */
public class Product {

    private Integer ID;
    private String name;
    private Integer price;
    private Integer quantity;
    private Integer sale;
    private Integer category;
    private String detail;
    private Integer state;
    private Integer merchantID;
    private String avatar;

    public Product() {}

    public Product(String name, Integer price, Integer quantity, Integer category, String detail, Integer merchantID,
                   String avatar) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.detail = detail;
        this.merchantID = merchantID;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sale=" + sale +
                ", category=" + category +
                ", detail='" + detail + '\'' +
                ", state=" + state +
                ", merchantID=" + merchantID +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(Integer merchantID) {
        this.merchantID = merchantID;
    }
}
