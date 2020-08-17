package com.example.frenchlanguageapp;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class ProfileViewFragment extends Fragment implements View.OnClickListener{
    FirebaseAuth auth;
    DatabaseReference reference;
    TextView firstName, lastName, fullName, email, phoneNo;
    Button edit,logout;
    NavController navController;

    public ProfileViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        auth = FirebaseAuth.getInstance();
        firstName = view.findViewById(R.id.firstName);
        lastName =  view.findViewById(R.id.lastName);
        fullName =  view.findViewById(R.id.fullName);
        email =  view.findViewById(R.id.email);
        phoneNo =  view.findViewById(R.id.phone);
        edit =view.findViewById(R.id.btnEdit);
        logout = view.findViewById(R.id.btnLogout);
        reference = FirebaseDatabase.getInstance().getReference();


        reference.child("User").child(auth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users users = snapshot.getValue(Users.class);
                firstName.setText(users.getFirstName().toString());
                lastName.setText(users.getLastName().toString());
                email.setText(users.getEMail().toString());
                phoneNo.setText("+1 "+users.getPhoneNumber());
                fullName.setText(firstName.getText()+" "+lastName.getText());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        edit.setOnClickListener(this);
        logout.setOnClickListener(this);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_view, container, false);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btnEdit){
            navController= Navigation.findNavController(getActivity(),R.id.nav_profile_fragment);
            navController.navigate(R.id.editFragment);
        }
        else if(id == R.id.btnLogout){
            auth.signOut();
            startActivity(new Intent(getActivity(),MainActivity.class));

        }
    }
}