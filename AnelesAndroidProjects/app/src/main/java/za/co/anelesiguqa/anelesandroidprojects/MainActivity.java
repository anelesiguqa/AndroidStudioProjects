package za.co.anelesiguqa.anelesandroidprojects;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycler_view_projects), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView list = findViewById(R.id.recycler_view_projects);
        Project[] projects = {
          new Project("Getting started App", "Our very first project", R.drawable.getting_started),
          new Project("Vin quote", "Motivational Quotes", R.drawable.quote),
          new Project("BMI calculator", "Calculates BMI", R.drawable.calculator),
          new Project("Inches converter", "Converts inches to meters", R.drawable.tape),
          new Project("The hungry developer", "Restaurant app", R.drawable.hungry_developer),
        };

        list.setAdapter(new ProjectsAdapter(projects));
    }
}