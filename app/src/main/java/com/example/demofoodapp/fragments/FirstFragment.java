package com.example.demofoodapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demofoodapp.R;
import com.example.demofoodapp.adapters.FeaturedAdapter;
import com.example.demofoodapp.adapters.FeaturedVerAdapter;
import com.example.demofoodapp.models.FeatureModel;
import com.example.demofoodapp.models.FeaturedVerModel;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    //    Featured Hor RecyclerView
    List<FeatureModel> featureModelList;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;
    //    Featured Ver RecyclerView
    List<FeaturedVerModel> featuredVerModelList;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        //    Featured Hor RecyclerView
        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        featureModelList = new ArrayList<>();
        featureModelList.add(new FeatureModel(R.drawable.fav1, "Featured 1", "Description 1"));
        featureModelList.add(new FeatureModel(R.drawable.fav2, "Featured 2", "Description 2"));
        featureModelList.add(new FeatureModel(R.drawable.fav3, "Featured 3", "Description 3"));

        featuredAdapter = new FeaturedAdapter(featureModelList);
        recyclerView.setAdapter(featuredAdapter);

        //    Featured Ver RecyclerView
        recyclerView2 = view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        featuredVerModelList = new ArrayList<>();
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver1, "Featured 1", "Description 1", "4.8", "10:00 - 21:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver2, "Featured 2", "Description 2", "4.8", "10:00 - 21:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver3, "Featured 3", "Description 3", "4.8", "10:00 - 21:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver1, "Featured 1", "Description 1", "4.8", "10:00 - 21:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver2, "Featured 2", "Description 2", "4.8", "10:00 - 21:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.ver3, "Featured 3", "Description 3", "4.8", "10:00 - 21:00"));

        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModelList);
        recyclerView2.setAdapter(featuredVerAdapter);
        return view;
    }
}