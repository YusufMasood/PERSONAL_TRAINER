package com.example.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Personal_Info extends AppCompatActivity {

    EditText txtName, txtAge;
    Spinner spinGender;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] genders = {"Gender","Male","Female"};

        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        spinGender = findViewById(R.id.spinGender);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setEnabled(false);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,android.R.layout.simple_spinner_item,genders

        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinGender.setAdapter(adapter);

        spinGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                String name = txtName.getText().toString().trim();
                String age = txtAge.getText().toString().trim();

                if(position != 0 && !name.isEmpty() && !age.isEmpty()){
                //    String selectedGender = genders[position];
                    btnNext.setEnabled(true);

                    //Toast.makeText(create_account.this,"Selected Gender: " + selectedGender, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Intent inext;
        inext = new Intent(Personal_Info.this, Create_Account.class);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(inext);

            }
        });

    }
}