package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devvault.data.Capsule;
import com.example.devvault.helpers.DatabaseHelper;
import com.example.devvault.helpers.SessionData;
import com.example.devvault.helpers.Utils;

public class ViewCapsuleActivity extends AppCompatActivity {
    private ImageView backImageView;
    private TextView dateCreatedTextView, openedDateTextView, typeTextView,
                     descriptionTextView, tagsTextView, titleTextView;
    private Button addReflectionButton;

    private Capsule capsule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_capsule);
        try {
            backImageView = findViewById(R.id.imageView);
            titleTextView = findViewById(R.id.capsuleTitleTextView);
            dateCreatedTextView = findViewById(R.id.dateCreatedTextView);
            openedDateTextView = findViewById(R.id.openedDateTextView);
            typeTextView = findViewById(R.id.typeTextView);
            descriptionTextView = findViewById(R.id.descriptionTextView);
            tagsTextView = findViewById(R.id.tagsTextView);
            addReflectionButton = findViewById(R.id.addReflectionButton);

            DatabaseHelper.initialize(this);
            capsule = DatabaseHelper.getCapsuleById(SessionData.getViewedCapsuleId());

            setButtons();
            setCapsuleData();
        } catch (Exception err) {
            System.out.println(err.getMessage());
            Utils.longToast(this, err.getMessage());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            setButtons();
        } catch (Exception err) {
            Utils.longToast(this, err.getMessage());
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCapsuleData() {
        titleTextView.setText(capsule.getTitle());
        openedDateTextView.setText(capsule.getOpeningDate());
        dateCreatedTextView.setText(capsule.getCreationDate());
        typeTextView.setText("Type: " + capsule.getType());
        descriptionTextView.setText(capsule.getDescription());

        // Comma separated tags, Ex: Python, Java, Go, C++
        tagsTextView.setText(String.join(", ", capsule.getTags().split(" ")));
    }

    private void setButtons() {
        if (DatabaseHelper.getReflectionByCapsuleId(capsule.getId()) != null) {
            addReflectionButton.setText("Edit Reflection");
        }

        backImageView.setOnClickListener(v -> finish());
        addReflectionButton.setOnClickListener(v -> {
            startActivity(new Intent(ViewCapsuleActivity.this, ViewReflectionActivity.class));
        });
    }
}