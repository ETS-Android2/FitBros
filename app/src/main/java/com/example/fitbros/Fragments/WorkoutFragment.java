package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitbros.Constants;
import com.example.fitbros.Adapters.CustomRecyclerViewAdapter;
import com.example.fitbros.R;


public class WorkoutFragment extends Fragment {

    public WorkoutFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.workoutView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(Constants.workouts);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
