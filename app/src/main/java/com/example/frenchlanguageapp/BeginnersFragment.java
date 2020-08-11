package com.example.frenchlanguageapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BeginnersFragment extends Fragment implements View.OnClickListener {
    NavController navController;
    CardView numbers,words;
    TextView quiz;
    public BeginnersFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        numbers = view.findViewById(R.id.numbersCard);
        words = view.findViewById(R.id.wordsCard);
        quiz = view.findViewById(R.id.text_action_bottom1);
        numbers.setOnClickListener(this);
        words.setOnClickListener(this);
        quiz.setOnClickListener(this);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beginners, container, false);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.numbersCard){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.numbersFragment);
        }
        else if(id == R.id.wordsCard){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.wordsFragment);
        }
        else if(id == R.id.text_action_bottom1){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.beginnerQuizFragment);
        }
    }
}