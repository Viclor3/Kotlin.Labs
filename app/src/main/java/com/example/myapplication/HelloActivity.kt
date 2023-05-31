package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.lang.Exception
import kotlin.math.sqrt

class HelloActivity : AppCompatActivity() {
    private lateinit var aText: EditText
    private lateinit var bText: EditText
    private lateinit var cText: EditText
    private lateinit var discriminantText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_layout)

        aText = findViewById(R.id.aVariableText)
        bText = findViewById(R.id.bVariableText)
        cText = findViewById(R.id.cVariableText)
        discriminantText = findViewById(R.id.discriminant)
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
        try {
            val a = aText.text.toString().toDouble()
            val b = bText.text.toString().toDouble()
            val c = cText.text.toString().toDouble()

            if (a.isNaN() || b.isNaN() || c.isNaN()) {
                discriminantText.text = "Одно из значений является NaN"
                discriminantText.visibility = View.VISIBLE
                return
            }

            if (a == 0.0) {
                if (b == 0.0) {
                    if (c == 0.0) {
                        discriminantText.text = "Бесконечное количество решений"
                    } else {
                        discriminantText.text = "Уравнение не имеет решений"
                    }
                } else {
                    val x = -c / b
                    discriminantText.text = "$x"
                }
                discriminantText.visibility = View.VISIBLE
                return
            }

            val discriminant = b * b - 4 * a * c

            if (discriminant < 0) {
                discriminantText.text = "Корней нет"
                discriminantText.visibility = View.VISIBLE
                return
            }

            if (discriminant >= 0) {
                var x1 = (-b + sqrt(discriminant)) / (2 * a)
                var x2 = (-b - sqrt(discriminant)) / (2 * a)

                if (x1.isNaN() || x1.isInfinite()) x1 = 0.0
                if (x2.isNaN() || x2.isInfinite()) x2 = 0.0

                val roots = Pair(x1, x2).toString()
                discriminantText.text = roots
                discriminantText.visibility = View.VISIBLE
            }
        } catch (e: Exception) {
            discriminantText.text = "Не все значения введены"
            discriminantText.visibility = View.VISIBLE
        }
    }

}