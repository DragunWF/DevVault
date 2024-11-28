package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devvault.helpers.SessionData;
import com.example.devvault.helpers.Utils;

public class ProfileActivity extends AppCompatActivity {
    private ImageView profileImageView, backImageView;
    private TextView capsulesTextView, milestoneTextView, ideaTextView,
                     aspirationTextView, productivityTextView;

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
            aspirationTextView = findViewById(R.id.aspirationTextView);
            productivityTextView = findViewById(R.id.productivityTextView);
            setButtons();
            displayProfileData();
        } catch (Exception err) {
            Utils.toast(this, err.getMessage());
        }
    }

    @SuppressLint("SetTextI18n")
    private void displayProfileData() {
        capsulesTextView.setText("Total Capsules: " + SessionData.getCapsuleCount());
        milestoneTextView.setText("Milestone Capsules: " + SessionData.getCapsuleTypeCount("Milestone"));
        ideaTextView.setText("Idea Capsules: " + SessionData.getCapsuleTypeCount("Idea"));
        aspirationTextView.setText("Aspiration Capsules: " + SessionData.getCapsuleTypeCount("Aspiration"));
        productivityTextView.setText("Productivity Capsules: " + SessionData.getCapsuleTypeCount("Productivity"));
    }

    private void setButtons() {
        backImageView.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        });
    }
}