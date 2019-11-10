package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitbros.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToolFragment extends Fragment {

    public ToolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tool, container, false);

        // Code Checkpoint to test BMI tool
        view.findViewById(R.id.buttonCalculatorBMI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_nav_tool_to_calculator_bmi);


            }
        });

        return view;
    }

}
