package com.example.koichung;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.koichung.ViewControler.Agency.AgencyFragment;
import com.example.koichung.ViewControler.Batch.BatchFragment;
import com.example.koichung.ViewControler.Contract.ContractFragment;
import com.example.koichung.ViewControler.Order.OrderFragment;
import com.example.koichung.ViewControler.Summary.SummaryFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new SummaryFragment());
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.nav_summary:
                     fragment = new SummaryFragment();
                     break;
                case R.id.nav_contract:
                     fragment = new ContractFragment();
                     break;
                case R.id.nav_batch:
                     fragment = new BatchFragment();
                     break;
                case R.id.nav_order:
                    fragment = new OrderFragment();
                    break;
                case R.id.nav_agency:
                    fragment = new AgencyFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;

    }
}
