package com.example.koichung.ViewControler.Batch;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.koichung.Model.Batch;
import com.example.koichung.Model.BatchResponse;
import com.example.koichung.Network.APIServer;
import com.example.koichung.Network.RetrofitClient;
import com.example.koichung.Utils.AppConfig;
import com.example.koichung.ViewControler.Base.BaseFragment;
import com.example.koichung.ViewControler.Base.FragmentWithListView;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBatchFragment extends FragmentWithListView {

    BatchAdapter adapter;
    ArrayList<Batch> data = new ArrayList<>();

    @Override
    public void getData() {
        super.getData();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userAPI","madara");
        jsonObject.addProperty("passAPI","madara");
        jsonObject.addProperty("userID",AppConfig.getUserId(getActivity()));
        if (inputType==BatchFragment.TAB_ALL_BILL){
            jsonObject.addProperty("status",BatchFragment.TAB_ALL_BILL);
            getBatchData(jsonObject);
        } else if (inputType==BatchFragment.TAB_HAVE_BILL){
            jsonObject.addProperty("status",BatchFragment.TAB_HAVE_BILL);
            getBatchData(jsonObject);
        } else if (inputType==BatchFragment.TAB_NOT_BILL){
            jsonObject.addProperty("status",BatchFragment.TAB_NOT_BILL);
            getBatchData(jsonObject);
        }

    }

    @Override
    public void init() {
        super.init();
        adapter = new BatchAdapter(getActivity(),data);
        lv.setAdapter(adapter);
    }

    public void getBatchData(JsonObject jsonObject){
        RetrofitClient.getInstance().create(APIServer.class).getBatch(jsonObject).enqueue(new Callback<BatchResponse>() {
            @Override
            public void onResponse(Call<BatchResponse> call, Response<BatchResponse> response) {
                if (response.body().getStatus()==1){
                   updateUI(response);
                }else {
                    Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BatchResponse> call, Throwable t) {
                  isLoading = false;
                  swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    void updateUI(Response<BatchResponse> response){
        if (currentPage==1){
            data.clear();
            data.addAll(response.body().getListBatch());
        }
        adapter.notifyDataSetChanged();
        isLoading = false;
        swipeRefreshLayout.setRefreshing(false);
    }

    public static ListBatchFragment newInstance(int inputType){
        ListBatchFragment fragment = new ListBatchFragment();
        Bundle args = new Bundle();
        args.putInt(INPUT_TYPE,inputType);
        fragment.setArguments(args);
        return fragment;
    }
}
