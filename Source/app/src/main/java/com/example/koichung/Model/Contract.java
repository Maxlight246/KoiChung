package com.example.koichung.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contract {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("contractID")
    @Expose
    private Integer contractID;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("agencyID")
    @Expose
    private String agencyID;
    @SerializedName("agencyName")
    @Expose
    private String agencyName;
    @SerializedName("batchID")
    @Expose
    private String batchID;
    @SerializedName("batchCode")
    @Expose
    private String batchCode;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("funds")
    @Expose
    private Integer funds;
    @SerializedName("typecommit")
    @Expose
    private Integer typecommit;
    @SerializedName("pecentcommit")
    @Expose
    private Integer pecentcommit;
    @SerializedName("dateFunds")
    @Expose
    private String dateFunds;
    @SerializedName("dateCommit")
    @Expose
    private String dateCommit;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("moneyBuyed")
    @Expose
    private Integer moneyBuyed;
    @SerializedName("qtyBuyed")
    @Expose
    private Integer qtyBuyed;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("isShowWeb")
    @Expose
    private Integer isShowWeb;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("isActive")
    @Expose
    private Integer isActive;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("description")
    @Expose
    private String description;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getFunds() {
        return funds;
    }

    public void setFunds(Integer funds) {
        this.funds = funds;
    }

    public Integer getTypecommit() {
        return typecommit;
    }

    public void setTypecommit(Integer typecommit) {
        this.typecommit = typecommit;
    }

    public Integer getPecentcommit() {
        return pecentcommit;
    }

    public void setPecentcommit(Integer pecentcommit) {
        this.pecentcommit = pecentcommit;
    }

    public String getDateFunds() {
        return dateFunds;
    }

    public void setDateFunds(String dateFunds) {
        this.dateFunds = dateFunds;
    }

    public String getDateCommit() {
        return dateCommit;
    }

    public void setDateCommit(String dateCommit) {
        this.dateCommit = dateCommit;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getMoneyBuyed() {
        return moneyBuyed;
    }

    public void setMoneyBuyed(Integer moneyBuyed) {
        this.moneyBuyed = moneyBuyed;
    }

    public Integer getQtyBuyed() {
        return qtyBuyed;
    }

    public void setQtyBuyed(Integer qtyBuyed) {
        this.qtyBuyed = qtyBuyed;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsShowWeb() {
        return isShowWeb;
    }

    public void setIsShowWeb(Integer isShowWeb) {
        this.isShowWeb = isShowWeb;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}