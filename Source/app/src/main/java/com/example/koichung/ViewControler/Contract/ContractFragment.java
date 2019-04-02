package com.example.koichung.ViewControler.Contract;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.koichung.R;
import com.example.koichung.ViewControler.Agency.AgencyFragment;
import com.example.koichung.ViewControler.Base.BaseFragment;
import com.example.koichung.ViewControler.Base.KoiChungViewPagerAdapter;
import com.example.koichung.ViewControler.Order.OrderFragment;
import com.example.koichung.ViewControler.Summary.SummaryFragment;

public class ContractFragment extends BaseFragment {

    public static int STATUS_ALL = 10;
    public static int STATUS_WATTING_APPROVE = 0;
    public static int STATUS_OPEN = 1;
    public static int STATUS_COMPLETE = 2;
    public static int STATUS_OVER_DAY = -2;

    View rootView;
    TabLayout tabLayout;
    ViewPager viewPager;
    public KoiChungViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contract,container,false);
        init();
        return rootView;
    }

    void init(){
        tabLayout = rootView.findViewById(R.id.tab_contract);
        viewPager = rootView.findViewById(R.id.vp_contract);
        configViewPager();
    }

    public void configViewPager(){
        viewPagerAdapter = new KoiChungViewPagerAdapter(getChildFragmentManager());
        addFragment();
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void addFragment(){
        viewPagerAdapter.addFragment(ListContractFragment.newInstance(STATUS_ALL),"tất cả");
        viewPagerAdapter.addFragment(ListContractFragment.newInstance(STATUS_WATTING_APPROVE),"chờ duyệt");
        viewPagerAdapter.addFragment(ListContractFragment.newInstance(STATUS_OPEN),"thực hiện");
        viewPagerAdapter.addFragment(ListContractFragment.newInstance(STATUS_COMPLETE),"hoàn thành");
        viewPagerAdapter.addFragment(ListContractFragment.newInstance(STATUS_OVER_DAY),"quá hạn");
    }
}
