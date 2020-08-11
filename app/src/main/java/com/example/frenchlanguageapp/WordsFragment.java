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

public class WordsFragment extends Fragment {
    TextView girl,boy,woman,man,love,please,time,day,world,strong;
    TextView girlE,boyE,womanE,manE,loveE,pleaseE,timeE,dayE,worldE,strongE;
    DatabaseReference reference;
    public WordsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        girl = view.findViewById(R.id.girlF);
        boy = view.findViewById(R.id.boyF);
        woman = view.findViewById(R.id.womanF);
        man = view.findViewById(R.id.manF);
        love = view.findViewById(R.id.loveF);
        please = view.findViewById(R.id.pleaseF);
        time = view.findViewById(R.id.timeF);
        day = view.findViewById(R.id.dayF);
        world = view.findViewById(R.id.worldF);
        strong = view.findViewById(R.id.strongF);

        girlE = view.findViewById(R.id.girlE);
        boyE = view.findViewById(R.id.boyE);
        womanE = view.findViewById(R.id.womanE);
        manE = view.findViewById(R.id.manE);
        loveE = view.findViewById(R.id.loveE);
        pleaseE = view.findViewById(R.id.pleaseE);
        timeE = view.findViewById(R.id.timeE);
        dayE = view.findViewById(R.id.dayE);
        worldE = view.findViewById(R.id.worldE);
        strongE = view.findViewById(R.id.strongE);

        getWords();
    }

    private void getWords() {
        reference = FirebaseDatabase.getInstance().getReference().child("Words");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final Words words = snapshot.getValue(Words.class);

                girl.setText(words.getGirl());
                girlE.setText("Girl");

                boy.setText(words.getBoy());
                boyE.setText("Boy");

                woman.setText(words.getWoman());
                womanE.setText("Woman");

                man.setText(words.getMan());
                manE.setText("Man");

                love.setText(words.getLove());
                loveE.setText("Love");

                please.setText(words.getPlease());
                pleaseE.setText("Please");

                time.setText(words.getTime());
                timeE.setText("Time");

                day.setText(words.getDay());
                dayE.setText("Day");

                world.setText(words.getWorld());
                worldE.setText("World");

                strong.setText(words.getStrong());
                strongE.setText("Strong");

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
        return inflater.inflate(R.layout.fragment_words, container, false);
    }
}