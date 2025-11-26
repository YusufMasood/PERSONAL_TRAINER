package com.example.personaltrainer.ui

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.BmiActivity
import com.example.personaltrainer.R

class Tools : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tools)

        val bmrTool = findViewById<LinearLayout>(R.id.bmrTool)
        val bmiTool = findViewById<LinearLayout>(R.id.bmiTool)
        var fatTools = findViewById<LinearLayout>(R.id.fatTool)

        val inext = Intent(this, BMR_Calculator::class.java)
        val jnext = Intent(this, BmiActivity::class.java)

        bmrTool.setOnClickListener {
            startActivity(inext)
        }

        bmiTool.setOnClickListener {
            startActivity(jnext)
        }

        fatTools.setOnClickListener {

        }

    }
}