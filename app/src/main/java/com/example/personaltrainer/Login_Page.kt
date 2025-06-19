package com.example.personaltrainer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Login_Page : AppCompatActivity() {
    private lateinit var passwordField: EditText
    private lateinit var emailFeild: EditText
    private lateinit var loginButton: Button
    private lateinit var Btngog: Button
    private lateinit var Btnfb: Button
    private lateinit var BtnPhone: Button
    private lateinit var remembercheck: CheckBox
    private lateinit var forgetpass: TextView
    private lateinit var signInWith: TextView
    private lateinit var createAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        emailFeild = findViewById(R.id.emailField)
        passwordField = findViewById(R.id.passwordField)
        loginButton = findViewById(R.id.loginButton)
        Btngog = findViewById(R.id.Btngog)
        Btnfb = findViewById(R.id.Btnfb)
        BtnPhone = findViewById(R.id.BtnPhone)
        remembercheck = findViewById(R.id.rememberCheck)
        forgetpass = findViewById(R.id.forgotPass)
        createAccount = findViewById(R.id.createAccount)


        val inext = Intent(
            this@Login_Page,
            First_Page::class.java
        )

        loginButton.setOnClickListener(View.OnClickListener {
            emailFeild.setText("")
            passwordField.setText("")
            startActivity(inext)
        })

        val jnext = Intent(
            this@Login_Page,
            Personal_Info::class.java
        )
        val knext = Intent(
            this@Login_Page,
            BMR_Calculator::class.java
        )

        createAccount.setOnClickListener(View.OnClickListener { startActivity(jnext) })

        Btngog.setOnClickListener(View.OnClickListener { startActivity(knext) })
    }
}