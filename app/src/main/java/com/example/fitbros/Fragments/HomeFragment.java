package com.example.fitbros.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.renderscript.Element;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fitbros.NavType;
import com.example.fitbros.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    // ListView addition by Cordelle 2019-11-03

    TextView navMenuDescription;
    ListView listView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        navMenuDescription = view.findViewById(R.id.homeNavDescription);

        listView = view.findViewById(R.id.homeNavList);

        final ArrayList<NavType> navTypes = new ArrayList<>();

//        navTypes.add(new NavType (R.string.menu_upper_body, R.string.));
//        navTypes.add(new NavType("@string/menu_upper_body", "@string/description_upper_body"));
//        navTypes.add(new NavType("@string/menu_lower_body", "@string/description_lower_body"));
//        navTypes.add(new NavType("@string/menu_core_muscles", "@string/description_core_muscles"));
//        navTypes.add(new NavType("@string/menu_cardio", "@string/description_cardio"));
//        navTypes.add(new NavType("@string/submenu_tools_BMI", "@string/description_BMI"));
//        navTypes.add(new NavType("@string/submenu_tools_RFM", "@string/description_RFM"));
        navTypes.add(new NavType (getResources().getString(R.string.menu_upper_body), getResources().getString(R.string.description_upper_body)));
        navTypes.add(new NavType (getResources().getString(R.string.menu_lower_body), getResources().getString(R.string.description_lower_body)));
        navTypes.add(new NavType (getResources().getString(R.string.menu_core_muscles), getResources().getString(R.string.description_core_muscles)));
        navTypes.add(new NavType (getResources().getString(R.string.menu_cardio_long), getResources().getString(R.string.description_cardio)));
        navTypes.add(new NavType (getResources().getString(R.string.submenu_tools_BMI_short), getResources().getString(R.string.description_BMI)));
        navTypes.add(new NavType (getResources().getString(R.string.submenu_tools_RFM_short), getResources().getString(R.string.description_RFM)));

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
                navMenuDescription.setText(navTypes.get(position).getDescription());
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
            name.setText(item.getName());

            return convertView;
        }
    }
}
