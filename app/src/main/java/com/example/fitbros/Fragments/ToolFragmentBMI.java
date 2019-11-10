package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fitbros.R;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToolFragmentBMI extends Fragment {

    // create variables for the xml elements
    EditText userWeight;
    EditText userHeight;
    EditText resultBMI;
    EditText weightStatus;

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
        weightStatus = view.findViewById(R.id.outputStatusBMI);

        Button clickButtonBMI = (Button) view.findViewById(R.id.buttonCalculateBMI);

        clickButtonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double localWeight;
                double localHeight;
                double localResult;
                String localStatus;
                int colorRisk=0;

                localWeight = Double.parseDouble(userWeight.getText().toString());
                localHeight = Double.parseDouble(userHeight.getText().toString());
                localResult = 703 * localWeight / (localHeight * localHeight);

                // format result to include trailing 0 if .0
                String formattedResult = String.format("%.1f", localResult);

                resultBMI.setText(formattedResult);

                // BMI Interpretation

                if (localResult < 18.5) {
                    localStatus = "Underweight";
                    colorRisk = ContextCompat.getColor(getContext(), R.color.colorRiskOrange);
                } else if (localResult < 25.0) {
                    localStatus = "Normal or Healthy";
                    colorRisk = ContextCompat.getColor(getContext(), R.color.colorRiskGreen);
                } else if (localResult < 30.0) {
                    localStatus = "Overweight";
                    colorRisk = ContextCompat.getColor(getContext(), R.color.colorRiskYellow);
                } else {
                    localStatus = "Obese";
                    colorRisk = ContextCompat.getColor(getContext(), R.color.colorRiskOrange);
                }

                weightStatus.setText(localStatus);
                weightStatus.setBackgroundColor(colorRisk);

            }
        });

        return view;
    }

    // Information for BMI sourced from CDC.gov
    // BMI Interpretation: https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/index.html#InterpretedAdults

    public void calculateImperial() {

    }

}
