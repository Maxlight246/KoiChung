package com.example.koichung.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContractResponse {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Contract")
    @Expose
    private List<Contract> ListContract = null;
    @SerializedName("message")
    @Expose
    private String message;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Contract> getContract() {
        return ListContract;
    }

    public void setContract(List<Contract> Contract) {
        this.ListContract = Contract;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}