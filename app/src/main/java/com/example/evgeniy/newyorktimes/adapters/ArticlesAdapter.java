package com.example.evgeniy.newyorktimes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evgeniy.newyorktimes.R;
import com.example.evgeniy.newyorktimes.data.model.Article;
import com.example.evgeniy.newyorktimes.data.model.ArticleList;

import java.util.List;


public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder> {

    private List<Article> mArticles;
    private Context mContext;

    public ArticlesAdapter(List<Article> mArticles, Context mContext) {
        this.mArticles = mArticles;
        this.mContext = mContext;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new ArticleViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
       // Article article = mArticles.get(position);
        holder.mTvTitle.setText(mArticles.get(position).getTitle());
        holder.mTvAbstract.setText(mArticles.get(position).getAbstract());
        holder.mTvByline.setText(mArticles.get(position).getByline());
        holder.mTvPublishedDate.setText(mArticles.get(position).getPublishedDate());
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvTitle;
        public TextView mTvAbstract;
        public TextView mTvByline;
        public TextView mTvPublishedDate;

      //  private Article mArticle;


        public ArticleViewHolder(View view) {
            super(view);

            mTvTitle = (TextView) view.findViewById(R.id.item_title);
            mTvAbstract = (TextView) view.findViewById(R.id.item_abstract);
            mTvByline = (TextView) view.findViewById(R.id.item_byline);
            mTvPublishedDate = (TextView) view.findViewById(R.id.item_published_date);
        }
    }

}
