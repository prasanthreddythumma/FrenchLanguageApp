package com.example.frenchlanguageapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MonthsFragment extends Fragment {
    TextView m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12;
    TextView m1E,m2E,m3E,m4E,m5E,m6E,m7E,m8E,m9E,m10E,m11E,m12E;
    DatabaseReference databaseReference;
    public MonthsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m1 = view.findViewById(R.id.m1F);
        m2 = view.findViewById(R.id.m2F);
        m3 = view.findViewById(R.id.m3F);
        m4 = view.findViewById(R.id.m4F);
        m5 = view.findViewById(R.id.m5F);
        m6 = view.findViewById(R.id.m6F);
        m7 = view.findViewById(R.id.m7F);
        m8 = view.findViewById(R.id.m8F);
        m9 = view.findViewById(R.id.m9F);
        m10 = view.findViewById(R.id.m10F);
        m11 = view.findViewById(R.id.m11F);
        m12 = view.findViewById(R.id.m12F);

        m1E = view.findViewById(R.id.m1E);
        m2E = view.findViewById(R.id.m2E);
        m3E = view.findViewById(R.id.m3E);
        m4E = view.findViewById(R.id.m4E);
        m5E = view.findViewById(R.id.m5E);
        m6E = view.findViewById(R.id.m6E);
        m7E = view.findViewById(R.id.m7E);
        m8E = view.findViewById(R.id.m8E);
        m9E = view.findViewById(R.id.m9E);
        m10E = view.findViewById(R.id.m10E);
        m11E = view.findViewById(R.id.m11E);
        m12E = view.findViewById(R.id.m12E);


        getMonths();

    }

    private void getMonths() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Months");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final Months months = snapshot.getValue(Months.class);
                m1.setText(months.getJanuary());
                m2.setText(months.getFebruary());
                m3.setText(months.getMarch());
                m4.setText(months.getApril());
                m5.setText(months.getMay());
                m6.setText(months.getJune());
                m7.setText(months.getJuly());
                m8.setText(months.getAugust());
                m9.setText(months.getSeptember());
                m10.setText(months.getOctober());
                m11.setText(months.getNovember());
                m12.setText(months.getDecember());

                m1E.setText("January");
                m2E.setText("February");
                m3E.setText("March");
                m4E.setText("April");
                m5E.setText("May");
                m6E.setText("June");
                m7E.setText("July");
                m8E.setText("August");
                m9E.setText("September");
                m10E.setText("October");
                m11E.setText("November");
                m12E.setText("December");

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
        return inflater.inflate(R.layout.fragment_months, container, false);
    }
}