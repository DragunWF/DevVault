package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(v -> {
            startActivity(new Intent(LandingPage.this, MainActivity.class));
        });
    }
}