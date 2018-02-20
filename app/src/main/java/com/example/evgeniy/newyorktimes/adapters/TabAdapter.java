package com.example.evgeniy.newyorktimes.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.evgeniy.newyorktimes.fragments.ArticlesFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    private int mNumberOfTabs;

    public TabAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.mNumberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new ArticlesFragment();
            case 1:
                return new ArticlesFragment();
            case 2:
                return new ArticlesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
