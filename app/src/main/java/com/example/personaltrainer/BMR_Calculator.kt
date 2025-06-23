package com.example.personaltrainer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.MaterialAutoCompleteTextView

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BMR_Calculator : AppCompatActivity() {

    private lateinit var button_calculate: Button
    private lateinit var txtWeight : EditText
    private lateinit var txtHtfeet : EditText
    private lateinit var txtHtinc : EditText
    private lateinit var txtAge : EditText
    private lateinit var level : Spinner
    private lateinit var radio_male : RadioButton
    private lateinit var radio_female : RadioButton
    private lateinit var radio_gender : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_bmr_calculator)


         button_calculate = findViewById(R.id.button_calculate)
         txtWeight = findViewById(R.id.txtWeight)
         txtHtfeet = findViewById(R.id.txtHtfeet)
         txtHtinc = findViewById(R.id.txtHtinc)
         txtAge = findViewById(R.id.txtAge)
         radio_male = findViewById(R.id.radio_male)
         radio_female = findViewById(R.id.radio_female)
         radio_gender = findViewById(R.id.radio_gender)
         level = findViewById(R.id.level)



        val Level = listOf(
            "Activity Level",
            "Sedentary",
            "Lightly Active",
            "Moderately Active",
            "Very Active",
            "Extra Active")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Level)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        level.adapter = adapter

        button_calculate.setOnClickListener(View.OnClickListener {


            val Height = (txtHtfeet.text.toString().toInt() * 12 + txtHtinc.text.toString().toInt()) * 2.54
            val Weight = txtWeight.text.toString().toInt()
            val Age = txtAge.text.toString().toInt()


            val Gender = radio_gender.checkedRadioButtonId
            if(Gender == -1){
                Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val BMR : Double = when(Gender){
                R.id.radio_male -> ((10 * Weight) + (6.25 * Height) - (5 * Age) + 5)

                R.id.radio_female -> ((10 * Weight) + (6.25 * Height) - (5 * Age) - 161)

                else -> 0.0
            }

            val Level = level.selectedItem.toString()
            val tdee = when(Level){
                "Sedentary" -> BMR * 1.2
                "Lightly Active" -> BMR * 1.375
                "Moderately Active" -> BMR * 1.55
                "Very Active" -> BMR * 1.725
                "Extra Active" -> BMR * 1.9

                else -> BMR
            }

            val inext = Intent(this@BMR_Calculator, BMR_Result::class.java)
            inext.putExtra("BMR", BMR.toString())
            inext.putExtra("TDEE", String.format("%.3f", tdee))
            startActivity(inext)

        })
    }
}