package com.example.koichung.ViewControler.Base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.koichung.R;

public class FragmentWithListView extends BaseFragment {
    protected int inputType;
    protected static final String INPUT_TYPE = "type";
    protected View rootView;
    protected ListView lv;
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected int currentPage = 1;
    protected String searchKey = "";
    protected boolean isLoading = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.fragment_with_lisview,container,false);
         init();
         return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            inputType = getArguments().getInt(INPUT_TYPE);
        }
    }

    public void init(){
        lv = rootView.findViewById(R.id.lv);
        swipeRefreshLayout = rootView.findViewById(R.id.sw_refesh);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }

    public void getData(){
        isLoading = true;
        if (currentPage==1){
            swipeRefreshLayout.setRefreshing(true);
        }

    }
}
