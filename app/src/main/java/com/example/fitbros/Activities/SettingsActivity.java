package com.example.fitbros.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.example.fitbros.R;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new CustomPreferenceFragment()).commit();

    }

    public static class CustomPreferenceFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference_screen);

            // Menu Option #1: User Name
            final EditTextPreference editTextPreference = (EditTextPreference) findPreference("userName");

            editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);

                    return true;
                }
            });

            // Menu Option #2: Language
            final ListPreference languagePreference = (ListPreference) findPreference("lang");

            languagePreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);

                    return true;
                }
            });

            // Menu Option #3: Measurement
            final ListPreference measurementPreference = (ListPreference) findPreference("measure");

            measurementPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);

                    return true;
                }
            });
        }
    }
}
