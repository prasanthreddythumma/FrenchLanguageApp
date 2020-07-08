package com.example.frenchlanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AssessmentActivity extends AppCompatActivity {
    Button submit;
    EditText answerTwo, answerThree;
    RadioGroup questionOneGroup;
    RadioButton answerOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);


        submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = 0;
                if(AnswerOne())
                    score++;
                if(AnswerTwo())
                    score++;
                if(AnswerThree())
                    score++;

                if(score <= 1){
                    Toast.makeText(AssessmentActivity.this, "Beginner", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AssessmentActivity.this,BeginnerActivity.class ));
                }
                else if(score == 2){
                    Toast.makeText(AssessmentActivity.this, "Intermediate", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AssessmentActivity.this,IntermediateActivity.class ));
                }
                else if(score >= 3){
                    Toast.makeText(AssessmentActivity.this, "Advanced", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AssessmentActivity.this,AdvancedActivity.class ));
                }
            }
        });
        //AnswerOne();
    }

    public Boolean AnswerOne(){
        boolean answer = false;
        questionOneGroup = findViewById(R.id.rgQuestion2);

        int selected = questionOneGroup.getCheckedRadioButtonId();
        answerOne = findViewById(selected);

        String ansOne = answerOne.getText().toString().trim();

        if(ansOne.equals("un garçon")){
            answer = true;
        }
        return answer;
    }

    public Boolean AnswerTwo(){
        boolean answer = false;

        answerTwo = findViewById(R.id.answerTwo);

        String ansTwo = answerTwo.getText().toString().trim();

        if(ansTwo.equals("mille quatre cent quarante-cinq")||ansTwo.equals("mille quatre cent quarante cinq")){
            answer = true;
        }
        return answer;
    }

    public Boolean AnswerThree(){
        boolean answer = false;

        answerThree = findViewById(R.id.answerThree);

        String ansThree = answerThree.getText().toString().trim();

        if(ansThree.equals("La langue officielle du Québec est le français")||ansThree.equals("français")){
            answer = true;
        }
        return answer;
    }
}