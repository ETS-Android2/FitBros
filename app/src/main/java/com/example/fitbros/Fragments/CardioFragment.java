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

                Constants.workouts.add(new Workout("Treadmill", R.drawable.workout_machine_treadmill, "Turn it to the speed and incline you'd like and run", "5kmph speed and 5% incline for 30 minutes"));

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        cycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Cycling", R.drawable.workout_manual_cycle, "Sit on the bicycle and peddle with your feet", "Steady pace for 30 minutes"));

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        jumpRopeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.workouts.removeAll(Constants.workouts);

                Constants.workouts.add(new Workout("Rope Climbing", R.drawable.workout_rope_climb, "Extend your arms and reach as far as you can and grab the rope using your feet as assistance to hold you up. Repeat this until you're at the top of the rope", "3 sets"));

                Navigation.findNavController(view).navigate(R.id.action_nav_cardio_to_workoutFragment);
            }
        });

        return view;
    }

}
