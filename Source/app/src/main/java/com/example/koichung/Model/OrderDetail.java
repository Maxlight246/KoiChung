package com.example.koichung.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderDetail {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("orderID")
    @Expose
    private Integer orderID;
    @SerializedName("contractID")
    @Expose
    private Integer contractID;
    @SerializedName("contractCode")
    @Expose
    private String contractCode;
    @SerializedName("customername")
    @Expose
    private String customername;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("totalprice")
    @Expose
    private Integer totalprice;
    @SerializedName("createdate")
    @Expose
    private String createdate;
    @SerializedName("createdateconvert")
    @Expose
    private String createdateconvert;
    @SerializedName("isActive")
    @Expose
    private Integer isActive;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreatedateconvert() {
        return createdateconvert;
    }

    public void setCreatedateconvert(String createdateconvert) {
        this.createdateconvert = createdateconvert;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

}