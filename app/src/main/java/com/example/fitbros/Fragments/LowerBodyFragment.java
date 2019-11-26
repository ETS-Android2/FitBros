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

                Constants.workouts.add(new Workout("Squats", R.drawable.workout_lower_squat, "Place a barbell with weights right below your neck and squat down until you hit right below 90 degrees, then attempt to lift back up", "3 sets of 10 reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        hamsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Box Jumps", R.drawable.workout_lower_box, "Bend your knees about 45 degrees and attempt to jump on the box, then jump back to the floor", "3 sets of 10 reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        calvesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Lunges", R.drawable.workout_lower_lunge, "Hold some low weight dumbbells and bend one knee until it touches the ground, then lift back up and repeat with your other knee", "3 sets of 10 reps"));

                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        return view;
    }

}
