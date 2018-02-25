package com.example.evgeniy.newyorktimes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.evgeniy.newyorktimes.utils.Constants;

public class ArticleDetailActivity extends AppCompatActivity {

    public TextView mTvTitle;
    public TextView mTvAbstract;
    public TextView mTvByline;
    public TextView mTvPublishedDate;
    public TextView mTvUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        //if Error

        mTvTitle = (TextView) findViewById(R.id.detail_title);
        mTvTitle.setText(intent.getStringExtra(Constants.BUNDLE_ARTICLE_TITLE));
        mTvAbstract = (TextView) findViewById(R.id.detail_abstract);
        mTvAbstract.setText(intent.getStringExtra(Constants.BUNDLE_ARTICLE_ABSTRACT));
        mTvByline = (TextView) findViewById(R.id.detail_byline);
        mTvByline.setText(intent.getStringExtra(Constants.BUNDLE_ARTICLE_BYLINE));
        mTvPublishedDate = (TextView) findViewById(R.id.detail_published_date);
        mTvPublishedDate.setText(intent.getStringExtra(Constants.BUNDLE_ARTICLE_DATE));



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_url);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
