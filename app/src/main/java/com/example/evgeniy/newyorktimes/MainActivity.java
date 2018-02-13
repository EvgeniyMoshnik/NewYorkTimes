package com.example.evgeniy.newyorktimes;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.evgeniy.newyorktimes.adapters.TabAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabAdapter mTabAdapter;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white ));
            setSupportActionBar(toolbar);
        }

        mFragmentManager = getSupportFragmentManager();

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.Emailed_tab));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.Shared_tab));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.Viewed_tab));

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabAdapter = new TabAdapter(mFragmentManager, 3);

        mViewPager.setAdapter(mTabAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}