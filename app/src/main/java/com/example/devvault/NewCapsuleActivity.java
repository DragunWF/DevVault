package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.devvault.data.Capsule;
import com.example.devvault.helpers.DatabaseHelper;
import com.example.devvault.helpers.SessionData;
import com.example.devvault.helpers.Utils;

import java.util.HashMap;

public class NewCapsuleActivity extends AppCompatActivity {
    private ImageView backImageView;
    private EditText titleEditText,  descriptionEditText, codeEditText, tagsEditText,
                     dayEditText, monthEditText, yearEditText;
    private Button saveCapsuleBtn;
    private Spinner typeSpinner;

    private HashMap<Integer, Integer> monthDayLimits = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_capsule);
        try {
            DatabaseHelper.initialize(this);
            backImageView = findViewById(R.id.backImageView);
            titleEditText = findViewById(R.id.titleEditText);
            typeSpinner = findViewById(R.id.typeEditText);
            descriptionEditText = findViewById(R.id.descriptionEditText);
            codeEditText = findViewById(R.id.snippetEditText);
            tagsEditText = findViewById(R.id.tagsEditText);
            dayEditText = findViewById(R.id.dayEditText);
            monthEditText = findViewById(R.id.monthEditText);
            yearEditText = findViewById(R.id.yearEditText);
            saveCapsuleBtn = findViewById(R.id.saveCapsuleBtn);

            monthDayLimits.put(1, 31);
            monthDayLimits.put(2, 28);
            monthDayLimits.put(3, 31);
            monthDayLimits.put(4, 30);
            monthDayLimits.put(5, 31);
            monthDayLimits.put(6, 30);
            monthDayLimits.put(7, 31);
            monthDayLimits.put(8, 31);
            monthDayLimits.put(9, 30);
            monthDayLimits.put(10, 31);
            monthDayLimits.put(11, 30);
            monthDayLimits.put(12, 31);

            setButtons();
            setSpinner();
        } catch (Exception err) {
            Utils.longToast(this, err.getMessage());
        }
    }

    private void setSpinner() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, SessionData.getTypes()
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(spinnerAdapter);

        typeSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void setButtons() {
        backImageView.setOnClickListener(v -> finish());
        saveCapsuleBtn.setOnClickListener(v -> {
            String title = Utils.getString(titleEditText);
            String description = Utils.getString(descriptionEditText);
            String codeSnippet = Utils.getString(codeEditText);
            String type = "milestone"; // temporary
            String tags = Utils.getString(tagsEditText);
            String dayStr = Utils.getString(dayEditText);
            String monthStr = Utils.getString(monthEditText);
            String yearStr = Utils.getString(yearEditText);

            // Field Validation
            String[] fields = { title, type, description, codeSnippet, tags, dayStr, monthStr, yearStr };
            for (String field : fields) {
                if (field.isEmpty()) {
                    Utils.longToast(NewCapsuleActivity.this, "Please do not leave any of the fields empty!");
                    return;
                }
            }
            if (title.length() > 14) {
                Utils.toast(NewCapsuleActivity.this, "Title cannot be more than 14 characters!");
                return;
            }

            try {
                int day = Integer.parseInt(dayStr);
                int month = Integer.parseInt(monthStr);
                int year = Integer.parseInt(yearStr);

                // Accounts for leap year in February
                monthDayLimits.put(2, Utils.isLeapYear(year) ? 29 : 28);

                if (month <= 0 || month > 12) {
                    Utils.toast(NewCapsuleActivity.this, "Invalid month!");
                } else if (year <= 0) {
                    Utils.toast(NewCapsuleActivity.this, "Invalid Year!");
                } else if (day <= 0 || day > monthDayLimits.get(month)) {
                    Utils.toast(NewCapsuleActivity.this, "Invalid day!");
                } else {
                    String date = String.format("%s/%s/%s", day, month, year);
                    Capsule capsule = new Capsule(title, type, description, codeSnippet, tags, date);
                    DatabaseHelper.addCapsule(capsule);
                    Utils.longToast(NewCapsuleActivity.this, "Your capsule has been successfully submitted!");
                    resetEditText();
                }
            } catch (Exception err) {
                Utils.toast(NewCapsuleActivity.this, "Invalid Date!");
            }
        });
    }

    private void resetEditText() {
        titleEditText.setText("");
        descriptionEditText.setText("");
        codeEditText.setText("");
        tagsEditText.setText("");
        dayEditText.setText("");
        monthEditText.setText("");
        yearEditText.setText("");
        saveCapsuleBtn.setText("");
    }
}