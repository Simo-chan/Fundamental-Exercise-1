package com.example.fundamentals_exersize1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val messageView: TextView = findViewById(R.id.preview_text)
        val message = intent.getStringExtra("message")
        messageView.text = message

        val messageSubject = getString(R.string.email_subject)
        val messageRecipient = arrayOf(getString(R.string.email_adress))

        //Opens an email app and sends the message
        val sendButton: Button = findViewById(R.id.send_button)
        sendButton.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, messageRecipient)
                putExtra(Intent.EXTRA_SUBJECT, messageSubject)
                putExtra(Intent.EXTRA_TEXT, message)
            }
            try {
                startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, getString(R.string.no_email_app_found), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}