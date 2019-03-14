package com.example.koichung.ViewControler.Base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.koichung.R;

public abstract class FragmentWithTab extends BaseFragment {
    View rootView;
    TabLayout tabLayout;
    ViewPager viewPager;
    public KoiChungViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_with_tab_layout,container,false);
        init();
        return rootView;
    }

    void init(){
        tabLayout = rootView.findViewById(R.id.tab);
        viewPager = rootView.findViewById(R.id.vp);
        configViewPager();
    }

    public void configViewPager(){
          viewPagerAdapter = new KoiChungViewPagerAdapter(getChildFragmentManager());
          addFragment();
          viewPager.setAdapter(viewPagerAdapter);
          tabLayout.setupWithViewPager(viewPager);
    }

    public abstract void addFragment();
}
