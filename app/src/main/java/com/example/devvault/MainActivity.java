package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.devvault.data.Capsule;
import com.example.devvault.helpers.DatabaseHelper;
import com.example.devvault.helpers.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Test
        try {
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
}