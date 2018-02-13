package com.example.evgeniy.newyorktimes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evgeniy.newyorktimes.R;
import com.example.evgeniy.newyorktimes.adapters.EmailedRVAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmailedFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mRVAdapter;


    public EmailedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_emailed, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.emailed_recycler_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRVAdapter = new EmailedRVAdapter();
        mRecyclerView.setAdapter(mRVAdapter);

        return rootView;
    }

}
