package za.co.anelesiguqa.theshamelessself_promoapp2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var contactNameEditText: TextInputEditText? = null
    private var contactNumberEditText: TextInputEditText? = null
    private var myDisplayNameEditText: TextInputEditText? = null
    private var startDateEditText: TextInputEditText? = null
    private var juniorCheckBox: CheckBox? = null
    private var immediateStartCheckBox: CheckBox? = null
    private var jobTitleSpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText = findViewById(R.id.edit_text_my_display_name)
        startDateEditText = findViewById(R.id.edit_text_start_date)
        juniorCheckBox = findViewById(R.id.check_box_junior)
        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)

        val previewButton: Button = findViewById(R.id.button_preview)
        previewButton.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues = arrayOf("Wanda", "Luzuko", "Lukon")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)

        jobTitleSpinner?.adapter = spinnerAdapter
    }
    private fun onPreviewClicked() {
        val contactName = contactNameEditText?.text.toString()
        val contactNumber = contactNumberEditText?.text.toString()
        val myDisplayName = myDisplayNameEditText?.text.toString()
        val includeJunior = juniorCheckBox?.isChecked
        val jobTitle = jobTitleSpinner?.selectedItem.toString()
        val immediateStart = immediateStartCheckBox?.isChecked
        val startDate = startDateEditText?.text.toString()

        val message = Message(
            contactNameEditText?.text.toString(),
            contactNumberEditText?.text.toString(),
            myDisplayNameEditText?.text.toString(),
            juniorCheckBox?.isChecked,
            jobTitleSpinner?.selectedItem.toString(),
            immediateStartCheckBox?.isChecked,
            startDateEditText?.text.toString()
        )
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)

        startActivity(previewActivityIntent)
    }
}