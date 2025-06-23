package com.example.personaltrainer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BMR_Result : AppCompatActivity() {

    private lateinit var  button_recalculate : Button
    private lateinit var txtBmrRes : TextView
    private lateinit var txtTDEE : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_bmr_result)



        button_recalculate = findViewById(R.id.button_recalculate)
        txtBmrRes = findViewById(R.id.txtBmrRes)
        txtTDEE = findViewById(R.id.txtTDEE)

       val bmr = intent.getStringExtra("BMR")
        txtBmrRes.setText(bmr)

        val tdee = intent.getStringExtra("TDEE")
        txtTDEE.setText(tdee)




    button_recalculate.setOnClickListener(View.OnClickListener {
        val inext = Intent(this@BMR_Result, BMR_Calculator::class.java)
        startActivity(inext)
    })




}
    }
