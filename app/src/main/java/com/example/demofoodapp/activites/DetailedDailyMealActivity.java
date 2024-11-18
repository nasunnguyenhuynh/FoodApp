package com.example.demofoodapp.activites;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demofoodapp.R;
import com.example.demofoodapp.adapters.DetailedDailyMealAdapter;
import com.example.demofoodapp.models.DetailedDailyMealModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DetailedDailyMealModel> detailedDailyMealModelList;
    DetailedDailyMealAdapter detailedDailyMealAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailed_daily_meal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        detailedDailyMealModelList = new ArrayList<>();
        detailedDailyMealAdapter = new DetailedDailyMealAdapter(detailedDailyMealModelList);
        recyclerView.setAdapter(detailedDailyMealAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")) {
            detailedDailyMealModelList.add(new DetailedDailyMealModel(R.drawable.fav1, "Breakfast", "description", "4.4", "40", "7:00 - 21:00"));
            detailedDailyMealModelList.add(new DetailedDailyMealModel(R.drawable.fav2, "Breakfast", "description", "4.4", "40", "7:00 - 21:00"));
            detailedDailyMealModelList.add(new DetailedDailyMealModel(R.drawable.fav3, "Breakfast", "description", "4.4", "40", "7:00 - 21:00"));
            detailedDailyMealAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("sweets")) {
            imageView.setImageResource(R.drawable.sweets);
            detailedDailyMealModelList.add(new DetailedDailyMealModel(R.drawable.s1, "Breakfast", "description", "4.4", "40", "7:00 - 21:00"));
            detailedDailyMealModelList.add(new DetailedDailyMealModel(R.drawable.s2, "Breakfast", "description", "4.4", "40", "7:00 - 21:00"));
            detailedDailyMealModelList.add(new DetailedDailyMealModel(R.drawable.s3 , "Breakfast", "description", "4.4", "40", "7:00 - 21:00"));
            detailedDailyMealAdapter.notifyDataSetChanged();

        }

    }
}