package za.co.anelesiguqa.theshamelessself_promoapp2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreviewActivity : AppCompatActivity() {
    private lateinit var message: Message
    private lateinit var messagePreviewText: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message

        messagePreviewText = """
        Contact Name: ${message.contactNumber}
        Contact Number: ${message.contactNumber}
        My Display Name: ${message.myDisplayName}
        Include Junior: ${message.includeJunior}
        Job Title: ${message.jobTitle}
        Immediate Start: ${message.immediateStart}
        Start Date: ${message.startDate}
    """.trimIndent()

        findViewById<TextView>(R.id.text_view_message).text = messagePreviewText
    }

    private fun setupButton() {
        findViewById<Button>(R.id.button_send_message).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }
}