package com.example.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.io.File;

public class ImageZoomFragment extends AppCompatDialogFragment {

    private static final String ARG_PATH = "imagePath";

    private ImageView image;

    public static ImageZoomFragment newInstance(String imagePath) {

        Bundle args = new Bundle();
        args.putString(ARG_PATH, imagePath);

        ImageZoomFragment fragment = new ImageZoomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        File file = new File(getArguments().getString(ARG_PATH));

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_image_zoom, null);

        image = (ImageView) v.findViewById(R.id.crime_image);
        Bitmap bitmap = PictureUtils.getScaledBitmap(file.getPath(), getActivity());
        image.setImageBitmap(bitmap);


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }


}
