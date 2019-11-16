package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fitbros.Constants;
import com.example.fitbros.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardioFragment extends Fragment {

    Button treadmillButton;
    Button cycleButton;
    Button jumpRopeButton;

    public CardioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cardio, container, false);

        treadmillButton = view.findViewById(R.id.buttonTreadmill);
        cycleButton = view.findViewById(R.id.buttonCycle);
        jumpRopeButton = view.findViewById(R.id.buttonJump);

        treadmillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        cycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        jumpRopeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        return view;
    }

}
