package com.example.fitbros.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fitbros.JavaBeans.NavType;
import com.example.fitbros.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    // ListView addition by Cordelle 2019-11-03

    TextView navMenuDescription;
    ListView listView;

    // Link to the menu: Part 1
    TextView usernameChange;
    SharedPreferences sharedPreferences;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Link to the menu: Part 2
        usernameChange = view.findViewById(R.id.usernameHome);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        usernameChange.setText(sharedPreferences.getString("userName", getResources().getString(R.string.preference_name_placeholder)));

        listView = view.findViewById(R.id.homeNavList);

        final ArrayList<NavType> navTypes = new ArrayList<>();
        
        navTypes.add(new NavType (getResources().getString(R.string.menu_upper_body), getResources().getString(R.string.description_upper_body), R.drawable.ic_upper_body_grayblue_24dp));
        navTypes.add(new NavType (getResources().getString(R.string.menu_lower_body), getResources().getString(R.string.description_lower_body), R.drawable.ic_lower_body_grayblue_24dp));
        navTypes.add(new NavType (getResources().getString(R.string.menu_core_muscles), getResources().getString(R.string.description_core_muscles), R.drawable.ic_core_muscles_grayblue_24dp));
        navTypes.add(new NavType (getResources().getString(R.string.menu_cardio_long), getResources().getString(R.string.description_cardio), R.drawable.ic_cardio_grayblue_24dp));
        navTypes.add(new NavType (getResources().getString(R.string.menu_tool), getResources().getString(R.string.description_tools), R.drawable.ic_calculator_grayblue_24dp));

        ArrayAdapter adapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, navTypes);

        CustomListViewAdapter adapter1 =
                new CustomListViewAdapter(getContext(),
                        navTypes);

        // listView.setAdapter(adapter);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_upper_body);
                        break;
                    case 1:
                        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_lower_body);
                        break;
                    case 2:
                        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_core_muscles);
                        break;
                    case 3:
                        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_cardio);
                        break;
                    case 4:
                        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_tools);
                        break;
                }
            }
        });

        return view;
    }

    public class CustomListViewAdapter extends ArrayAdapter<NavType> {

        // create constructor
        public CustomListViewAdapter(@NonNull Context context, ArrayList<NavType> items) {

            // super(context, resource);
            super(context, 0, items);
        }

        // type getView to auto-generate...

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // return super.getView(position, convertView, parent);

            // Grab the current item in the list
            NavType item = getItem(position);

            // check if it has a view
            // if it does not, then give it one
            if (convertView == null) {
                convertView = LayoutInflater.
                        from(getContext()).
                        inflate(R.layout.listview_template, parent, false);
            }

            TextView name = convertView.findViewById(R.id.homeNavText);
            ImageView image = convertView.findViewById(R.id.homeNavIcon);
            name.setText(item.getName());
            image.setImageResource(item.getImage());

            return convertView;
        }
    }
}
