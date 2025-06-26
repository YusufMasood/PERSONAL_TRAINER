package com.example.personaltrainer

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tools : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tools)

        val bmrTool = findViewById<LinearLayout>(R.id.bmrTool)

        val inext = Intent(this, BMR_Calculator::class.java)

        bmrTool.setOnClickListener {
            startActivity(inext)
        }

    }
}