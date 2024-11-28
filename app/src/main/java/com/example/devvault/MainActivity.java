package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.devvault.data.Capsule;
import com.example.devvault.helpers.DatabaseHelper;
import com.example.devvault.helpers.Utils;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private RecyclerView capsuleRecyclerView;
    private Button addCapsuleBtn;
    private ImageView profileImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Test
        try {
            searchView = findViewById(R.id.searchView);
            capsuleRecyclerView = findViewById(R.id.capsuleRecyclerView);
            addCapsuleBtn = findViewById(R.id.addCapsuleBtn);
            profileImageView = findViewById(R.id.profileImageView);
            DatabaseHelper.initialize(this);
            test();
        } catch (Exception err) {
            Utils.toast(this, err.getMessage());
        }
    }

    private void test() {
        // String title, String type, String description, String tags, String openingDate
        DatabaseHelper.addCapsule(new Capsule("Acquired Python", "Skill", "Today I learned Python programming", "#NewSkillLearned", "28/11/2019"));
        DatabaseHelper.addCapsule(new Capsule("Acquired Java", "Skill", "Today I learned Java programming", "#ILoveJava", "10/12/2022"));

        System.out.println("Capsules in the database");
        for (Capsule capsule : DatabaseHelper.getCapsules()) {
            System.out.println(capsule.toString());
        }

        DatabaseHelper.resetDatabase();
    }

    private void setButtons() {
        addCapsuleBtn.setOnClickListener(v -> {

        });

        profileImageView.setOnClickListener(v -> {

        });
    }
}