package com.example.devvault;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.widget.SearchView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.devvault.data.Capsule;
import com.example.devvault.helpers.CapsuleAdapter;
import com.example.devvault.helpers.DatabaseHelper;
import com.example.devvault.helpers.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;

    private RecyclerView capsuleRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private Button addCapsuleBtn;
    private ImageView profileImageView;

    private List<Capsule> capsules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            searchView = findViewById(R.id.searchView);
            capsuleRecyclerView = findViewById(R.id.capsuleRecyclerView);
            addCapsuleBtn = findViewById(R.id.addCapsuleBtn);
            profileImageView = findViewById(R.id.profileImageView);

            DatabaseHelper.initialize(this);
            capsules = DatabaseHelper.getCapsules();

            DatabaseHelper.logCapsules();
            // test(); // uncomment when testing
            setRecyclerView();
            setSearchView();
            setButtons();
        } catch (Exception err) {
            System.out.println(err.getMessage());
            Utils.longToast(this, err.getMessage());
        }
    }

    private void setSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Capsule> results = new ArrayList<>();
                capsules.clear();
                query = query.toLowerCase();
                for (Capsule capsule : DatabaseHelper.getCapsules()) {
                    if (capsule.getTitle().toLowerCase().contains(query) ||
                        capsule.getDescription().toLowerCase().contains(query) ||
                            capsule.getTags().toLowerCase().contains(query) ||
                            capsule.getCodeSnippet().toLowerCase().contains(query)) {
                        results.add(capsule);
                    }
                }
                for (Capsule result : results) {
                    capsules.add(result);
                }
                adapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void setRecyclerView() {
        capsuleRecyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        capsuleRecyclerView.setLayoutManager(layoutManager);

        adapter = new CapsuleAdapter(capsules, this);
        capsuleRecyclerView.setAdapter(adapter);
    }

    private void setButtons() {
        addCapsuleBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NewCapsuleActivity.class));
        });

        profileImageView.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });
    }

    private void test() {
        // String title, String type, String description, String tags, String openingDate
        DatabaseHelper.addCapsule(new Capsule("Acquired Python", "Skill", "Today I learned Python programming", "print('hello')", "#NewSkillLearned", "28/11/2019", Utils.getDateToday()));
        DatabaseHelper.addCapsule(new Capsule("Acquired Java", "Skill", "Today I learned Java programming", "System.out.println(\"Hello World\"","#ILoveJava", "10/12/2022", Utils.getDateToday()));

        System.out.println("Capsules in the database");
        for (Capsule capsule : DatabaseHelper.getCapsules()) {
            System.out.println(capsule.toString());
        }

        DatabaseHelper.resetDatabase();
    }
}