package com.example.userregistrationapp

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var title: Spinner
    private lateinit var firstNameEditText: TextInputEditText
    private lateinit var lastNameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var numberEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var previewDetialsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getControls()
    }

    private fun getControls() {
        title = findViewById(R.id.spinner_title)
        firstNameEditText = findViewById(R.id.edit_text_firstName)
        lastNameEditText = findViewById(R.id.edit_text_last_name)
        emailEditText = findViewById(R.id.edit_text_email)
        numberEditText = findViewById(R.id.edit_text_number)
        passwordEditText = findViewById(R.id.edit_text_password)
        previewDetialsButton = findViewById(R.id.button_preview_details)
    }
    private fun previewDetails() {
        previewDetialsButton.setOnClickListener {
            //Toast(this, "Happy holidays", Toast.LENGTH_LONG).show()
        }
    }
}