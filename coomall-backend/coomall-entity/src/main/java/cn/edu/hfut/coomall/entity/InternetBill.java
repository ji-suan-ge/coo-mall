package cn.edu.hfut.coomall.entity;

public class InternetBill {

    private Integer customNumber;
    private Integer allSale;
    private Integer merchantNumber;
    private Integer productNumber;

    public Integer getAllSale() {
        return allSale;
    }

    public void setAllSale(Integer allSale) {
        this.allSale = allSale;
    }

    public Integer getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(Integer merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Integer getCustomNumber() {
        return customNumber;
    }

    public void setCustomNumber(Integer customNumber) {
        this.customNumber = customNumber;
    }
}
