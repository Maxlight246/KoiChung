package com.example.koichung.ViewControler.Batch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.koichung.Model.Batch;
import com.example.koichung.Model.BatchResponse;
import com.example.koichung.Network.APIServer;
import com.example.koichung.Network.RetrofitClient;
import com.example.koichung.R;
import com.example.koichung.Utils.AppConfig;
import com.example.koichung.ViewControler.Base.BaseFragment;
import com.example.koichung.ViewControler.Base.FragmentWithListView;
import com.example.koichung.ViewControler.Base.FragmentWithTab;
import com.example.koichung.ViewControler.Contract.ContractFragment;
import com.example.koichung.ViewControler.Order.OrderFragment;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BatchFragment extends FragmentWithTab {
public static int TAB_ALL_BILL = 0;
public static int TAB_HAVE_BILL = 1;
public static int TAB_NOT_BILL = -1;

    @Override
    public void addFragment() {
             viewPagerAdapter.addFragment(ListBatchFragment.newInstance(TAB_ALL_BILL),"tất cả");
             viewPagerAdapter.addFragment(ListBatchFragment.newInstance(TAB_HAVE_BILL),"có hđ");
             viewPagerAdapter.addFragment(ListBatchFragment.newInstance(TAB_NOT_BILL),"chưa hd");
    }
}
