package com.example.ca_execution

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sb1 = findViewById<EditText>(R.id.et1)
        val sb2 = findViewById<EditText>(R.id.et2)
        val sb3 = findViewById<EditText>(R.id.et3)
        val btn = findViewById<Button>(R.id.bt)

        btn.setOnClickListener {

            val sbb1= sb1.text.toString().toFloat()
            val sbb2 = sb2.text.toString().toFloat()
            val sbb3 = sb3.text.toString().toFloat()

            val cgpa = (sbb1 + sbb2 + sbb3) / 30
            sb1.setText("")
            sb2.setText("")
            sb3.setText("")
            val cgpaR = String.format("%.2f", cgpa)

            Toast.makeText(this, "Your CGPA is $cgpaR", Toast.LENGTH_LONG).show()
        }
    }
}