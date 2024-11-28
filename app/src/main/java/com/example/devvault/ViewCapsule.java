package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devvault.helpers.Utils;

public class ViewCapsule extends AppCompatActivity {
    ImageView backImageView;
    TextView dateCreatedTextView, openedDateTextView, typeTextView, descriptionTextView, tagsTextView;
    Button addReflectionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_capsule);
        try {
            backImageView = findViewById(R.id.backImageView);
            dateCreatedTextView = findViewById(R.id.dateCreatedTextView);
            openedDateTextView = findViewById(R.id.openedDateTextView);
            typeTextView = findViewById(R.id.typeTextView);
            descriptionTextView = findViewById(R.id.descriptionTextView);
            tagsTextView = findViewById(R.id.tagsTextView);
            addReflectionButton = findViewById(R.id.addReflectionButton);
        } catch (Exception err) {
            Utils.toast(this, err.getMessage());
        }
    }

    private void setButtons() {
        addReflectionButton.setOnClickListener(v -> {

        });
    }
}