package com.example.koichung.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Order implements Serializable {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("orderID")
    @Expose
    private Integer orderID;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("contractID")
    @Expose
    private Integer contractID;
    @SerializedName("agencyID")
    @Expose
    private Integer agencyID;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("totalPrice")
    @Expose
    private Integer totalPrice;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("createDateString")
    @Expose
    private String createDateString;
    @SerializedName("createDate")
    @Expose
    private String createDate;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public Integer getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Integer agencyID) {
        this.agencyID = agencyID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateDateString() {
        return createDateString;
    }

    public void setCreateDateString(String createDateString) {
        this.createDateString = createDateString;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

}