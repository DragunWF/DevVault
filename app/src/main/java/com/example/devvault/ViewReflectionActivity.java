package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devvault.helpers.Utils;

public class ViewReflectionActivity extends AppCompatActivity {
    private ImageView backImageView;
    private TextView capsuleTitleTextView, dateCreatedTextView, openedDateTextView;
    private EditText reflectionEditText;
    private Button submitReflectionBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reflection);
        try {
            backImageView = findViewById(R.id.backImageView);
            capsuleTitleTextView = findViewById(R.id.capsuleTitleTextView);
            dateCreatedTextView = findViewById(R.id.dateCreatedTextView);
            openedDateTextView = findViewById(R.id.openedDateTextView);
            reflectionEditText = findViewById(R.id.reflectionEditText);
            submitReflectionBtn = findViewById(R.id.submitReflectionBtn);
        } catch (Exception err) {
            Utils.toast(this, err.getMessage());
        }
    }
    private void setButtons() {
        submitReflectionBtn.setOnClickListener(v -> {

        });
    }
}