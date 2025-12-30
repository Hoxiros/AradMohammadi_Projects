package com.example.personalinfo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    private TextView tvNameDisplay, tvJobDisplay, tvDetailsDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infoactivity);

        tvNameDisplay = findViewById(R.id.tvNameDisplay);
        tvJobDisplay = findViewById(R.id.tvJobDisplay);
        tvDetailsDisplay = findViewById(R.id.tvDetailsDisplay);

        UserInformation user = (UserInformation) getIntent().getSerializableExtra("USER_DATA");

        if (user != null) {
            tvNameDisplay.setText(user.getName());
            tvJobDisplay.setText(user.getJob());
            tvDetailsDisplay.setText("Age: " + user.getAge() + " | Country: " + user.getCountry());
        } else {
            tvNameDisplay.setText("No Data Received");
        }
    }
}