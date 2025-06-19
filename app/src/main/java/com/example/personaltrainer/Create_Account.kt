package com.example.personaltrainer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Create_Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_create_account)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtSetUser = findViewById<EditText>(R.id.txtSetUser)
        val txtpass = findViewById<EditText>(R.id.txtpass)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val termcondition = findViewById<CheckBox>(R.id.termcondition)

        btnNext.isEnabled = false

        termcondition.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
            btnNext.isEnabled = true
        }

        val inext = Intent(
            this@Create_Account,
            Login_Page::class.java
        )

        btnNext.setOnClickListener { startActivity(inext) }
    }
}