package com.example.demofoodapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demofoodapp.R;
import com.example.demofoodapp.adapters.HomeHorAdapter;
import com.example.demofoodapp.adapters.HomeVerAdapter;
import com.example.demofoodapp.adapters.UpdateVerticalRec;
import com.example.demofoodapp.models.HomeHorModel;
import com.example.demofoodapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec, homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    ArrayList<HomeVerModel> homeVerModelList;

    HomeHorAdapter homeHorAdapter;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.hamburger, "Hamburger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.ice_cream, "Ice cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fried_potatoes, "Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich, "Sandwich"));

        homeHorAdapter = new HomeHorAdapter(this, getActivity(), homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);


        homeVerModelList = new ArrayList<>();
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza1, "Pizza1", "10:00 - 23:00", "4.9", "Min - $34"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza2, "Pizza2", "10:00 - 23:00", "4.9", "Min - $34"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza3, "Pizza3", "10:00 - 23:00", "4.9", "Min - $34"));

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        homeVerticalRec.setHasFixedSize(true);
        homeVerticalRec.setNestedScrollingEnabled(false);
        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(), list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);
    }
}