package za.co.anelesiguqa.bmicalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    RadioButton maleBtn;
    RadioButton femaleBtn;
    EditText ageEditText;

    EditText feetEditText;
    EditText inchesEditText;
    EditText weightEditText;
    Button calculateBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void setupButtonClickListener() {
        calculateBtn.setOnClickListener(
                view -> {
                    double bmi = calculateBmi();

                    int age = Integer.parseInt(ageEditText.getText().toString());

                    if (age >= 18) {
                        displayResult(bmi);
                    } else {
                        displayGuidance(bmi);
                    }
                });
    }

    private void displayGuidance(double bmi) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        String bmiAsText = formatter.format(bmi);

        String fullResult;
        if (maleBtn.isChecked()) {
            fullResult = bmiAsText + " - Please consult doctor for under 18 males";
        } else if (femaleBtn.isChecked()){
            fullResult = bmiAsText + " - Pleaase consult doctor for under 18 females";
        } else {
            fullResult = bmiAsText + " - Please consult with doctor as you are under 18";
        }
        resultText.setText(fullResult);
    }

    private double calculateBmi() {
        int feet = Integer.parseInt(feetEditText.getText().toString());
        int inches = Integer.parseInt(inchesEditText.getText().toString());
        int weight = Integer.parseInt(weightEditText.getText().toString());

        inches += feet * 12;
        double height = inches * 0.0254;
        return weight / Math.pow(height, 2);
    }

    private void displayResult(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (bmi < 18.5) {
            fullResultString = (bmiTextResult + " - You are underweight");
        } else if (bmi > 25) {
            fullResultString = (bmiTextResult + " - You are overweight");
        } else {
            fullResultString = (bmiTextResult + " - You are a healthy weight");
        }
        resultText.setText(fullResultString);
    }

    private void findViews() {
        maleBtn = findViewById(R.id.radio_button_male);
        femaleBtn = findViewById(R.id.radio_button_female);
        ageEditText = findViewById(R.id.edit_text_age);

        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);
        calculateBtn = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }
}