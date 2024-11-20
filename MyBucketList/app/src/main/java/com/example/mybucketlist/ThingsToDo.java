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
                new ToDo("Salad 1"),
                new ToDo("Task 2"),
                new ToDo("Task 3"),
                new ToDo("Task 4"),
                new ToDo("Task 5"),
                new ToDo("Task 6"),
                new ToDo("Task 7"),
                new ToDo("Task 8"),
                new ToDo("Task 9"),
                new ToDo("Task 10")
        };

        RecyclerView thingsToDo = findViewById(R.id.recycler_view_things_todo);
        thingsToDo.setAdapter(new Adapter(toDoList));
    }
}