package cn.edu.hfut.coomall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bill {
    private Integer highPrice;
    private Integer lowPrice;
    private Integer monthSale;
    private Integer monthAmount;
    private Integer month;

    public Integer getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Integer highPrice) {
        this.highPrice = highPrice;
    }

    public Integer getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Integer lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Integer getMonthSale() {
        return monthSale;
    }

    public void setMonthSale(Integer monthSale) {
        this.monthSale = monthSale;
    }

    public Integer getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(Integer monthAmount) {
        this.monthAmount = monthAmount;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
