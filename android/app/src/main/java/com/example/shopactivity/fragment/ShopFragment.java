package com.example.shopactivity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopactivity.R;
import com.example.shopactivity.adapter.ShopAdapter;
import com.example.shopactivity.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    List<Shop> shopList = new ArrayList<>();
    RecyclerView recyclerView;
    ShopAdapter shopAdapter;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.show_shop_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        shopList.clear();
        for (int i = 0;i<3;i++) {
            Shop shop = new Shop();
            shop.setImage(R.drawable.amstree_logo);
            shopList.add(shop);
        }
        shopAdapter = new ShopAdapter(getActivity(), shopList);
        shopAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(shopAdapter);
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
