package com.example.fitbros.Fragments;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class Tool_RFMFragment extends Fragment {

    // create variables for the xml elements
    EditText userWaist;
    EditText userHeight;
    EditText resultRFM;
    EditText fatStatus;

    //Gender buttons
    Button maleButton;
    Button femaleButton;
    String gender = "male";

    double localResult = 0;

    // Link to menu (Part 1)
    SharedPreferences sharedPreferences;
    String measurement;

    public Tool_RFMFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tool_rfm, container, false);

        userWaist = view.findViewById(R.id.inputWaist);
        userHeight = view.findViewById(R.id.inputHeightRFM);
        resultRFM = view.findViewById(R.id.outputResultRFM);
        fatStatus = view.findViewById(R.id.outputStatusRFM);

        //link buttons
        maleButton = view.findViewById(R.id.maleButton);
        femaleButton = view.findViewById(R.id.femaleButton);

        maleButton.setTextColor(getResources().getColor(R.color.colorGoldLight));
        femaleButton.setTextColor(Color.WHITE);

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "male";

                maleButton.setTextColor(getResources().getColor(R.color.colorGoldLight));
                femaleButton.setTextColor(Color.WHITE);

                if(localResult != 0) {
                    calculate();
                }
            }
        });

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "female";

                femaleButton.setTextColor(getResources().getColor(R.color.colorGoldLight));
                maleButton.setTextColor(Color.WHITE);

                if(localResult != 0) {
                    calculate();
                }
            }
        });

        // Link to menu (Part 2)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        measurement = sharedPreferences.getString("measure", Constants.MEASUREMENT_IMPERIAL);

        // Change placeholders for weight and height according to menu preference
        if (measurement.equals(Constants.MEASUREMENT_IMPERIAL)) {
            userWaist.setHint(getResources().getString(R.string.tool_RFM_waist_hint));
            userHeight.setHint(getResources().getString(R.string.tool_RFM_height_hint));

        } else {
            userWaist.setHint(getResources().getString(R.string.tool_RFM_waist_hint_metric));
            userHeight.setHint(getResources().getString(R.string.tool_RFM_height_hint_metric));
        }

        Button clickButtonRFM = (Button) view.findViewById(R.id.buttonCalculateRFM);

        clickButtonRFM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboardFrom(getContext(), view);

                calculate();

            }
        });

        return view;
    }

    public void calculate() {
        double localWaist;
        double localHeight;
        String localStatus;
        int colorRisk=0;

        localWaist = Double.parseDouble(userWaist.getText().toString());
        localHeight = Double.parseDouble(userHeight.getText().toString());

        // Potential TODO: check for gender of user
        if (gender.equals("male")) {
            // Formula for men
            localResult = 64 - (20 * localHeight/localWaist);

        } else if (gender.equals("female")){

            // Formula for women
            localResult = 76 - (20 * localHeight/localWaist);

        }

        // format result to include trailing 0 if .0
        String formattedResult = String.format("%.1f", localResult);

        resultRFM.setText(formattedResult);

        // RFM Interpretation

        if (localResult < 18.5) {
            localStatus = "Underweight";
            colorRisk = ContextCompat.getColor(getContext(), R.color.colorRiskRed);
        } else if (localResult < 25.0) {
            localStatus = "Normal or Healthy";
            colorRisk = ContextCompat.getColor(getContext(), R.color.colorRiskGreen);
        } else if (localResult < 30.0) {
            localStatus = "Overweight";
            colorRisk = ContextCompat.getColor(getContext(), R.color.colorRiskYellow);
        } else {
            localStatus = "Obese";
            colorRisk = ContextCompat.getColor(getContext(), R.color.colorRiskRed);
        }

        fatStatus.setText(localStatus);
        fatStatus.setBackgroundColor(colorRisk);
    }

    /**
     * This will take the keyboard off the screen
     * @param context
     * @param view
     * @author Hasan Muslemani
     * @date November 20, 2019
     * @version 1.0
     */
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    // Information for RFM sourced from Cedars-Sinai Medical Center
    // RFM Interpretation: https://www.cedars-sinai.org/blog/relative-fat-mass.html
    // https://www.cedars-sinai.org/newsroom/cedars-sinai-investigators-develop-more-accurate-measure-of-body-fat/
    // https://www.nature.com/articles/s41598-018-29362-1

}