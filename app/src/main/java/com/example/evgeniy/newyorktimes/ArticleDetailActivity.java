package com.example.evgeniy.newyorktimes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.evgeniy.newyorktimes.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ArticleDetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_title)
    TextView mTvTitle;
    @BindView(R.id.detail_abstract)
    TextView mTvAbstract;
    @BindView(R.id.detail_byline)
    TextView mTvByline;
    @BindView(R.id.detail_published_date)
    TextView mTvPublishedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        final Intent intent = getIntent();

        if (intent != null) {

            mTvTitle.setText(intent.getStringExtra(Constants.BUNDLE_ARTICLE_TITLE));
            mTvAbstract.setText(intent.getStringExtra(Constants.BUNDLE_ARTICLE_ABSTRACT));
            mTvByline.setText(intent.getStringExtra(Constants.BUNDLE_ARTICLE_BYLINE));
            mTvPublishedDate.setText(intent.getStringExtra(Constants.BUNDLE_ARTICLE_DATE));
        }



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_url);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(intent.getStringExtra(Constants.BUNDLE_ARTICLE_URL));
                Intent intentUrl = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentUrl);

            }
        });
    }

}
