package com.example.evgeniy.newyorktimes.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evgeniy.newyorktimes.NYTimesApi.NYTimesClient;
import com.example.evgeniy.newyorktimes.NYTimesApi.NYTimesService;
import com.example.evgeniy.newyorktimes.R;
import com.example.evgeniy.newyorktimes.adapters.ArticlesAdapter;
import com.example.evgeniy.newyorktimes.data.model.Article;
import com.example.evgeniy.newyorktimes.data.model.ArticleList;
import com.example.evgeniy.newyorktimes.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment {

   // private static  String API_KEY = "";
    private static final String BUNDLE_TYPE_ARTICLES = "type_articles";

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
 //   private RecyclerView.Adapter mRVAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private String mTypeArticles;

    public static ArticlesFragment newInstance(String typeArticles) {
        ArticlesFragment fragment = new ArticlesFragment();

        Bundle argument = new Bundle();
        argument.putString(BUNDLE_TYPE_ARTICLES, typeArticles);

        fragment.setArguments(argument);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTypeArticles = getArguments().getString(BUNDLE_TYPE_ARTICLES);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_articles, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.article_recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

     //   mRVAdapter = new ArticlesAdapter();
       // mRecyclerView.setAdapter(mRVAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshArticles();
            }
        });

        refreshArticles();


        return rootView;
    }


    public void refreshArticles() {
      //  API_KEY = getResources().getString(R.string.api_key);

        Call<ArticleList> call = NYTimesClient.getClient().getArticles(mTypeArticles, "all-sections", 30, Constants.API_KEY);

        call.enqueue(new Callback<ArticleList>() {
            @Override
            public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {

                if (response.body() != null) {
                    List<Article> articles = response.body().getResults();
                    mRecyclerView.setAdapter(new ArticlesAdapter(articles, getActivity()));
                }
            }

            @Override
            public void onFailure(Call<ArticleList> call, Throwable t) {
                Log.e("MyLog", "Failed retrofit", t);
            }
        });

        mSwipeRefreshLayout.setRefreshing(false);
    }
}
