package com.example.criminalintent;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIME_ID =
            "com.example.criminalintent.crime_id";

    public static Intent newIntent(Context packageContent, UUID crimeId){
        Intent intent = new Intent(packageContent, MainActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}