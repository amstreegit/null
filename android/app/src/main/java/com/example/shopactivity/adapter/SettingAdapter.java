package com.example.shopactivity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shopactivity.LoginActivity;
import com.example.shopactivity.MainActivity;
import com.example.shopactivity.MenuActivity;
import com.example.shopactivity.R;
import com.example.shopactivity.model.Setting;

import java.util.List;

/**
 * Created by Choccochip on 27/9/2560.
 */

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.MyViewHolder> implements View.OnClickListener {
    List<Setting> settinglist;
    Activity context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView setting_text;
        LinearLayout setting_layout;

        public MyViewHolder(View view) {
            super(view);
            setting_text = (TextView) view.findViewById(R.id.setting_textlistview);
            setting_layout = (LinearLayout) view.findViewById(R.id.setting_listview_layout);
        }
    }

    public SettingAdapter(Activity context, List<Setting> settinglist) {
        this.context = context;
        this.settinglist = settinglist;
    }

    @Override
    public SettingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setting_listview, parent, false);
        return new SettingAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SettingAdapter.MyViewHolder holder, int position) {
        holder.setting_text.setText(settinglist.get(position).getText());

        holder.setting_layout.setTag(position);
        holder.setting_layout.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return settinglist.size();
    }

    @Override
    public void onClick(View view) {
        int position = Integer.parseInt(view.getTag().toString());
        switch (position) {
            case 0:
//                Intent goto_profile = new Intent(context, ProfileActivity.class);
//                context.startActivity(goto_profile);
//                context.finish();
                Intent backto_menu = new Intent(context, MenuActivity.class);
                context.startActivity(backto_menu);
                context.finish();
                break;
            case 1:
                Intent backto_login = new Intent(context, LoginActivity.class);
                context.startActivity(backto_login);
                context.finish();
                break;
            default:
                Intent backto_main = new Intent(context, MainActivity.class);
                context.startActivity(backto_main);
                context.finish();
                break;
        }
    }
}
