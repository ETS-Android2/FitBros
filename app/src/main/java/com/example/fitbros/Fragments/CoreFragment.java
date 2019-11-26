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

                Constants.workouts.add(new Workout("Battle Ropes", R.drawable.workout_core_abs_battle_ropes, "Hold the ropes and slightly bend your knees, then swing the ropes up and down while keep a good posture", "3 times for 60 seconds"));

                Navigation.findNavController(view).navigate(R.id.action_nav_core_muscles_to_workoutFragment);
            }
        });

        obliquesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Side Oblique Crunch", R.drawable.workout_core_obliques, "Lie down on the floor with your legs stacked and bring your right hand behind your head while using your left to hold yourself up. Bring your elbow up (connected to your head) and towards your feet then bring it back", "3 sets of 10 reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_core_muscles_to_workoutFragment);
            }
        });

        glutesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Tire Flips", R.drawable.workout_core_glutes, "Bend your knees and keep your back straight. While infront of the tire grab underneath it and lift it upwards and flip it", "3 sets of 10 reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_core_muscles_to_workoutFragment);
            }
        });

        return view;
    }

}
