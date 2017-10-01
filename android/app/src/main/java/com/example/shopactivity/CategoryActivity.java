package com.example.shopactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.shopactivity.adapter.CategoryAdapter;
import com.example.shopactivity.model.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {

    @BindView(R.id.show_category_recyclerview)
    RecyclerView showCategoryRecyclerview;

    List<Category> categoryList = new ArrayList<>();
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        showCategoryRecyclerview.setLayoutManager(layoutManager);
        showCategoryRecyclerview.setHasFixedSize(true);

        categoryAdapter = new CategoryAdapter(this, categoryList);

        categoryList.clear();
        for (int i = 0; i < 3; i++) {
            Category category = new Category();
            category.setText("Cat " + i);
            categoryList.add(category);
            Log.i("check ", i + "");
        }

        categoryAdapter.notifyDataSetChanged();
        showCategoryRecyclerview.setAdapter(categoryAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backto_main = new Intent(this, MainActivity.class);
        startActivity(backto_main);
        finish();
    }
}
