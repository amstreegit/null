package com.example.shopactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.shopactivity.adapter.MenuAdapter;
import com.example.shopactivity.model.Menu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {
    @BindView(R.id.show_menu_recyclerview)
    RecyclerView showMenuRecyclerview;

    MenuAdapter menuAdapter;
    List<Menu> menuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        showMenuRecyclerview.setLayoutManager(layoutManager);
        showMenuRecyclerview.setHasFixedSize(true);

        menuAdapter = new MenuAdapter(this, menuList);

        menuList.clear();
        for (int i = 1; i < 4; i++) {
            Menu menu = new Menu();
            menu.setImage(R.drawable.amstree_logo);
            menu.setName("Name " + (i));
            menu.setPrice("Price " + (i));
            menu.setPoint("Point " + (i));
            menuList.add(menu);
            Log.i("check ", i + "");
        }

        menuAdapter.notifyDataSetChanged();
        showMenuRecyclerview.setAdapter(menuAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backto_cat = new Intent(this, CategoryActivity.class);
        startActivity(backto_cat);
        finish();
    }
}
