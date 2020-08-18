package com.example.frenchlanguageapp;

import android.icu.util.ValueIterator;
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

public class AdvancedFragment extends Fragment implements View.OnClickListener {
    NavController navController;
    CardView phrases;
    TextView quiz;
    TextView phrasesText,search;

    public AdvancedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        phrases = view.findViewById(R.id.phrasesCard);
        quiz = view.findViewById(R.id.text_action_bottom1);
        phrasesText = view.findViewById(R.id.phrasesCardText);
        search = view.findViewById(R.id.searchAd);
        phrases.setOnClickListener(this);
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
                searchAdv(editable.toString());
            }
        });
    }

    private void searchAdv(String s){
        String phrase = phrasesText.getText().toString().trim().toLowerCase();

        if(s.isEmpty() || phrase.contains(s.toLowerCase())){
            phrases.setVisibility(View.VISIBLE);
        }
        else {
            phrases.setVisibility(View.GONE);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advanced, container, false);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.phrasesCard){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.phrasesFragment);
        }
        else if(id == R.id.text_action_bottom1){
            navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.advancedQuizFragment);
        }
    }
}