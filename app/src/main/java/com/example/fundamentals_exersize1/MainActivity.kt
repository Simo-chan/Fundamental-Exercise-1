package com.example.fundamentals_exersize1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var editText: EditText? = null
    private var previewButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        previewButton = findViewById(R.id.preview_button)

        previewButton?.setOnClickListener {
            onPreviewButtonClicked()
        }
    }

    private fun onPreviewButtonClicked() {
        SecondActivity.start(this, editText?.text.toString())
    }
}