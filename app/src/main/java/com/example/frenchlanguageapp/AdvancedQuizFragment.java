package com.example.frenchlanguageapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdvancedQuizFragment extends Fragment {
    TextView Question;
    RadioButton b1, b2, b3, b4;
    NavController navController;
    int total = 0;
    int count = 0;
    DatabaseReference reference;

    public AdvancedQuizFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Question = getActivity().findViewById(R.id.question1);
        b1 = view.findViewById(R.id.q1_o1);
        b2 = view.findViewById(R.id.q1_o2);
        b3 = view.findViewById(R.id.q1_o3);
        b4 = view.findViewById(R.id.q1_o4);

        total++;
        updateQuestion();
    }

    private void updateQuestion() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Advance_Quiz");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(total>snapshot.getChildrenCount()){
                    Toast.makeText(getActivity().getApplicationContext(),"Total correct: "+count,Toast.LENGTH_SHORT).show();
                    if(count >= (snapshot.getChildrenCount()-2)){
                        Toast.makeText(getActivity().getApplicationContext(),"Done with the Quizzes",Toast.LENGTH_SHORT).show();
                    }else {
                        navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                        navController.navigate(R.id.advancedFragment);
                    }
                }
                else {
                    reference = FirebaseDatabase.getInstance().getReference().child("Advance_Quiz").child(String.valueOf(total));
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            final Assessment assessment = datasnapshot.getValue(Assessment.class);
                            Question.setText(assessment.getQuestion());
                            b1.setText(assessment.getOption1());
                            b2.setText(assessment.getOption2());
                            b3.setText(assessment.getOption3());
                            b4.setText(assessment.getOption4());
                            final String answer = assessment.getAnswer();
                            b1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    total++;

                                    if(b1.getText().toString().equals(answer)){
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                count++;
                                                updateQuestion();
                                            }
                                        },1500);
                                    }

                                    else {
                                        Toast.makeText(getActivity().getApplicationContext(),"Right Answer: "+answer,Toast.LENGTH_SHORT).show();
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                updateQuestion();
                                            }
                                        },1500);

                                    }
                                    b1.setChecked(false);
                                }
                            });

                            b2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    total++;
                                    if(b2.getText().toString().equals(answer)){
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                count++;
                                                updateQuestion();
                                            }
                                        },1500);
                                    }

                                    else {
                                        Toast.makeText(getActivity().getApplicationContext(),"Right Answer: "+answer,Toast.LENGTH_SHORT).show();
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                updateQuestion();
                                            }
                                        },1500);

                                    }
                                    b2.setChecked(false);
                                }
                            });

                            b3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    total++;
                                    if(b3.getText().toString().equals(answer)){
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                count++;
                                                updateQuestion();
                                            }
                                        },1500);
                                    }

                                    else {
                                        Toast.makeText(getActivity().getApplicationContext(),"Right Answer: "+answer,Toast.LENGTH_SHORT).show();
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                updateQuestion();
                                            }
                                        },1500);

                                    }
                                    b3.setChecked(false);
                                }
                            });

                            b4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    total++;
                                    if(b4.getText().toString().equals(answer)){
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                count++;
                                                updateQuestion();
                                            }
                                        },1500);
                                    }

                                    else {
                                        Toast.makeText(getActivity().getApplicationContext(),"Right Answer: "+answer,Toast.LENGTH_SHORT).show();
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                updateQuestion();
                                            }
                                        },1500);

                                    }
                                    b4.setChecked(false);
                                }
                            });


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {


                        }
                    });

                }
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
        return inflater.inflate(R.layout.fragment_advanced_quiz, container, false);
    }
}