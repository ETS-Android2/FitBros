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
    Button chestButton;


    public UpperBodyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_upper_body, container, false);

        bicepButton = view.findViewById(R.id.buttonBicep);
        tricepButton = view.findViewById(R.id.buttonTricep);
        chestButton = view.findViewById(R.id.buttonBack);

        bicepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Name", R.drawable.ic_home_grayblue_24dp, "Desc", "Reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        tricepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        chestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        return view;
    }

}
