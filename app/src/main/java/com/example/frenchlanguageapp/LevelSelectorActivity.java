package com.example.frenchlanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelSelectorActivity extends AppCompatActivity {
    Button beginner, intermediate, advanced;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selector);

        beginner = findViewById(R.id.btnBeginner);
        intermediate = findViewById(R.id.btnIntermediate);
        advanced = findViewById(R.id.btnAdvanced);

        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LevelSelectorActivity.this,BeginnerActivity.class ));
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LevelSelectorActivity.this,IntermediateActivity.class ));
            }
        });

        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LevelSelectorActivity.this,AdvancedActivity.class ));
            }
        });
    }
}