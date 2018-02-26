package com.example.evgeniy.newyorktimes;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.evgeniy.newyorktimes.adapters.TabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    TabAdapter mTabAdapter;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        if (mToolbar != null) {
            mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white ));
            setSupportActionBar(mToolbar);
        }

        mFragmentManager = getSupportFragmentManager();

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

        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.emailed_tab));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.shared_tab));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.viewed_tab));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_favorite);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ArticlesFavoriteActivity.class);
                startActivity(intent);
            }
        });

    }






}
