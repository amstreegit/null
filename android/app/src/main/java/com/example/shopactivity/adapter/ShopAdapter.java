package com.example.shopactivity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.shopactivity.CategoryActivity;
import com.example.shopactivity.R;
import com.example.shopactivity.model.Shop;

import java.util.List;

/**
 * Created by Choccochip on 26/9/2560.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> implements View.OnClickListener{
    private List<Shop> shoplist;
    private Activity context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView shop_image;
        LinearLayout shop_layout;

        public MyViewHolder(View view) {
            super(view);
            shop_image = (ImageView) view.findViewById(R.id.shop_imagelistview);
            shop_layout = (LinearLayout) view.findViewById(R.id.shop_listview_layout);
        }
    }

    public ShopAdapter(Activity context, List<Shop> shoplist) {
        this.context = context;
        this.shoplist = shoplist;
    }

    @Override
    public ShopAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shop_listview, parent, false);
        return new ShopAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShopAdapter.MyViewHolder holder, int position) {
        Shop shop = shoplist.get(position);
//        Picasso.with(context).load(shoplist.get(position).getImageURL()).into(holder.shop_image);
        holder.shop_layout.setTag(position);
        holder.shop_layout.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return shoplist.size();
    }

    @Override
    public void onClick(View view) {
        int position = Integer.parseInt(view.getTag().toString());
        Intent passto_menu = new Intent(context, CategoryActivity.class);
        context.startActivity(passto_menu);
        context.finish();
    }
}

