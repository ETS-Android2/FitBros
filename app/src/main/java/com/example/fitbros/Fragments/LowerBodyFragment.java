package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.fitbros.NavType;
import com.example.fitbros.R;

import java.util.ArrayList;


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
                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        hamsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        calvesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_nav_lower_body_to_workoutFragment);
            }
        });

        return view;
    }

}
