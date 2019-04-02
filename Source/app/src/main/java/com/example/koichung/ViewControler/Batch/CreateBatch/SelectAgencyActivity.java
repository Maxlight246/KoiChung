package com.example.koichung.ViewControler.Batch.CreateBatch;

import android.graphics.PorterDuff;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import com.example.koichung.Model.Agency;
import com.example.koichung.Model.AgencyResponse;
import com.example.koichung.Network.APIServer;
import com.example.koichung.Network.RetrofitClient;
import com.example.koichung.R;
import com.example.koichung.Utils.AppConfig;
import com.example.koichung.ViewControler.Agency.AgencyAdapter;
import com.example.koichung.ViewControler.Agency.ListAgencyFragment;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectAgencyActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lvAgency;
    AgencyAdapter adapter;
    ArrayList<Agency> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_agency);
        init();
        getAgencyData();
    }

    void init(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        adapter = new AgencyAdapter(this,data);
        lvAgency = findViewById(R.id.lv_agency);
        lvAgency.setAdapter(adapter);
    }

    void getAgencyData(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userAPI","madara");
        jsonObject.addProperty("passAPI","madara");
        jsonObject.addProperty("userID", AppConfig.getUserId(this));
        jsonObject.addProperty("batchID","109");
        RetrofitClient.getInstance().create(APIServer.class).getAgency(jsonObject).enqueue(new Callback<AgencyResponse>() {
            @Override
            public void onResponse(Call<AgencyResponse> call, Response<AgencyResponse> response) {
                if (response.body().getStatus()==1){
                    data.clear();
                    data.addAll(response.body().getResult());

                }adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<AgencyResponse> call, Throwable t) {

            }
        });

    }
   // back arrow
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
