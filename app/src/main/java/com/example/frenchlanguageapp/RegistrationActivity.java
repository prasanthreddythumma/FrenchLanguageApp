package com.example.frenchlanguageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    TextView firstName, lastName, password, email, phoneNumber;
    Button btnLogin, btnRegistration;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = (TextView)findViewById(R.id.firstName);
        lastName = (TextView)findViewById(R.id.lastName);
        password = (TextView)findViewById(R.id.password);
        email = (TextView)findViewById(R.id.email);
        phoneNumber = (TextView)findViewById(R.id.phoneNumber);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistration = (Button) findViewById(R.id.btnRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            }
        });

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(validate()){
                   String userEmail = email.getText().toString().trim();
                   String userPwd = password.getText().toString().trim();

                   firebaseAuth.createUserWithEmailAndPassword(userEmail,userPwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               Toast.makeText(RegistrationActivity.this, "Registration Success!!", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(RegistrationActivity.this,MainActivity.class ));
                           }
                           else {
                               Toast.makeText(RegistrationActivity.this, "Registration Failed!!", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
            }
        });


    }

    private Boolean validate(){
        Boolean val = false;
        String fn = firstName.getText().toString();
        String ln = lastName.getText().toString();
        String pwd = password.getText().toString();
        String em = email.getText().toString();
        String ph = phoneNumber.getText().toString();

        if(fn.isEmpty() || ln.isEmpty() || pwd.isEmpty() || em.isEmpty() || ph.isEmpty()){
            Toast.makeText(this,"Enter all details!!",Toast.LENGTH_SHORT).show();
            val = false;
        }
        else {

            val = true;
        }
        return val;
    }
}