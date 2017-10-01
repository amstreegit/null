package com.example.shopactivity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shopactivity.R;
import com.example.shopactivity.adapter.MycardAdapter;
import com.example.shopactivity.model.Mycard;

import java.util.ArrayList;
import java.util.List;

public class MyCardFragment extends Fragment {
    List<Mycard> mycardList = new ArrayList<>();
    RecyclerView recyclerView;
    MycardAdapter mycardAdapter;
    TextView point;
    TextView text;
    TextView total_point;
    int p = 0;

    public MyCardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_card, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.show_mycard_recyclerview);
        text = (TextView) view.findViewById(R.id.textlistview);
        point = (TextView) view.findViewById(R.id.point_textlistview);
        total_point = (TextView) view.findViewById(R.id.total_point_textview);

        total_point.setText("Point: " + p + "");

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mycardAdapter = new MycardAdapter(getActivity(), mycardList);
        mycardList.clear();
        for (int i = 1; i < 4; i++) {
            Mycard mycard = new Mycard();
            mycard.setImage(R.drawable.amstree_logo);
            mycard.setPoint(i + " Point(s)");
            mycard.setText("title " + (i));
            mycard.setProgress(i);
            p += i;
            mycardList.add(mycard);
        }
        total_point.setText("Point: " + p);
        mycardAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(mycardAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
