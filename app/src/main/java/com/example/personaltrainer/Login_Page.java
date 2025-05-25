package com.example.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login_Page extends AppCompatActivity {

    EditText passwordField, emailFeild ;
    Button loginButton, Btngog, Btnfb, BtnPhone;
    CheckBox remembercheck;
    TextView forgetpass, signInWith, createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        emailFeild = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);
        Btngog = findViewById(R.id.Btngog);
        Btnfb = findViewById(R.id.Btnfb);
        BtnPhone = findViewById(R.id.BtnPhone);
        remembercheck = findViewById(R.id.rememberCheck);
        forgetpass = findViewById(R.id.forgotPass);
        createAccount = findViewById(R.id.createAccount);


        Intent inext = new Intent(Login_Page.this,First_Page.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailFeild.setText("");
                passwordField.setText("");
                startActivity(inext);
            }
        });

        Intent jnext =new Intent(Login_Page.this, Personal_Info.class);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(jnext);
            }
        });
    }
}