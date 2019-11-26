package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fitbros.Constants;
import com.example.fitbros.JavaBeans.Workout;
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

        treadmillButton = view.findViewById(R.id.buttonMachine);
        cycleButton = view.findViewById(R.id.buttonManual);
        jumpRopeButton = view.findViewById(R.id.buttonRope);

        treadmillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_machine01), R.drawable.workout_machine_treadmill, getResources().getString(R.string.workout_description_machine01), getResources().getString(R.string.workout_length_machine01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        cycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_manual01), R.drawable.workout_manual_cycle, getResources().getString(R.string.workout_description_manual01), getResources().getString(R.string.workout_length_manual01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        jumpRopeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_ropes01), R.drawable.workout_rope_climb, getResources().getString(R.string.workout_description_ropes01), getResources().getString(R.string.workout_length_ropes01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        return view;
    }

}
