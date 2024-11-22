package com.example.mybucketlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ThingsToDo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_things_to_do);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycler_view_things_todo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ToDo[] toDoList = {
                new ToDo("Bowling", R.drawable.engin_akyurt_yxiw_hx3lya_unsplash),
                new ToDo("Skateboarding", R.drawable.glenn_carstens_peters_malbj24jkru_unsplash),
                new ToDo("Drawing", R.drawable.kelvin_zyteng_f7dedjeze5u_unsplash),
                new ToDo("Table Soccer", R.drawable.norbert_braun_z40ffxn34sy_unsplash),
        };

        RecyclerView thingsToDo = findViewById(R.id.recycler_view_things_todo);
        thingsToDo.setAdapter(new Adapter(toDoList));
    }
}