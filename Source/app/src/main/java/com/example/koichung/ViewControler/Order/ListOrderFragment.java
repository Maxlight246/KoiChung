package com.example.koichung.ViewControler.Order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.koichung.Model.Order;
import com.example.koichung.Model.OrderResponse;
import com.example.koichung.Network.APIServer;
import com.example.koichung.Network.RetrofitClient;
import com.example.koichung.Utils.AppConfig;
import com.example.koichung.ViewControler.Base.FragmentWithListView;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOrderFragment extends FragmentWithListView {

    OrderAdapter adapter;
    ArrayList<Order> data = new ArrayList<>();

    @Override
    public void getData() {
        super.getData();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userAPI","madara");
        jsonObject.addProperty("passAPI","madara");
        jsonObject.addProperty("userID", "3");
        jsonObject.addProperty("agencyID","0");
        jsonObject.addProperty("contractID","0");
        jsonObject.addProperty("fromDate","10/11/2018");
        jsonObject.addProperty("toDate","09/12/2019");
        getOrderData(jsonObject);
    }

    @Override
    public void init() {
        super.init();
        adapter = new OrderAdapter(getActivity(),data);
        lv.setAdapter(adapter);
        clickItem();
    }

    void getOrderData(JsonObject jsonObject){
        RetrofitClient.getInstance().create(APIServer.class).getOrder(jsonObject).enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                if (response.body().getStatus()==1){
                    updateUI(response);
                }else {
                    Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                      isLoading = false;
                      swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    void updateUI(Response<OrderResponse> response){
        if (currentPage == 1){
            data.clear();
            data.addAll(response.body().getResult());
        }
        adapter.notifyDataSetChanged();
        isLoading = false;
        swipeRefreshLayout.setRefreshing(false);
    }

    void clickItem(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Order order = data.get(i);
                Intent intent = new Intent(getActivity(),OrderDetailActivity.class);
                intent.putExtra("order_model",order);
                startActivity(intent);
            }
        });
    }

}
