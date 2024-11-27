package za.co.anelesiguqa.selfpromoapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val preview: Button = findViewById(R.id.button_preview);
        preview.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun onPreviewClicked() {
        val contactNameEditText: TextInputEditText = findViewById(R.id.edit_text_contact_name);
        val contactNumberEditText: TextInputEditText = findViewById(R.id.edit_text_contact_number);
        val testString = contactNameEditText.text.toString() + ", " + contactNumberEditText.text.toString();

        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()
    }

}