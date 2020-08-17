package com.example.frenchlanguageapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


public class SelectFragment extends Fragment implements View.OnClickListener {
    private FirebaseAuth auth;
    private FirebaseUser curUser;
    public NavController navController;
    private FirebaseFirestore db;
    private int a;
    RadioGroup radioGroup;
    RadioButton radioButton;
    FloatingActionButton profile;
    int rb_id;

    public SelectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_Select = view.findViewById(R.id.btn_lvl);
        TextView txt_assess = view.findViewById(R.id.txt_assess);
        radioGroup = view.findViewById(R.id.selectLevel);
        profile= view.findViewById(R.id.btn_profile);
        profile.setOnClickListener(this);
        txt_assess.setOnClickListener(this);
        btn_Select.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        rb_id =radioGroup.getCheckedRadioButtonId();
        radioButton = view.findViewById(rb_id);

        if (id == R.id.btn_lvl) {
            if(rb_id == R.id.lvl_1){
                navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                navController.navigate(R.id.beginnersFragment);
            }
            else if(rb_id == R.id.lvl_2){
                navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                navController.navigate(R.id.intermediateFragment);
            }
            else if(rb_id == R.id.lvl_3){
                navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                navController.navigate(R.id.advancedFragment);
            }
        }
        else if(id == R.id.txt_assess){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.assessFragment);
        }
        else if(id == R.id.btn_profile){
            startActivity(new Intent(getActivity(),ProfileActivity.class));

        }
    }
}