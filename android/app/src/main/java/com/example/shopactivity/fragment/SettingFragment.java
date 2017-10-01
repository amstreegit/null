package com.example.shopactivity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopactivity.R;
import com.example.shopactivity.adapter.SettingAdapter;
import com.example.shopactivity.model.Setting;

import java.util.ArrayList;
import java.util.List;

public class SettingFragment extends Fragment {
    List<Setting> settingList = new ArrayList<>();
    RecyclerView recyclerView;
    SettingAdapter settingAdapter;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.show_setting_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        settingAdapter = new SettingAdapter(getActivity(), settingList);

        settingList.clear();
        for (int i = 0; i < 2; i++) {
            Setting setting = new Setting();
            switch (i) {
                case 0:
                    setting.setText("Profile");
                    break;
                case 1:
                    setting.setText("Log out");
                    break;
            }
            settingList.add(setting);
            Log.i("check ", i + "");
        }

        settingAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(settingAdapter);

        return view;
    }

    //    public void prepareData(int count, String text){
//
//    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
