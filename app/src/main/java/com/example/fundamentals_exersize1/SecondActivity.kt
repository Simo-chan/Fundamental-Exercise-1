package com.example.fundamentals_exersize1

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private var messageTextView: TextView? = null
    private var sendButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val message = intent.getStringExtra(MESSAGE_TAG)

        messageTextView = findViewById(R.id.preview_text)
        sendButton = findViewById(R.id.send_button)

        messageTextView?.text = message.orEmpty()

        //Opens an email app and sends the message
        sendButton?.setOnClickListener {
            onSendButtonClicked(message.orEmpty())
        }
    }

    private fun onSendButtonClicked(message: String) {
        val messageSubject = getString(R.string.email_subject)
        val messageRecipient = arrayOf(getString(R.string.email_adress))
        val sendIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse(MAIL_TO_URI)
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

    companion object {
        private const val MESSAGE_TAG = "message"
        private const val MAIL_TO_URI = "mailto"
        fun start(context: Context, message: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(MESSAGE_TAG, message)
            context.startActivity(intent)
        }
    }
}