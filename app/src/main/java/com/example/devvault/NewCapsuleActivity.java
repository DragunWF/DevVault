package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.devvault.helpers.Utils;

public class NewCapsuleActivity extends AppCompatActivity {
    private ImageView backImageView;
    private EditText titleEditText, typeEditText, descriptionEditText, codeEditText, tagsEditText,
                     dayEditText, monthEditText, yearEditText;
    private Button saveCapsuleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_capsule);
        try {
            backImageView = findViewById(R.id.backImageView);
            titleEditText = findViewById(R.id.titleEditText);
            typeEditText = findViewById(R.id.typeEditText);
            descriptionEditText = findViewById(R.id.descriptionEditText);
            codeEditText = findViewById(R.id.snippetEditText);
            tagsEditText = findViewById(R.id.tagsEditText);
            dayEditText = findViewById(R.id.dayEditText);
            monthEditText = findViewById(R.id.monthEditText);
            yearEditText = findViewById(R.id.yearEditText);
            saveCapsuleBtn = findViewById(R.id.saveCapsuleBtn);
        } catch (Exception err) {
            Utils.toast(this, err.getMessage());
        }
    }

    private void setButtons() {
        saveCapsuleBtn.setOnClickListener(v -> {

        });
    }
}