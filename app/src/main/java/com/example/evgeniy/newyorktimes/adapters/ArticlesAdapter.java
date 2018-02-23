package com.example.evgeniy.newyorktimes.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evgeniy.newyorktimes.ArticleDetailActivity;
import com.example.evgeniy.newyorktimes.R;
import com.example.evgeniy.newyorktimes.data.model.Article;
import com.example.evgeniy.newyorktimes.data.model.ArticleList;
import com.example.evgeniy.newyorktimes.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


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
    public void onBindViewHolder(final ArticleViewHolder holder, final int position) {
       // Article article = mArticles.get(position);
        holder.mTvTitle.setText(mArticles.get(position).getTitle());
        holder.mTvAbstract.setText(mArticles.get(position).getAbstract());
        holder.mTvByline.setText(mArticles.get(position).getByline());

      //  String formateDate = DateFormat.format("yyyy-MM-dd", mArticles.get(position).getPublishedDate());

        holder.mTvPublishedDate.setText(mArticles.get(position).getPublishedDate());

     //Error catch me
        if (mArticles.get(position).getMedia() != null &&
                mArticles.get(position).getMedia().get(0).getMediaMetadatas() != null) {

            Picasso.with(mContext).load(mArticles.get(position).getMedia().get(0).getMediaMetadatas().get(0).getUrl()).into(holder.mCircleIVArticle);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ArticleDetailActivity.class);
                intent.putExtra(Constants.BUNDLE_ARTICLE_TITLE, mArticles.get(position).getTitle());
                intent.putExtra(Constants.BUNDLE_ARTICLE_ABSTRACT, mArticles.get(position).getAbstract());
                intent.putExtra((Constants.BUNDLE_ARTICLE_BYLINE), mArticles.get(position).getByline());
                intent.putExtra(Constants.BUNDLE_ARTICLE_DATE, mArticles.get(position).getPublishedDate());
                intent.putExtra(Constants.BUNDLE_ARTICLE_URL, mArticles.get(position).getUrl());

                context.startActivity(intent);
            }
        });
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
        public CircleImageView mCircleIVArticle;
        public View mView;

      //  private Article mArticle;


        public ArticleViewHolder(View view) {
            super(view);
            mView = view;

            mTvTitle = (TextView) view.findViewById(R.id.item_title);
            mTvAbstract = (TextView) view.findViewById(R.id.item_abstract);
            mTvByline = (TextView) view.findViewById(R.id.item_byline);
            mTvPublishedDate = (TextView) view.findViewById(R.id.item_published_date);
            mCircleIVArticle = (CircleImageView) view.findViewById(R.id.circle_image_article);
        }
    }

}
