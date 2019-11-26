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
public class LowerBodyFragment extends Fragment {

    Button quadButton;
    Button hamsButton;
    Button calvesButton;

    public LowerBodyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_lower_body, container, false);

        quadButton = view.findViewById(R.id.buttonQuad);
        hamsButton = view.findViewById(R.id.buttonHamstring);
        calvesButton = view.findViewById(R.id.buttonCalves);

        quadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_quads01), R.drawable.workout_lower_squat, getResources().getString(R.string.workout_description_quads01), getResources().getString(R.string.workout_length_quads01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        hamsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_hams01), R.drawable.workout_lower_box, getResources().getString(R.string.workout_description_hams01), getResources().getString(R.string.workout_length_hams01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        calvesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout(getResources().getString(R.string.workout_name_calves01), R.drawable.workout_lower_lunge, getResources().getString(R.string.workout_description_calves01), getResources().getString(R.string.workout_length_calves01)));

                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        return view;
    }

}
