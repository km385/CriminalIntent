package com.example.criminalintent;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.Date;
import java.util.UUID;

public class DatePickerActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIME_ID = "com.example.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext, Date crimeDate){
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeDate);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new DatePickerFragment();
    }


}
