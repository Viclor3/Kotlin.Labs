package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_layout)
    }

    fun handleTap(view: View) {
        val textView = findViewById<TextView>(R.id.customText)
        val text = textView.text.toString()
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}