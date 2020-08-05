package com.example.frenchlanguageapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth auth;
    private FirebaseUser curUser;
    public NavController navController;
    private EditText edt_email,edt_pass;
    private FirebaseFirestore db;
    private int a;
    private static final String TAG="LoginFragment";
    public LoginFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_login = view.findViewById(R.id.btn_login);
        TextView txt_reg = view.findViewById(R.id.txt_loginRegister);
        edt_email=view.findViewById(R.id.edit_loginEmail);
        edt_pass=view.findViewById(R.id.edit_loginPass);
        txt_reg.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id=v.getId();
        String email = edt_email.getText().toString();
        String pass = edt_pass.getText().toString();
        if(id==R.id.btn_login){
            if (TextUtils.isEmpty(email)) {
                edt_email.setError("Email cannot be blank!");
                edt_email.requestFocus();
            }else if(TextUtils.isEmpty(pass)){
                edt_pass.setError("Password cannot be blank!");
                edt_pass.requestFocus();
            }else{
                loginUser(email, pass);
            }
        }else if(id==R.id.txt_loginRegister) {
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.registerFragment);
        }
    }

    private void readData(final FirestoreCallback firestoreCallback){
        DocumentReference docref=db.collection("Users").document(curUser.getUid());
        docref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    documentSnapshot.getData();
                    a=(int)(long)documentSnapshot.get("Level");
                    Log.d("readDatabase","a="+ a);
                    firestoreCallback.onClickback(documentSnapshot);
                }else{
                    Log.d("Else=","Doc not exist");
                }
            }
        });
    }

    private interface FirestoreCallback{
        void onClickback(DocumentSnapshot documentSnapshot);
    }


    private void loginUser(String email, String pass){
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    curUser=auth.getCurrentUser();
                    readData(new FirestoreCallback() {
                        @Override
                        public void onClickback(DocumentSnapshot documentSnapshot) {
                            if(a>0&&a<4){
                                Toast.makeText(getActivity().getApplicationContext(),"Login Success!",Toast.LENGTH_LONG).show();
                                if(a ==1){
                                    Toast.makeText(getActivity().getApplicationContext(),"Beginners!",Toast.LENGTH_LONG).show();
                                }
                                else if(a==2){
                                    Toast.makeText(getActivity().getApplicationContext(),"Intermediate!",Toast.LENGTH_LONG).show();
                                }
                                else if(a == 3){
                                    Toast.makeText(getActivity().getApplicationContext(),"Advanced!",Toast.LENGTH_LONG).show();
                                }
                            }else{
                                navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                                Toast.makeText(getActivity().getApplicationContext(),"First select the level",Toast.LENGTH_LONG).show();
                                navController.navigate(R.id.selectFragment);
                            }
                        }
                    });
                }else{
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        Toast.makeText(getActivity().getApplicationContext(),"Email not exist!",Toast.LENGTH_LONG).show();
                        edt_email.getText().clear();
                        edt_pass.getText().clear();
                        edt_email.setError("Email not exist!");
                        edt_email.requestFocus();
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        Toast.makeText(getActivity().getApplicationContext(),"Wrong Password!",Toast.LENGTH_LONG).show();
                        edt_pass.getText().clear();
                        edt_pass.setError("Wrong Password!");
                        edt_pass.requestFocus();
                    }catch (Exception e ){
                        Toast.makeText(getActivity().getApplicationContext(),"Login Failed!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart Called!! "+a);
        // Log.d("a=","value is"+a);
        curUser=auth.getCurrentUser();
        if(curUser!=null){
            Toast.makeText(getActivity().getApplicationContext(),"User Already Login",Toast.LENGTH_LONG).show();
            if(a>0&&a<4){

                if(a ==1){
                    Toast.makeText(getActivity().getApplicationContext(),"Beginners!",Toast.LENGTH_LONG).show();
                }
                else if(a==2){
                    Toast.makeText(getActivity().getApplicationContext(),"Intermediate!",Toast.LENGTH_LONG).show();
                }
                else if(a == 3){
                    Toast.makeText(getActivity().getApplicationContext(),"Advanced!",Toast.LENGTH_LONG).show();
                }
            }else{
                navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                Toast.makeText(getActivity().getApplicationContext(),"First select the level",Toast.LENGTH_LONG).show();
                navController.navigate(R.id.selectFragment);
            }

        }
    }
}