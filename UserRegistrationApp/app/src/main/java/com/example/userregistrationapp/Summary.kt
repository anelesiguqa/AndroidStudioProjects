package com.example.userregistrationapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Summary : AppCompatActivity() {
    private var text_view_title: TextView? = null;
    private var text_view_firtName: TextView? = null
    private var text_view_lastName: TextView? = null
    private var text_view_email: TextView? = null
    private var text_view_number: TextView? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_summary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViews()
        createSummary()
        setupEmailClickHandler()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun createSummary() {
        val user = intent.getSerializableExtra("User", User::class.java)

        text_view_title?.text = user?.title
        text_view_firtName?.text = user?.firstName
        text_view_lastName?.text = user?.lastName
        text_view_email?.text = user?.email
        text_view_number?.text = user?.number
    }
    private fun findViews() {
      text_view_title = findViewById(R.id.text_view_title)
      text_view_firtName = findViewById(R.id.text_view_first_name)
      text_view_lastName = findViewById(R.id.text_view_last_name)
      text_view_email = findViewById(R.id.text_view_email)
      text_view_number = findViewById(R.id.text_view_number)
    }
    private fun setupEmailClickHandler() {
        text_view_email?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${text_view_email?.text.toString()}")
            startActivity(intent)
        }
        text_view_number?.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${text_view_number?.text.toString()}")
            startActivity(intent)
        }
    }
}