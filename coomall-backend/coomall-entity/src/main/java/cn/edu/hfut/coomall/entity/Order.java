package cn.edu.hfut.coomall.entity;

/**
 * @author 葛学文
 * @date 2019/7/15 16:09
 */
public class Order {

    private Integer ID;
    private Integer customID;
    private Integer merchantID;
    private Integer addressID;
    private Integer remark;
    private String createTime;
    private String sendTime;
    private String returnTime;
    private String completeRime;
    private Integer state;
    private String cancelTile;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }

    public Integer getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(Integer merchantID) {
        this.merchantID = merchantID;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getCompleteRime() {
        return completeRime;
    }

    public void setCompleteRime(String completeRime) {
        this.completeRime = completeRime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCancelTile() {
        return cancelTile;
    }

    public void setCancelTile(String cancelTile) {
        this.cancelTile = cancelTile;
    }
}
