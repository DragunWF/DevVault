package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devvault.helpers.Utils;

public class ProfileActivity extends AppCompatActivity {
    private ImageView profileImageView, backImageView;
    private TextView capsulesTextView, milestoneTextView, ideaTextView, otherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        try {
            profileImageView = findViewById(R.id.profileImageView);
            backImageView = findViewById(R.id.backImageView);
            capsulesTextView = findViewById(R.id.capsulesTextView);
            milestoneTextView = findViewById(R.id.milestoneTextView);
            ideaTextView = findViewById(R.id.ideaTextView);
            otherTextView = findViewById(R.id.otherTextView);
            setButtons();
        } catch (Exception err) {
            Utils.toast(this, err.getMessage());
        }
    }

    private void setButtons() {
        backImageView.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        });
    }
}