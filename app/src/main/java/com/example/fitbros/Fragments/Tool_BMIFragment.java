package com.example.fitbros.Fragments;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.fitbros.Constants;
import com.example.fitbros.R;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tool_BMIFragment extends Fragment {

    // create variables for the xml elements
    EditText userWeight;
    EditText userHeight;
    EditText resultBMI;
    EditText weightStatus;

    // Link to menu (Part 1)
    SharedPreferences sharedPreferences;
    String measurement;

    public Tool_BMIFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tool_bmi, container, false);

        userWeight = view.findViewById(R.id.inputWeight);
        userHeight = view.findViewById(R.id.inputHeight);
        resultBMI = view.findViewById(R.id.outputResultBMI);
        weightStatus = view.findViewById(R.id.outputStatusBMI);

        // Link to menu (Part 2)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        measurement = sharedPreferences.getString("measure", Constants.MEASUREMENT_IMPERIAL);

        // Change placeholders for weight and height according to menu preference
        if (measurement.equals(Constants.MEASUREMENT_IMPERIAL)) {
            userWeight.setHint(getResources().getString(R.string.tool_BMI_weight_hint));
            userHeight.setHint(getResources().getString(R.string.tool_BMI_height_hint));

        } else {
            userWeight.setHint(getResources().getString(R.string.tool_BMI_weight_hint_metric));
            userHeight.setHint(getResources().getString(R.string.tool_BMI_height_hint_metric));
        }

        Button clickButtonBMI = (Button) view.findViewById(R.id.buttonCalculateBMI);

        clickButtonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboardFrom(getContext(), view);

                double localWeight;
                double localHeight;
                double localResult = 0;
                String localStatus;
                int colorRisk=0;

                localWeight = Double.parseDouble(userWeight.getText().toString());
                localHeight = Double.parseDouble(userHeight.getText().toString());

                // check for user preference of metric or imperial
                if (measurement.equals(Constants.MEASUREMENT_IMPERIAL)) {
                    localResult = 703 * localWeight / (localHeight * localHeight);

                } else {
                    localResult = localWeight / ((localHeight/100) * (localHeight/100));
                }

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

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    // Information for BMI sourced from CDC.gov
    // BMI Interpretation: https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/index.html#InterpretedAdults

}