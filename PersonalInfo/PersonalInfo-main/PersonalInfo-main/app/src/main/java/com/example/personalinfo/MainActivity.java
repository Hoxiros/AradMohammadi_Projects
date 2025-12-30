package com.example.personalinfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etName, etJob, etAge, etCountry;
    private MaterialButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // اتصال ویوها
        etName = findViewById(R.id.etName);
        etJob = findViewById(R.id.etJob);
        etAge = findViewById(R.id.etAge);
        etCountry = findViewById(R.id.etCountry);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String job = etJob.getText().toString().trim();
            String ageStr = etAge.getText().toString().trim();
            String country = etCountry.getText().toString().trim();


            if (name.isEmpty() || ageStr.isEmpty()) {
                Toast.makeText(this, "Name and Age are required!", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = Integer.parseInt(ageStr);


            UserInformation userInfo = new UserInformation(name, job, age, country);


            Intent intent = new Intent(MainActivity.this, InfoActivity.class);


            intent.putExtra("USER_DATA", userInfo);


            startActivity(intent);
        });
    }
}