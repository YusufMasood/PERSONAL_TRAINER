package com.example.personaltrainer.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personaltrainer.R
import kotlinx.coroutines.delay


@Composable
fun OtpScreen(
    phone: String,
    verificationId: String,
    onOtpVerified: (String) -> Unit,
    onResendOtp: () -> Unit
) {

    val context = LocalContext.current

    // OTP Boxes (6 digits)
    val otp = remember { mutableStateListOf("", "", "", "", "", "") }
    val focusRequesters = List(6) { FocusRequester() }

    // Timer
    var secondsLeft by remember { mutableIntStateOf(60) }
    var resendEnabled by remember { mutableStateOf(false) }

    // Timer Logic
    LaunchedEffect(Unit) {
        while (secondsLeft > 0) {
            delay(1000)
            secondsLeft--
        }
        resendEnabled = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(70.dp))

            Image(
                painter = painterResource(R.drawable.otpsent),
                contentDescription = "OTP Image",
                modifier = Modifier.size(280.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "OTP Verification",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Enter the OTP sent to +91 $phone",
                fontSize = 18.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))

            // OTP Input Boxes
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                (0 until 6).forEach { index ->

                    TextField(
                        value = otp[index],
                        onValueChange = { newValue ->

                            if (newValue.length <= 1) {
                                otp[index] = newValue

                                // Move right
                                if (newValue.isNotEmpty() && index < 5) {
                                    focusRequesters[index + 1].requestFocus()
                                }

                                // Move left on delete
                                if (newValue.isEmpty() && index > 0) {
                                    focusRequesters[index - 1].requestFocus()
                                }

                                // If all 6 digits filled
                                if (otp.joinToString("").length == 6) {
                                    onOtpVerified(otp.joinToString(""))
                                }
                            }
                        },
                        modifier = Modifier
                            .width(50.dp)
                            .height(60.dp)
                            .focusRequester(focusRequesters[index])
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFF2F2F2)),
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            cursorColor = Color.Black,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Resend Timer
            if (!resendEnabled) {
                Text(
                    text = "Resend OTP in $secondsLeft sec",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            } else {
                Text(
                    text = "Resend OTP",
                    color = Color(0xFF2196F3),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable {
                        onResendOtp()
                    }
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Verify Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(
                        Brush.horizontalGradient(
                            listOf(Color(0xFF5B86E5), Color(0xFF36D1DC))
                        )
                    )
                    .clickable {
                        val fullOtp = otp.joinToString("")
                        if (fullOtp.length == 6) {
                            onOtpVerified(fullOtp)
                        } else {
                            Toast.makeText(context, "Enter complete OTP", Toast.LENGTH_SHORT).show()
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Verify OTP",
                    color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}


