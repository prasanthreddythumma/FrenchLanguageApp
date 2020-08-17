package com.example.frenchlanguageapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileEditFragment extends Fragment implements View.OnClickListener{
    EditText email, phoneNo,firstName,lastName;
    Button save;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference reference;
    NavController navController;
    Users users;
    public ProfileEditFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstName = view.findViewById(R.id.newFirstName);
        lastName = view.findViewById(R.id.editLastName);
        email = view.findViewById(R.id.newEmail);
        phoneNo = view.findViewById(R.id.newPhone);
        save = view.findViewById(R.id.btnSave);
        users = new Users();
        reference = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        save.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_edit, container, false);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btnSave){
            if(!firstName.getText().toString().trim().matches("")){
                users.setFirstName(firstName.getText().toString().trim());
            }
            if(!lastName.getText().toString().trim().matches("")){
                users.setLastName(lastName.getText().toString().trim());
            }
            if(!email.getText().toString().trim().matches("")){
                users.setEMail(email.getText().toString().trim());
                auth.getCurrentUser().updateEmail(email.getText().toString().trim());
            }
            if(!phoneNo.getText().toString().trim().matches("")){
                users.setPhoneNumber(phoneNo.getText().toString().trim());
            }

            reference.child("User").child(user.getUid()).setValue(users);

            navController= Navigation.findNavController(getActivity(),R.id.nav_profile_fragment);
            navController.navigate(R.id.viewFragment);
        }
    }
}