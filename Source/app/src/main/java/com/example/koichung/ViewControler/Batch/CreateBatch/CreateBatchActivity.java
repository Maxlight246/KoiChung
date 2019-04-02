package com.example.koichung.ViewControler.Batch.CreateBatch;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.koichung.R;

public class CreateBatchActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText edCode,edCount,edRoot,edDealer,edBuyer,edNote,edPrivateNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_batch);
        init();
    }

    void init(){
        toolbar = findViewById(R.id.tb_create_batch);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        edCode = findViewById(R.id.ed_create_batch_code);
        edCount = findViewById(R.id.ed_create_batch_count);
        edRoot = findViewById(R.id.ed_create_batch_root);
        edDealer = findViewById(R.id.ed_create_batch_dealer);
        edBuyer = findViewById(R.id.ed_create_batch_buyer);
        edNote = findViewById(R.id.ed_create_batch_note);
        edPrivateNote = findViewById(R.id.ed_create_batch_private_note);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void SelectAgency(View view) {
        Intent intent = new Intent(this, SelectAgencyActivity.class);
        startActivity(intent);
    }
}
