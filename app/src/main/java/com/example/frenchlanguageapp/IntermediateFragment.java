package com.example.frenchlanguageapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class IntermediateFragment extends Fragment implements View.OnClickListener {
    NavController navController;
    CardView months,colors,days;
    TextView quiz;
    TextView daysText, monthsText,colorsText,search;
    public IntermediateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        months = view.findViewById(R.id.monthsCard);
        colors = view.findViewById(R.id.colorsCard);
        days = view.findViewById(R.id.daysCard);
        daysText = view.findViewById(R.id.daysCardText);
        monthsText = view.findViewById(R.id.monthsCardText);
        colorsText = view.findViewById(R.id.colorsCardText);
        search = view.findViewById(R.id.searchIn);
        quiz = view.findViewById(R.id.text_action_bottom1);
        months.setOnClickListener(this);
        colors.setOnClickListener(this);
        days.setOnClickListener(this);
        quiz.setOnClickListener(this);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchInt(editable.toString());
            }
        });
    }

    private void searchInt(String s) {
        String day = daysText.getText().toString().trim().toLowerCase();
        String month = monthsText.getText().toString().trim().toLowerCase();
        String color = colorsText.getText().toString().trim().toLowerCase();
        if (s.isEmpty()) {
            days.setVisibility(View.VISIBLE);
            months.setVisibility(View.VISIBLE);
            colors.setVisibility(View.VISIBLE);
        } else if (day.contains(s.toLowerCase())) {
            days.setVisibility(View.VISIBLE);
            months.setVisibility(View.GONE);
            colors.setVisibility(View.GONE);
        } else if (month.contains(s.toLowerCase())) {
            days.setVisibility(View.GONE);
            months.setVisibility(View.VISIBLE);
            colors.setVisibility(View.GONE);
        } else if (color.contains(s.toLowerCase())) {
            days.setVisibility(View.GONE);
            months.setVisibility(View.GONE);
            colors.setVisibility(View.VISIBLE);
        } else {
            days.setVisibility(View.GONE);
            months.setVisibility(View.GONE);
            colors.setVisibility(View.GONE);
        }
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