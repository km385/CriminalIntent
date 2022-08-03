package com.example.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity{
    // it was private in the book but i cannot access it from CrimeFragment.java
    public static final String EXTRA_CRIME_ID = "com.example.criminalintent.crime_id";

    private ViewPager2 mViewPager;
    private List<Crime> mCrimes;

    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        Button first = (Button) findViewById(R.id.goFirst);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mViewPager.setCurrentItem(0);
            }
        });

        Button last = (Button) findViewById(R.id.goLast);

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mViewPager.getCurrentItem()==99){
                    last.setEnabled(false);
                }
                mViewPager.setCurrentItem(mCrimes.size()-1);
            }
        });

        mViewPager = (ViewPager2) findViewById(R.id.crime_view_pager);

        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fragmentManager = getSupportFragmentManager();
        // i'm not sure whether use fragmentManager or use 'this' instead. Works both ways
        mViewPager.setAdapter(new FragmentStateAdapter(fragmentManager, getLifecycle()) {
            @Override
            public int getItemCount() {
                return mCrimes.size();
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

        });

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == 0){
                    first.setEnabled(false);
                }else{
                    first.setEnabled(true);
                }

                if(position == mCrimes.size()-1){
                    last.setEnabled(false);
                }else{
                    last.setEnabled(true);
                }

            }
        });

        for (int i = 0;i < mCrimes.size();i++){
            if (mCrimes.get(i).getId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }

}
