package com.example.demofoodapp.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demofoodapp.R;
import com.example.demofoodapp.adapters.DailyMealAdapter;
import com.example.demofoodapp.models.DailyMealModel;

import java.util.ArrayList;
import java.util.List;

public class DailyMealFragment extends Fragment {

    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.daily_meal_fragment, container, false);

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels = new ArrayList<>();
        dailyMealModels.add(new DailyMealModel(R.drawable.breakfast, "Breakfast", "30% OFF", "Description", "breakfast"));
        dailyMealModels.add(new DailyMealModel(R.drawable.lunch, "Lunch", "30% OFF", "Description", "lunch"));
        dailyMealModels.add(new DailyMealModel(R.drawable.dinner, "Dinner", "30% OFF", "Description", "dinner"));
        dailyMealModels.add(new DailyMealModel(R.drawable.sweets, "Sweets", "30% OFF", "Description", "sweets"));
        dailyMealModels.add(new DailyMealModel(R.drawable.coffe, "Coffee", "30% OFF", "Description", "coffee"));

        dailyMealAdapter = new DailyMealAdapter(dailyMealModels, getContext());
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();

        return root;
    }
}