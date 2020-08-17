package com.example.frenchlanguageapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PhrasesFragment extends Fragment {

    TextView P1,P2,P3,P4,P5,P6,P7,P8,P9,P10;
    DatabaseReference databaseReference;

    public PhrasesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        P1 = view.findViewById(R.id.pF1);
        P2 = view.findViewById(R.id.pF2);
        P3 = view.findViewById(R.id.pF3);
        P4 = view.findViewById(R.id.pF4);
        P5 = view.findViewById(R.id.pF5);
        P6 = view.findViewById(R.id.pF6);
        P7 = view.findViewById(R.id.pF7);
        P8 = view.findViewById(R.id.pF8);
        P9 = view.findViewById(R.id.pF9);
        P10 = view.findViewById(R.id.pF10);

        getPhrases();
    }

    private void getPhrases() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Phrases");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final Phrases phrases = snapshot.getValue(Phrases.class);
                P1.setText(phrases.getP1());
                P2.setText(phrases.getP2());
                P3.setText(phrases.getP3());
                P4.setText(phrases.getP4());
                P5.setText(phrases.getP5());
                P6.setText(phrases.getP6());
                P7.setText(phrases.getP7());
                P8.setText(phrases.getP8());
                P9.setText(phrases.getP9());
                P10.setText(phrases.getP10());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phrases, container, false);
    }
}