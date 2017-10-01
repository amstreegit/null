package com.example.shopactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.shopactivity.adapter.PagerAdapter;
import com.example.shopactivity.fragment.MyCardFragment;
import com.example.shopactivity.fragment.SettingFragment;
import com.example.shopactivity.fragment.ShopFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.banner_imageview)
    ImageView bannerImageview;
    @BindView(R.id.mainViewPager)
    ViewPager mainViewPager;
    @BindView(R.id.mainTabLayout)
    TabLayout mainTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //1
        setupViewPager(mainViewPager);
        mainTabLayout.setupWithViewPager(mainViewPager);
        setupTab();
    }
    //1
    private void setupViewPager(ViewPager mainViewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ShopFragment(),"Shop");
        adapter.addFragment(new MyCardFragment(),"My Card");
        adapter.addFragment(new SettingFragment(),"Setting");
        mainViewPager.setAdapter(adapter);
    }
    private void setupTab() {
        mainTabLayout.getTabAt(0).setText("Shop").setIcon(R.drawable.logo);
        mainTabLayout.getTabAt(1).setText("My Card").setIcon(R.drawable.logo);
        mainTabLayout.getTabAt(2).setText("Setting").setIcon(R.drawable.logo);
    }
}
