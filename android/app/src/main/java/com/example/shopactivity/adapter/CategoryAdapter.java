package com.example.shopactivity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shopactivity.MenuActivity;
import com.example.shopactivity.R;
import com.example.shopactivity.model.Category;

import java.util.List;

/**
 * Created by Choccochip on 1/10/2560.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> implements View.OnClickListener {
    List<Category> categorylist;
    Activity context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView category_text;
        LinearLayout category_layout;

        public MyViewHolder(View view) {
            super(view);
            category_text = (TextView) view.findViewById(R.id.category_textlistview);
            category_layout = (LinearLayout) view.findViewById(R.id.category_listview_layout);
        }
    }

    public CategoryAdapter(Activity context, List<Category> categorylist) {
        this.context = context;
        this.categorylist = categorylist;
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_listview, parent, false);
        return new CategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {
        holder.category_text.setText(categorylist.get(position).getText());

        holder.category_layout.setTag(position);
        holder.category_layout.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return categorylist.size();
    }

    @Override
    public void onClick(View view) {
        int position = Integer.parseInt(view.getTag().toString());
        Intent goto_menu = new Intent(context, MenuActivity.class);
//        goto_menu.putExtra("category", categorylist.get(position).getText());
        context.startActivity(goto_menu);
        context.finish();
    }
}
