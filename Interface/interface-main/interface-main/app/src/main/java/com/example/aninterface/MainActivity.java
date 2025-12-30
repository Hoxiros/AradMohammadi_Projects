package com.example.interfaceapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnMessage, btnChangeColor, btnWeb, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMessage = findViewById(R.id.btnMessage);
        btnChangeColor = findViewById(R.id.btnChangeColor);
        btnWeb = findViewById(R.id.btnWeb);
        btnShare = findViewById(R.id.btnShare);

        if (btnMessage == null) {
            Toast.makeText(this, "Layout Error: Buttons not found!", Toast.LENGTH_LONG).show();
            return;
        }

        btnMessage.setOnClickListener(v -> Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show());

        btnChangeColor.setOnClickListener(v -> getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFE0B2")));

        btnWeb.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello from Interface App!");
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        });
    }
}