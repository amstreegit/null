package com.example.shopactivity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shopactivity.MainActivity;
import com.example.shopactivity.R;
import com.example.shopactivity.model.Mycard;

import java.util.List;

/**
 * Created by Choccochip on 26/9/2560.
 */

public class MycardAdapter extends RecyclerView.Adapter<MycardAdapter.MyViewHolder> {
    List<Mycard> mycardlist;
    Activity context;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView mycard_image;
        ProgressBar progressBar;
        TextView mycard_point;
        TextView mycard_text;
        LinearLayout mycard_layout;

        public MyViewHolder(View view){
            super(view);
            mycard_image = (ImageView) view.findViewById(R.id.mycard_imagelistview);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            mycard_point = (TextView) view.findViewById(R.id.point_textlistview);
            mycard_text = (TextView) view.findViewById(R.id.textlistview);
            mycard_layout = (LinearLayout) view.findViewById(R.id.mycard_listview_layout);
        }
    }

    public MycardAdapter(Activity context, List<Mycard> mycardlist) {
        this.context = context;
        this.mycardlist = mycardlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mycard_listview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Mycard mycard = mycardlist.get(position);
//        Picasso.with(context).load(mycardlist.get(position).getImageURL())
//                .transform(new CircleTransformation()).into(holder.mycard_image);
        holder.progressBar.setProgress(mycardlist.get(position).getProgress());
        holder.mycard_point.setText(mycardlist.get(position).getPoint());
        holder.mycard_text.setText(mycardlist.get(position).getText());

        holder.mycard_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto_main = new Intent(context, MainActivity.class);
                context.startActivity(goto_main);
                context.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mycardlist.size();
    }
}
