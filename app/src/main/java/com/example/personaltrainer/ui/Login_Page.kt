package com.example.personaltrainer.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.OtpActivity
import com.example.personaltrainer.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class Login_Page : AppCompatActivity() {

    private lateinit var Phone: EditText
    private lateinit var SendOtp: Button
    private lateinit var remembercheck: CheckBox

    private lateinit var btnSkip: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        // Firebase
        auth = FirebaseAuth.getInstance()

        // Views
        Phone = findViewById(R.id.Phone)
        SendOtp = findViewById(R.id.SendOtp)
        remembercheck = findViewById(R.id.rememberCheck)
        btnSkip = findViewById(R.id.btnSkip)

        // OTP Callbacks
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // Auto-verification
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(this@Login_Page, "Verification Failed: ${e.message}", Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                super.onCodeSent(verificationId, token)

                val intent = Intent(this@Login_Page, OtpActivity::class.java)
                intent.putExtra("PHONE", Phone.text.toString().trim())
                intent.putExtra("verificationId", verificationId)
                startActivity(intent)
            }
        }

        btnSkip.setOnClickListener {
            val intent  = Intent(this, First_Page::class.java)
            startActivity(intent)
        }


        // Send OTP Logic
        SendOtp.setOnClickListener {

            val phone = Phone.text.toString().trim()

            if (phone.isEmpty() || phone.length != 10) {
                Toast.makeText(this, "Enter valid phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val numberWithCode = "+91$phone"

            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(numberWithCode)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(mCallbacks)
                .build()

            PhoneAuthProvider.verifyPhoneNumber(options)
        }
    }
}