package com.example.evgeniy.newyorktimes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evgeniy.newyorktimes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmailedFragment extends Fragment {


    public EmailedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emailed, container, false);
    }

}
