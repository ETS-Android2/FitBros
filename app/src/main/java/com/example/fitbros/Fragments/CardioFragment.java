package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

        

        return view;
    }

}
