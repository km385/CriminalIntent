package com.example.criminalintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Date;

public class DatePickerFragment extends AppCompatDialogFragment {

    private static final String ARG_DATE = "date";

    private DatePicker mDatePicker;
    private Button mConfirmButton;

    public static DatePickerFragment newInstance(Date date){
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_date, container, false);

        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);
        mConfirmButton = (Button)  v.findViewById(R.id.button);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // empty for now
            }
        });

        return v;
    }

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        Date date = (Date) getArguments().getSerializable(ARG_DATE);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int hour = calendar.get(Calendar.HOUR);
//        int minute = calendar.get(Calendar.MINUTE);
//
//        View v = LayoutInflater.from(getActivity())
//                .inflate(R.layout.dialog_date, null);
//
//        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);
//        mDatePicker.init(year, month, day, null);
//
//        return new AlertDialog.Builder(getActivity())
//                .setView(v)
//                .setTitle(R.string.data_picker_title)
//                .setPositiveButton(android.R.string.ok,
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                int year = mDatePicker.getYear();
//                                int month = mDatePicker.getMonth();
//                                int day = mDatePicker.getDayOfMonth();
//                                Calendar date = Calendar.getInstance();
//                                date.set(Calendar.YEAR, year);
//                                date.set(Calendar.MONTH, month);
//                                date.set(Calendar.DAY_OF_MONTH, day);
//                                date.set(Calendar.MINUTE, minute);
//                                date.set(Calendar.HOUR, hour);
//                                Bundle result = new Bundle();
//                                result.putSerializable("date", date.getTime());
//                                getParentFragmentManager().setFragmentResult("requestKey", result);
//                            }
//                        })
//                .create();
//    }
}
