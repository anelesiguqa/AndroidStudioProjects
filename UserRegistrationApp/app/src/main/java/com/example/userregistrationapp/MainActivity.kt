package com.example.userregistrationapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var title: Spinner? = null
    private var firstNameEditText: TextInputEditText? = null
    private var lastNameEditText: TextInputEditText? = null
    private var emailEditText: TextInputEditText? = null
    private var numberEditText: TextInputEditText? = null
    private var passwordEditText: TextInputEditText? = null
    private var previewDetialsButton: Button? = null

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
        initialTitleSpinner()
        previewDetails()
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
        previewDetialsButton?.setOnClickListener {
            val title = this.title?.selectedItem.toString()
            val firstName = firstNameEditText?.text.toString()
            val lastName = lastNameEditText?.text.toString()
            val email = emailEditText?.text.toString()
            val number = numberEditText?.text.toString()

            val userDetails = User(title, firstName, lastName, email, number)
            val summaryIntent = Intent(this, Summary::class.java)
            summaryIntent.putExtra("User", userDetails)
            print("momo")

            startActivity(summaryIntent)
        }
    }
    private fun initialTitleSpinner() {
        val titleOptions = arrayOf("Mr", "Miss", "Sir")
        val titleOptionsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titleOptions)
        this.title?.adapter = titleOptionsAdapter
    }
}