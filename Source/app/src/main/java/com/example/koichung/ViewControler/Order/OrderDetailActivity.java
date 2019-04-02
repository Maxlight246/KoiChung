package com.example.koichung.ViewControler.Order;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koichung.Model.Order;
import com.example.koichung.Model.OrderDetailResponse;
import com.example.koichung.Network.APIServer;
import com.example.koichung.Network.RetrofitClient;
import com.example.koichung.R;
import com.example.koichung.Utils.AppConfig;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailActivity extends AppCompatActivity {

    TextView tvCode,tvName,tvPhone,tvCount,tvPrice,tvDate,tvTitle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        init();
        getData();
    }

    void getData(){
        Intent intent = getIntent();
        Order order = (Order) intent.getSerializableExtra("order_model");
         JsonObject jsonObject = new JsonObject();
         jsonObject.addProperty("userAPI","madara");
         jsonObject.addProperty("passAPI","madara");
         jsonObject.addProperty("userID", AppConfig.getUserId(this));
         jsonObject.addProperty("orderID",order.getOrderID());
         getOrderDetail(jsonObject);
    }

    void getOrderDetail(JsonObject jsonObject){
        RetrofitClient.getInstance().create(APIServer.class).getOrderDetail(jsonObject).enqueue(new Callback<OrderDetailResponse>() {
            @Override
            public void onResponse(Call<OrderDetailResponse> call, Response<OrderDetailResponse> response) {
                if (response.body().getStatus()==1){
                    tvCode.setText(response.body().getResult().getContractCode());
                    tvName.setText(response.body().getResult().getCustomername());
                    tvPhone.setText(response.body().getResult().getPhone());
                    tvCount.setText(response.body().getResult().getQty()+"");
                    tvPrice.setText(response.body().getResult().getTotalprice()+" đ");
                    tvDate.setText(response.body().getResult().getCreatedateconvert());
                    tvTitle.setText("Đơn hàng "+response.body().getResult().getContractCode());
                }else {
                    Toast.makeText(OrderDetailActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OrderDetailResponse> call, Throwable t) {
                Toast.makeText(OrderDetailActivity.this, "Loi he thong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void init(){
        tvCode = findViewById(R.id.tv_order_detail_code);
        tvName = findViewById(R.id.tv_order_detail_name);
        tvPhone = findViewById(R.id.tv_order_detail_phone);
        tvCount = findViewById(R.id.tv_order_detail_count);
        tvPrice = findViewById(R.id.tv_order_detail_price);
        tvDate = findViewById(R.id.tv_order_detail_date);
        toolbar = findViewById(R.id.tb_order_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        tvTitle = toolbar.findViewById(R.id.tv_title_order_detail);
    }

    // back arrow
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
