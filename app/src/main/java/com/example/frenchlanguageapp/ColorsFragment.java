package com.example.frenchlanguageapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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

public class ColorsFragment extends Fragment {
    TextView c1,c2,c3,c4,c5,c6,c7;
    TextView c1E,c2E,c3E,c4E,c5E,c6E,c7E;
    CardView cc1,cc2,cc3,cc4,cc5,cc6,cc7;

    DatabaseReference databaseReference;
    public ColorsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c1 = view.findViewById(R.id.c1F);
        c2 = view.findViewById(R.id.c2F);
        c3 = view.findViewById(R.id.c3F);
        c4 = view.findViewById(R.id.c4F);
        c5 = view.findViewById(R.id.c5F);
        c6 = view.findViewById(R.id.c6F);
        c7 = view.findViewById(R.id.c7F);

        c1E = view.findViewById(R.id.c1E);
        c2E = view.findViewById(R.id.c2E);
        c3E = view.findViewById(R.id.c3E);
        c4E = view.findViewById(R.id.c4E);
        c5E = view.findViewById(R.id.c5E);
        c6E = view.findViewById(R.id.c6E);
        c7E = view.findViewById(R.id.c7E);

        cc1 = view.findViewById(R.id.c1);
        cc2 = view.findViewById(R.id.c2);
        cc3 = view.findViewById(R.id.c3);
        cc4 = view.findViewById(R.id.c4);
        cc5 = view.findViewById(R.id.c5);
        cc6 = view.findViewById(R.id.c6);
        cc7 = view.findViewById(R.id.c7);


        getColors();


    }

    void getColors(){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Colors");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final Colors colors = snapshot.getValue(Colors.class);
                c1.setText(colors.getRed());
                c2.setText(colors.getOrange());
                c3.setText(colors.getYellow());
                c4.setText(colors.getGreen());
                c5.setText(colors.getBlue());
                c6.setText(colors.getIndigo());
                c7.setText(colors.getViolet());


                c1E.setText("Red");
                c2E.setText("Orange");
                c3E.setText("Yellow");
                c4E.setText("Green");
                c5E.setText("Blue");
                c6E.setText("Indigo");
                c7E.setText("Violet");

                cc1.setBackgroundColor(Color.rgb(255,0,0));
                cc2.setBackgroundColor(Color.rgb(255,127,0));
                cc3.setBackgroundColor(Color.rgb(255,255,0));
                cc4.setBackgroundColor(Color.rgb(0,255,0));
                cc5.setBackgroundColor(Color.rgb(0,0,255));
                cc6.setBackgroundColor(Color.rgb(75,0,130));
                cc7.setBackgroundColor(Color.rgb(148,0,211));


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
        return inflater.inflate(R.layout.fragment_colors, container, false);
    }
}