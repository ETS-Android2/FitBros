package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fitbros.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToolFragmentBMI extends Fragment {

    // create variables for the xml elements
    EditText userWeight;
    EditText userHeight;
    EditText resultBMI;

    public ToolFragmentBMI() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tool_bmi, container, false);

        userWeight = view.findViewById(R.id.inputWeight);
        userHeight = view.findViewById(R.id.inputHeight);
        resultBMI = view.findViewById(R.id.outputResultBMI);

        Button clickButtonBMI = (Button) view.findViewById(R.id.buttonCalculateBMI);

        clickButtonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double localWeight;
                double localHeight;
                double localResult;

                localWeight = Double.parseDouble(userWeight.getText().toString());
                localHeight = Double.parseDouble(userHeight.getText().toString());
                localResult = localWeight / (localHeight * localHeight) * 703;

                resultBMI.setText(localResult+"");
            }
        });

        return view;
    }

    public void calculateImperial() {

    }

}
