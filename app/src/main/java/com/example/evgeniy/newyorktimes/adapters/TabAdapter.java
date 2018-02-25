package com.example.evgeniy.newyorktimes.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.evgeniy.newyorktimes.fragments.ArticlesFragment;
import com.example.evgeniy.newyorktimes.utils.Constants;

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
                return ArticlesFragment.newInstance(Constants.ARTICLES_TYPE_MOSTEMAILED);
            case 1:
                return ArticlesFragment.newInstance(Constants.ARTICLES_TYPE_MOSTSHARED);
            case 2:
                return ArticlesFragment.newInstance(Constants.ARTICLES_TYPE_MOSTVIEWED);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
