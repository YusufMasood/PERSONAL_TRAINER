package com.example.personaltrainer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Personal_Info : AppCompatActivity() {
    private lateinit var txtName: EditText
    private lateinit var txtAge: EditText
    private lateinit var spinGender: Spinner
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_personal_info)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val genders = arrayOf("Gender","Male", "Female")

        txtName = findViewById(R.id.txtName)
        txtAge = findViewById(R.id.txtAge)
        spinGender = findViewById(R.id.spinGender)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setEnabled(false)

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, genders

        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinGender.setAdapter(adapter)

        spinGender.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                position: Int,
                l: Long
            ) {
                val name = txtName.getText().toString().trim { it <= ' ' }
                val age = txtAge.getText().toString().trim { it <= ' ' }

                if (position != 0 && !name.isEmpty() && !age.isEmpty()) {
                    //    String selectedGender = genders[position];
                    btnNext.setEnabled(true)

                    //Toast.makeText(create_account.this,"Selected Gender: " + selectedGender, Toast.LENGTH_SHORT).show();
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        })
        val inext =
            Intent(this@Personal_Info, Create_Account::class.java)

        btnNext.setOnClickListener(View.OnClickListener { startActivity(inext) })
    }
}