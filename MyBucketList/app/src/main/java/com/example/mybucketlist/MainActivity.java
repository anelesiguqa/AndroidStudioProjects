package com.example.mybucketlist;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        CardView thingsTodo = findViewById(R.id.card_view_things_todo);
        CardView placesToGo = findViewById(R.id.card_view_places_to_go);

        thingsTodo.setOnClickListener( v -> {
            Intent thingsToDoIntent = new Intent(MainActivity.this, ThingsToDo.class);
            startActivity(thingsToDoIntent);
        });

        placesToGo.setOnClickListener(v -> {
            Intent placesToGoIntent = new Intent(MainActivity.this, PlacesToGo.class);
            startActivity(placesToGoIntent);
        });
    }
}