package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devvault.data.Capsule;
import com.example.devvault.data.Reflection;
import com.example.devvault.helpers.DatabaseHelper;
import com.example.devvault.helpers.SessionData;
import com.example.devvault.helpers.Utils;

public class ViewReflectionActivity extends AppCompatActivity {
    private ImageView backImageView;
    private TextView capsuleTitleTextView, dateCreatedTextView, openedDateTextView;
    private EditText reflectionEditText;
    private Button submitReflectionBtn;

    private Capsule capsule;
    private Reflection reflection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reflection);
            backImageView = findViewById(R.id.backImageView);
            capsuleTitleTextView = findViewById(R.id.capsuleTitleTextView);
            dateCreatedTextView = findViewById(R.id.dateCreatedTextView);
            openedDateTextView = findViewById(R.id.openedDateTextView);
            reflectionEditText = findViewById(R.id.reflectionEditText);
            submitReflectionBtn = findViewById(R.id.submitReflectionBtn);

            capsule = DatabaseHelper.getCapsuleById(SessionData.getViewedCapsuleId());
            reflection = DatabaseHelper.getReflectionByCapsuleId(capsule.getId());

            setCapsuleData();
            setButtons();
    }

    private void setCapsuleData() {
        if (reflection != null) {
            reflectionEditText.setText(reflection.getContent());
        }

        capsuleTitleTextView.setText(capsule.getTitle());
        openedDateTextView.setText(capsule.getOpeningDate());
    }

    private void setButtons() {
        submitReflectionBtn.setOnClickListener(v -> {
            String reflection = Utils.getString(reflectionEditText);
            if (reflection.isEmpty()) {
                Utils.toast(ViewReflectionActivity.this, "Your reflection is empty! Please type something to submit.");
            } else {
                DatabaseHelper.addReflection(new Reflection(capsule.getId(), reflection));
                Utils.longToast(ViewReflectionActivity.this, "Reflection has been successfully set!");
            }
        });
    }
}