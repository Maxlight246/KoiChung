package com.example.koichung.ViewControler.Contract;

import android.os.Bundle;
import android.widget.Toast;

import com.example.koichung.Model.Contract;
import com.example.koichung.Model.ContractResponse;
import com.example.koichung.Network.APIServer;
import com.example.koichung.Network.RetrofitClient;
import com.example.koichung.Utils.AppConfig;
import com.example.koichung.ViewControler.Base.FragmentWithListView;
import com.example.koichung.ViewControler.Batch.ListBatchFragment;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListContractFragment extends FragmentWithListView {

    ContractAdapter adapter;
    ArrayList<Contract> data = new ArrayList<>();

    @Override
    public void getData() {
        super.getData();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userAPI","madara");
        jsonObject.addProperty("passAPI","madara");
        jsonObject.addProperty("userID", AppConfig.getUserId(getActivity()));
        jsonObject.addProperty("batchID",0);
        jsonObject.addProperty("agencyID",0);
        jsonObject.addProperty("fromDateTime","08/29/2017");

        if (inputType == ContractFragment.STATUS_ALL){
            jsonObject.addProperty("status",ContractFragment.STATUS_ALL);
            getContractData(jsonObject);
        }else if (inputType == ContractFragment.STATUS_COMPLETE){
            jsonObject.addProperty("status",ContractFragment.STATUS_COMPLETE);
            getContractData(jsonObject);
        }else if (inputType == ContractFragment.STATUS_OPEN){
            jsonObject.addProperty("status",ContractFragment.STATUS_OPEN);
            getContractData(jsonObject);
        }else if (inputType == ContractFragment.STATUS_WATTING_APPROVE){
            jsonObject.addProperty("status",ContractFragment.STATUS_WATTING_APPROVE);
            getContractData(jsonObject);
        }else if (inputType == ContractFragment.STATUS_OVER_DAY){
            jsonObject.addProperty("status",ContractFragment.STATUS_OVER_DAY);
            getContractData(jsonObject);
        }
    }

    @Override
    public void init() {
        super.init();
        adapter = new ContractAdapter(getActivity(),data);
        lv.setAdapter(adapter);
    }

    void getContractData(JsonObject jsonObject){
        RetrofitClient.getInstance().create(APIServer.class).getContract(jsonObject).enqueue(new Callback<ContractResponse>() {
            @Override
            public void onResponse(Call<ContractResponse> call, Response<ContractResponse> response) {
                if (response.body().getStatus()==1){
                    updateUI(response);
                }else {
                    Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ContractResponse> call, Throwable t) {
                     isLoading = false;
                     swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    void updateUI(Response<ContractResponse> response){
        if (currentPage == 1){
            data.clear();
            data.addAll(response.body().getContract());
        }
        adapter.notifyDataSetChanged();
        isLoading = false;
        swipeRefreshLayout.setRefreshing(false);
    }

    public static ListContractFragment newInstance(int inputType){
        ListContractFragment fragment = new ListContractFragment();
        Bundle args = new Bundle();
        args.putInt(INPUT_TYPE,inputType);
        fragment.setArguments(args);
        return fragment;
    }
}
