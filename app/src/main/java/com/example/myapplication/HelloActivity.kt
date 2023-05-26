package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class HelloActivity : AppCompatActivity() {
    private lateinit var aText: EditText
    private lateinit var bText: EditText
    private lateinit var cText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_layout)

        aText = findViewById(R.id.aVariableText)
        bText = findViewById(R.id.bVariableText)
        cText = findViewById(R.id.cVariableText)
    }

    /**
     * Lab1
     */
    fun handleTap(view: View) {
        val textView = findViewById<TextView>(R.id.customText)
        val text = textView.text.toString()
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    /**
     * Lab2
     */
    fun solveQuadraticEquation(view: View) {
        val a = aText.text.toString().toDouble()
        val b = bText.text.toString().toDouble()
        val c = cText.text.toString().toDouble()

        if (a.isNaN() || b.isNaN() || c.isNaN())
            Toast.makeText(this, "Одно из значений является NaN", Toast.LENGTH_SHORT).show()

        val discriminant = b * b - 4 * a * c

        if (discriminant < 0) {
            Toast.makeText(this, "$discriminant - корней нет", Toast.LENGTH_LONG).show()
        }

        if (discriminant >= 0) {
            var x1 = (-b + sqrt(discriminant)) / (2 * a)
            var x2 = (-b - sqrt(discriminant)) / (2 * a)

            if (x1.isNaN() || x1.isInfinite()) x1 = 0.0
            if (x2.isNaN() || x2.isInfinite()) x2 = 0.0

            val result = Pair(x1, x2).toString()
            Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        }
    }
}