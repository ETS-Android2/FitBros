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
public class CoreFragment extends Fragment {

    Button absButton;
    Button obliquesButton;
    Button glutesButton;

    public CoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_core, container, false);

        absButton = view.findViewById(R.id.buttonAbs);
        obliquesButton = view.findViewById(R.id.buttonObliques);
        glutesButton = view.findViewById(R.id.buttonGlutes);

        absButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_abd01), R.drawable.workout_core_abs_battle_ropes, getResources().getString(R.string.workout_description_abd01), getResources().getString(R.string.workout_length_abd01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_core_muscles_to_workoutFragment);
            }
        });

        obliquesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_obliques01), R.drawable.workout_core_obliques, getResources().getString(R.string.workout_description_obliques01), getResources().getString(R.string.workout_length_obliques01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_core_muscles_to_workoutFragment);
            }
        });

        glutesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_glutes01), R.drawable.workout_core_glutes, getResources().getString(R.string.workout_description_glutes01), getResources().getString(R.string.workout_length_glutes01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_core_muscles_to_workoutFragment);
            }
        });

        return view;
    }

}
