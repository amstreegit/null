package com.example.shopactivity.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shopactivity.R;
import com.example.shopactivity.model.Menu;

import java.util.List;

/**
 * Created by Choccochip on 26/9/2560.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> implements View.OnClickListener{
    List<Menu> menulist;
    Activity context;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView menu_image;
        TextView menu_name;
        TextView menu_price;
        TextView menu_point;
        LinearLayout menu_layout;

        public MyViewHolder(View view){
            super(view);
            menu_image = (ImageView) view.findViewById(R.id.menu_imagelistview);
            menu_name = (TextView) view.findViewById(R.id.menu_textlistview1);
            menu_price = (TextView) view.findViewById(R.id.menu_textlistview2);
            menu_point = (TextView) view.findViewById(R.id.menu_textlistview3);
            menu_layout = (LinearLayout) view.findViewById(R.id.menu_listview_layout);
        }
    }

    public MenuAdapter(Activity context, List<Menu> menulist) {
        this.context = context;
        this.menulist = menulist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_listview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Picasso.with(context).load(menulist.get(position).getImageURL()).transform(new CircleTransformation()).into(holder.menu_image);
        holder.menu_name.setText(menulist.get(position).getName());
        holder.menu_price.setText(menulist.get(position).getPrice());
        holder.menu_point.setText(menulist.get(position).getPoint());

        holder.menu_layout.setTag(position);
        holder.menu_layout.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return menulist.size();
    }

    @Override
    public void onClick(View view) {
        int position = Integer.parseInt(view.getTag().toString());
    }
}
