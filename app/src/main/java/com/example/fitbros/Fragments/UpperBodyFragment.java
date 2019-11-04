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
public class UpperBodyFragment extends Fragment {

    ListView listView;

    public UpperBodyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upper_body, container, false);

        listView = view.findViewById(R.id.upperBodyListView);
        final ArrayList<NavType> navTypes = new ArrayList<>();

        navTypes.add(new NavType("Bicep", ""));
        navTypes.add(new NavType("Tricep", ""));
        navTypes.add(new NavType("Chest", ""));
        navTypes.add(new NavType("Back", ""));


        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, navTypes);

        listView.setAdapter(adapter);

        return view;
    }

}
