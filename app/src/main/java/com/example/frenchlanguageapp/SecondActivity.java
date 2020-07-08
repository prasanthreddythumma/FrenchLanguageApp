package com.example.frenchlanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button level, assessment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        level = findViewById(R.id.levelChoice);
        assessment = findViewById(R.id.btnAssessment);

        level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,LevelSelectorActivity.class ));
            }
        });

        assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,AssessmentActivity.class ));
            }
        });
    }
}