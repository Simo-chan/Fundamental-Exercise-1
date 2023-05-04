package com.example.fundamentals_exersize1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.edit_text)

        val previewButton: Button = findViewById(R.id.preview_button)
        previewButton.setOnClickListener {
            val message = editText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", message)
            startActivity(intent)
        }
    }
}