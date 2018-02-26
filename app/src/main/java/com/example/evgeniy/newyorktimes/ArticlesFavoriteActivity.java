package com.example.evgeniy.newyorktimes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.evgeniy.newyorktimes.Database.DBHelper;
import com.example.evgeniy.newyorktimes.adapters.ArticlesAdapter;
import com.example.evgeniy.newyorktimes.adapters.FavoriteAdapter;
import com.example.evgeniy.newyorktimes.data.model.Article;

import java.util.List;

public class ArticlesFavoriteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_favorite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.article_recycler_view_favorite);
     //   assert recyclerView != null;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout_favorite);

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
