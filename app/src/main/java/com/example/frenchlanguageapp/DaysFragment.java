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


public class DaysFragment extends Fragment {
    TextView d1,d2,d3,d4,d5,d6,d7;
    TextView d1E,d2E,d3E,d4E,d5E,d6E,d7E;
    DatabaseReference databaseReference;

    public DaysFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        d1 = view.findViewById(R.id.d1F);
        d2 = view.findViewById(R.id.d2F);
        d3 = view.findViewById(R.id.d3F);
        d4 = view.findViewById(R.id.d4F);
        d5 = view.findViewById(R.id.d5F);
        d6 = view.findViewById(R.id.d6F);
        d7 = view.findViewById(R.id.d7F);

        d1E = view.findViewById(R.id.d1E);
        d2E = view.findViewById(R.id.d2E);
        d3E = view.findViewById(R.id.d3E);
        d4E = view.findViewById(R.id.d4E);
        d5E = view.findViewById(R.id.d5E);
        d6E = view.findViewById(R.id.d6E);
        d7E = view.findViewById(R.id.d7E);

        getDays();

    }

    void getDays(){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Days");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final Days days = snapshot.getValue(Days.class);
                d1.setText(days.getSunday());
                d2.setText(days.getMonday());
                d3.setText(days.getTuesday());
                d4.setText(days.getWednesday());
                d5.setText(days.getThursday());
                d6.setText(days.getFriday());
                d7.setText(days.getSaturday());


                d1E.setText("Sunday");
                d2E.setText("Monday");
                d3E.setText("Tuesday");
                d4E.setText("Wednesday");
                d5E.setText("Thursday");
                d6E.setText("Friday");
                d7E.setText("Saturday");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_days, container, false);
    }
}