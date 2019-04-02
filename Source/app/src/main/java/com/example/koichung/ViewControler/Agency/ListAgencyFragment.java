package com.example.koichung.ViewControler.Agency;

import android.widget.Toast;

import com.example.koichung.Model.Agency;
import com.example.koichung.Model.AgencyResponse;
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

public class ListAgencyFragment extends FragmentWithListView {
    AgencyAdapter adapter;
    ArrayList<Agency> data = new ArrayList<>();

    @Override
    public void getData() {
        super.getData();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userAPI","madara");
        jsonObject.addProperty("passAPI","madara");
        jsonObject.addProperty("userID", AppConfig.getUserId(getActivity()));
        jsonObject.addProperty("batchID","109");
        getAgencyData(jsonObject);
    }

    @Override
    public void init() {
        super.init();
        adapter = new AgencyAdapter(getActivity(),data);
        lv.setAdapter(adapter);
    }

    void getAgencyData(JsonObject jsonObject){
        RetrofitClient.getInstance().create(APIServer.class).getAgency(jsonObject).enqueue(new Callback<AgencyResponse>() {
            @Override
            public void onResponse(Call<AgencyResponse> call, Response<AgencyResponse> response) {
                if (response.body().getStatus()==1){
                    updateUI(response);
                }else {
                    Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AgencyResponse> call, Throwable t) {
                   isLoading = false;
                   swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    void updateUI(Response<AgencyResponse> response){
        if (currentPage == 1){
            data.clear();
            data.addAll(response.body().getResult());
        }
        adapter.notifyDataSetChanged();
        isLoading = false;
        swipeRefreshLayout.setRefreshing(false);
    }
}
