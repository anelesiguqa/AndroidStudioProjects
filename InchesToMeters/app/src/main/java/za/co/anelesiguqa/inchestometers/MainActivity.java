package za.co.anelesiguqa.inchestometers;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextInputInches;
    Button buttonCalculateMeters;
    TextView textViewMetersDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findViews();

        buttonCalculateMeters.setOnClickListener(view -> {
            if (!isEmpty()) {
                displayResult(convertToMeters());
            }
        });
    }

    void findViews() {
        editTextInputInches = findViewById(R.id.edit_text_inches);
        buttonCalculateMeters = findViewById(R.id.button_calculate_inches);
        textViewMetersDisplay = findViewById(R.id.text_view_meters);
    }

    double convertToMeters() {
        double valueToConvert = Double.parseDouble(editTextInputInches.getText().toString());
        return valueToConvert * 0.0254;
    }

    void displayResult(double valueToDisplay) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        String formattedValueToDisplay = formatter.format(valueToDisplay) + " meters";

        textViewMetersDisplay.setText(formattedValueToDisplay);
    }

    boolean isEmpty() {
        String userInput = editTextInputInches.getText().toString();

        if (userInput.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a value in inches to be converted", Toast.LENGTH_LONG).show();
            textViewMetersDisplay.setText("");
            return true;
        }
        return false;
    }
}