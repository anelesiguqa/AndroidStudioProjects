package za.co.anelesiguqa.thehungrydeveloper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CardView startersCard;
    CardView mainsCard;
    CardView dessertsCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_mains);
        dessertsCard = findViewById(R.id.card_view_desserts);

        startersCard.setOnClickListener(view -> {
            Intent startersActivityIntent = new Intent(MainActivity.this, StarterActivity.class);

            startActivity(startersActivityIntent);
        });

        mainsCard.setOnClickListener(view -> {
            Intent mainCoursesIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
            startActivity(mainCoursesIntent);
        });

        dessertsCard.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, DessertsActivity.class));
        });
        TextView emailTextView = findViewById(R.id.text_view_email_address);
        emailTextView.setOnClickListener(view -> {
            Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
            launchEmailAppIntent.setData(Uri.parse("mailto:"+emailTextView.getText().toString()));
            startActivity(launchEmailAppIntent);
        });
    }
}