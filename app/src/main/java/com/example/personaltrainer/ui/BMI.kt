package com.example.personaltrainer.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class BMI {


    @OptIn(ExperimentalMaterial3Api::class)

    @Composable
    fun bmi(){

        var weight by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
                 horizontalAlignment = Alignment.CenterHorizontally
        ){

            OutlinedTextField(
                value = weight,
                onValueChange = {weight = it},

                label = {Text("Weight")},
                singleLine = true,
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                ),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.Cyan,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLeadingIconColor = Color.Cyan,
                    unfocusedTrailingIconColor = Color.Cyan

                )


            )


            OutlinedTextField(
                value = weight,
                onValueChange = {weight = it},

                label = {Text("Height in Feet")},
                singleLine = true,
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                ),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.Cyan,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLeadingIconColor = Color.Cyan,
                    unfocusedTrailingIconColor = Color.Cyan

                )


            )

            OutlinedTextField(
                value = weight,
                onValueChange = {weight = it},

                label = {Text("Height in Inch")},
                singleLine = true,
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                ),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.Cyan,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLeadingIconColor = Color.Cyan,
                    unfocusedTrailingIconColor = Color.Cyan

                )


            )


            OutlinedTextField(
                value = weight,
                onValueChange = {weight = it},

                label = {Text("Age")},
                singleLine = true,
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                ),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.Cyan,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.White,
                    focusedLeadingIconColor = Color.Cyan,
                    unfocusedTrailingIconColor = Color.Cyan

                )


            )

            Button(onClick = {}) {Text("Click me") }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun look(){

    BMI().bmi()

}