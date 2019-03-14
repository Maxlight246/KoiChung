package com.example.koichung.ViewControler.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koichung.MainActivity;
import com.example.koichung.Model.LoginResponse;
import com.example.koichung.Model.User;
import com.example.koichung.Network.APIServer;
import com.example.koichung.Network.RetrofitClient;
import com.example.koichung.R;
import com.example.koichung.Utils.AppConfig;
import com.google.gson.JsonObject;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView tvlogin;
    EditText edusername, edpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        checkLogin();
    }

    void init(){
        tvlogin = findViewById(R.id.tv_login);
        edusername = findViewById(R.id.ed_username);
        edpassword = findViewById(R.id.ed_password);
    }

    void actionlogin(){
        if (edusername.getText() == null || edpassword.getText().toString().trim().length() == 0) {
            Toast.makeText(LoginActivity.this, "moi ban nhap du thong tin", Toast.LENGTH_SHORT).show();
            return;
        }

        String user = edusername.getText().toString();
        String password = edpassword.getText().toString();
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userAPI","madara");
        jsonBody.addProperty("passAPI","madara");
        jsonBody.addProperty("username", user);
        jsonBody.addProperty("password",password);
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("Đang kiểm tra vui lòng đợi!");
        dialog.show();
        RetrofitClient.getInstance().create(APIServer.class).login(jsonBody).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                dialog.dismiss();
                if (response.body().getStatus() == 1) {
                    AppConfig.setKeepLogin(true,LoginActivity.this);
                    AppConfig.setUserId(response.body().getUser().getUserID(),LoginActivity.this);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                if(response.body().getStatus()==0){
                    Toast.makeText(LoginActivity.this, "kiem tra lai ten dang nhap va mat khau", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Vui lòng kiểm tra và thử lại", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    public void Login(View view) {
        actionlogin();
    }

    public void checkLogin(){
         Boolean isLogin = AppConfig.getKeepLogin(this);
         if (isLogin == true){
             Intent intent = new Intent(LoginActivity.this,MainActivity.class);
             startActivity(intent);
             finish();
         }
    }
}
