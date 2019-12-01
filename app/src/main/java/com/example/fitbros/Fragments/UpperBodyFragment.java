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
public class UpperBodyFragment extends Fragment {

    Button bicepButton;
    Button tricepButton;
    Button backButton;


    public UpperBodyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_upper_body, container, false);

        bicepButton = view.findViewById(R.id.buttonBicep);
        tricepButton = view.findViewById(R.id.buttonTricep);
        backButton = view.findViewById(R.id.buttonBack);

        bicepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_bicep01), R.drawable.workout_bicep_01, getResources().getString(R.string.workout_description_bicep01), getResources().getString(R.string.workout_length_bicep01)));
                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_bicep02), R.drawable.workout_bicep_02, getResources().getString(R.string.workout_description_bicep02), getResources().getString(R.string.workout_length_bicep02)));
                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_bicep03), R.drawable.workout_bicep_03, getResources().getString(R.string.workout_description_bicep03), getResources().getString(R.string.workout_length_bicep03)));

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        tricepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_tricep01), R.drawable.workout_tricep_01, getResources().getString(R.string.workout_description_tricep01), getResources().getString(R.string.workout_length_tricep01)));
                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_tricep02), R.drawable.workout_tricep_02, getResources().getString(R.string.workout_description_tricep02), getResources().getString(R.string.workout_length_tricep02)));
                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_tricep03), R.drawable.workout_tricep_03, getResources().getString(R.string.workout_description_tricep03), getResources().getString(R.string.workout_length_tricep03)));

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_back01), R.drawable.workout_back_01, getResources().getString(R.string.workout_description_back01), getResources().getString(R.string.workout_length_back01)));
                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_back02), R.drawable.workout_back_02, getResources().getString(R.string.workout_description_back02), getResources().getString(R.string.workout_length_back02)));
                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_back03), R.drawable.workout_back_03, getResources().getString(R.string.workout_description_back03), getResources().getString(R.string.workout_length_back03)));

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        return view;
    }

}
