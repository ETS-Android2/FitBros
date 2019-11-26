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

                Constants.workouts.add(new Workout("EZ-Bar Curls", R.drawable.workout_bicep_01, "Hold bar using the handle grip helpers on the bar and attempt to curl up and down", "3 sets of 10 reps"));
                Constants.workouts.add(new Workout("Standard Bar Curls", R.drawable.workout_bicep_02, "Hold bar shoulder-width apart and attempt to curl up and down", "3 sets of 10 reps"));
                Constants.workouts.add(new Workout("Dumbbell Curls", R.drawable.workout_bicep_03, "Hold a dumbbell in each hand and attempt to curl each hand separately", "3 sets of 10 reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        tricepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Tricep Pulldowns", R.drawable.workout_tricep_01, "Slightly bend your knees and lean forward, pull down the rope and flex your triceps at the bottom", "3 sets of 10 reps"));
                Constants.workouts.add(new Workout("Tricep Extensions", R.drawable.workout_tricep_02, "Hold the dumbbell over your head and lower it until your arm is fully bent down, then lift it back above your head", "3 sets of 10 reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Reverse-grip Upright Rows", R.drawable.workout_back_01, "Hold a barbell with your palms facing out and slightly bend your knees, then lower the barbell until your elbows are locked and pull the barbell back up", "3 sets of 10 reps"));
                Constants.workouts.add(new Workout("Seated Machine Rows", R.drawable.workout_back_02, "Sit on the seat and put your legs on the end with your knees slightly bent, then grab the bar and pull it back until you are fully arched and then slowly let the bar go back until your elbows are locked", "3 sets of 10 reps"));
                Constants.workouts.add(new Workout("Deadlifts", R.drawable.workout_back_03, "Put your feet shoulder width apart and move towards the bar until your shoe laces are directly under. Bend down and grab the bar and have your chest out and keep your back straight. Lift upwards and squeeze your glutes at the top then go back down in the same fashion.", "3 sets of 10 reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_upper_body_to_workoutFragment);
            }
        });

        return view;
    }

}
