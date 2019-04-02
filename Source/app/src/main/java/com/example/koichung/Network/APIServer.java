package com.example.koichung.Network;

import com.example.koichung.Model.AgencyResponse;
import com.example.koichung.Model.BatchResponse;
import com.example.koichung.Model.ContractResponse;
import com.example.koichung.Model.LoginResponse;
import com.example.koichung.Model.OrderDetailResponse;
import com.example.koichung.Model.OrderResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIServer {
    //login
    @POST("api/Service/CheckLogin")
    @Headers("Content-Type:application/json")
    Call<LoginResponse> login(@Body JsonObject jsonObject);
    //getListBatch
    @POST("api/Service/GetListBatch")
    @Headers("Content-Type:application/json")
    Call<BatchResponse> getBatch(@Body JsonObject jsonObject);
    //getListContract
    @POST("api/Service/GetListContract")
    @Headers("Content-Type:application/json")
    Call<ContractResponse> getContract (@Body JsonObject jsonObject);
    //getListOrder
    @POST("api/Service/GetListOrder")
    @Headers("Content-Type:application/json")
    Call<OrderResponse> getOrder(@Body JsonObject jsonObject);
    //getListAgency
    @POST("api/Service/GetListAgency")
    @Headers("Content-Type:application/json")
    Call<AgencyResponse> getAgency(@Body JsonObject jsonObject);
    //getOrderDetail
    @POST("api/Service/GetOrderDetail")
    @Headers("Content-Type:application/json")
    Call<OrderDetailResponse> getOrderDetail(@Body JsonObject jsonObject);
}
