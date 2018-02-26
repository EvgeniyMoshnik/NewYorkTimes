package com.example.evgeniy.newyorktimes;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.evgeniy.newyorktimes.Database.DBHelper;
import com.example.evgeniy.newyorktimes.adapters.FavoriteAdapter;
import com.example.evgeniy.newyorktimes.data.model.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesFavoriteActivity extends AppCompatActivity {

    @BindView(R.id.article_recycler_view_favorite)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout_favorite)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_favorite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshArticles();
            }
        });

        refreshArticles();

    }

    public void refreshArticles() {
        DBHelper db = new DBHelper(getApplicationContext());
        List<Article> articles = db.query().getArticles();
        recyclerView.setAdapter(new FavoriteAdapter(articles, getApplicationContext()));

        swipeRefreshLayout.setRefreshing(false);
    }

}
