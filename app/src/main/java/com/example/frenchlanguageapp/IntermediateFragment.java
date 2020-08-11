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
import android.widget.TextView;

public class IntermediateFragment extends Fragment implements View.OnClickListener {
    NavController navController;
    CardView months,colors,days;
    TextView quiz;
    public IntermediateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        months = view.findViewById(R.id.monthsCard);
        colors = view.findViewById(R.id.colorsCard);
        days = view.findViewById(R.id.daysCard);

        quiz = view.findViewById(R.id.text_action_bottom1);
        months.setOnClickListener(this);
        colors.setOnClickListener(this);
        days.setOnClickListener(this);
        quiz.setOnClickListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.monthsCard){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.monthsFragment);
        }
        else if(id == R.id.daysCard){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.daysFragment);
        }
        else if(id == R.id.colorsCard){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.colorsFragment);
        }
        else if(id == R.id.text_action_bottom1){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.intermediateQuizFragment);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intermediate, container, false);
    }
}