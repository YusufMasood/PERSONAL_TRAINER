package com.example.personaltrainer


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.personaltrainer.ui.OtpScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

class OtpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val phone = intent.getStringExtra("PHONE") ?: ""
        var verificationId = intent.getStringExtra("verificationId") ?: ""

        val auth = FirebaseAuth.getInstance()

        setContent {
            OtpScreen(
                phone = phone,
                verificationId = verificationId,

                onOtpVerified = { otp ->
                    val credential = PhoneAuthProvider.getCredential(verificationId, otp)

                    auth.signInWithCredential(credential).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "OTP Verified!!", Toast.LENGTH_SHORT).show()

                            // TODO → Navigate to Home screen
                             startActivity(Intent(this, First_Page::class.java))
                            // finish()

                        } else {
                            Toast.makeText(this, "Invalid OTP!", Toast.LENGTH_SHORT).show()
                        }
                    }
                },

                onResendOtp = {
                    Toast.makeText(this, "Resend OTP ", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}
