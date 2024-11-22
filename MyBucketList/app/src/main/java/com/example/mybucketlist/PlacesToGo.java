package com.example.mybucketlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PlacesToGo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_places_to_go);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyler_view_places_to_go), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyler_view_places_to_go);
        ToDo[] todoPlacesToGo = {
                new ToDo("Vintage Fashion", R.drawable.fons_heijnsbroek_qssky76becg_unsplash),
                new ToDo("Ocean Shore", R.drawable.fuu_j_r2njpbeyusq_unsplash),
                new ToDo("WaterFall", R.drawable.sardar_kamran_khan_jyf1kn3eyho_unsplash)
        };

        recyclerView.setAdapter(new Adapter(todoPlacesToGo));
    }
}