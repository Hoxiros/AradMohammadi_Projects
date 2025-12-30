package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(this);

        if (sharedPrefManager.isLoggedIn()) {

            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        } else {

            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        finish();
    }
}