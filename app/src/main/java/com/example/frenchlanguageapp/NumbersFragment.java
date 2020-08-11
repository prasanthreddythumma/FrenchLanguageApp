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

public class NumbersFragment extends Fragment {
    TextView one,two,three,four,five,six,seven,eight,nine,ten;
    TextView oneE,twoE,threeE,fourE,fiveE,sixE,sevenE,eightE,nineE,tenE;
    DatabaseReference databaseReference;
    NavController navController;
    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        one = view.findViewById(R.id.oneF);
        two = view.findViewById(R.id.twoF);
        three = view.findViewById(R.id.threeF);
        four = view.findViewById(R.id.fourF);
        five = view.findViewById(R.id.fiveF);
        six = view.findViewById(R.id.sixF);
        seven = view.findViewById(R.id.sevenF);
        eight = view.findViewById(R.id.eightF);
        nine = view.findViewById(R.id.nineF);
        ten = view.findViewById(R.id.tenF);

        oneE = view.findViewById(R.id.oneE);
        twoE = view.findViewById(R.id.twoE);
        threeE = view.findViewById(R.id.threeE);
        fourE = view.findViewById(R.id.fourE);
        fiveE = view.findViewById(R.id.fiveE);
        sixE = view.findViewById(R.id.sixE);
        sevenE = view.findViewById(R.id.sevenE);
        eightE = view.findViewById(R.id.eightE);
        nineE = view.findViewById(R.id.nineE);
        tenE = view.findViewById(R.id.tenE);


        getNumbers();

    }

    private void getNumbers() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Numbers");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final Numbers numbers = snapshot.getValue(Numbers.class);
                one.setText(numbers.getOne());
                two.setText(numbers.getTwo());
                three.setText(numbers.getThree());
                four.setText(numbers.getFour());
                five.setText(numbers.getFive());
                six.setText(numbers.getSix());
                seven.setText(numbers.getSeven());
                eight.setText(numbers.getEight());
                nine.setText(numbers.getNine());
                ten.setText(numbers.getTen());

                oneE.setText("One");
                twoE.setText("Two");
                threeE.setText("Three");
                fourE.setText("Four");
                fiveE.setText("Five");
                sixE.setText("Six");
                sevenE.setText("Seven");
                eightE.setText("Eight");
                nineE.setText("Nine");
                tenE.setText("Ten");

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
        return inflater.inflate(R.layout.fragment_numbers, container, false);
    }
}