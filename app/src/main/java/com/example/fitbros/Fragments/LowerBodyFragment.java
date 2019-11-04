package com.example.fitbros.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fitbros.NavType;
import com.example.fitbros.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LowerBodyFragment extends Fragment {

    ListView listView;

    public LowerBodyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lower_body, container, false);

        listView = view.findViewById(R.id.lowerBodyListView);
        final ArrayList<NavType > navTypes = new ArrayList<>();

        navTypes.add(new NavType("Quadriceps", ""));
        navTypes.add(new NavType("Glutes", ""));
        navTypes.add(new NavType("Calves", ""));
        navTypes.add(new NavType("Hamstrings", ""));


        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, navTypes);

        listView.setAdapter(adapter);


        return view;
    }

}
