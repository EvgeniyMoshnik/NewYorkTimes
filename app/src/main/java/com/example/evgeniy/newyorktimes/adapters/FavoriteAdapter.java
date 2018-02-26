package com.example.evgeniy.newyorktimes.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evgeniy.newyorktimes.ArticleDetailActivity;
import com.example.evgeniy.newyorktimes.Database.DBHelper;
import com.example.evgeniy.newyorktimes.R;
import com.example.evgeniy.newyorktimes.data.model.Article;
import com.example.evgeniy.newyorktimes.utils.Constants;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ArticleViewHolder>  {

    private List<Article> mArticles;
    private Context mContext;
    private Article mArticle;

    public FavoriteAdapter(List<Article> mArticles, Context mContext) {
        this.mArticles = mArticles;
        this.mContext = mContext;
    }

    @Override
    public FavoriteAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item_favorite, parent, false);

        return new FavoriteAdapter.ArticleViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final FavoriteAdapter.ArticleViewHolder holder,final int position) {
        mArticle = mArticles.get(position);
        holder.mTvTitle.setText(mArticles.get(position).getTitle());
        holder.mTvAbstract.setText(mArticles.get(position).getAbstract());
        holder.mTvByline.setText(mArticles.get(position).getByline());

      //  Log.e("myLog", mArticles.get(position).getTitle());


        holder.mTvPublishedDate.setText(mArticles.get(position).getPublishedDate());

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

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        deleteFavoriteArticle(v);
                    }
                }, 1000);

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    private void deleteFavoriteArticle(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setMessage(R.string.delete_favorite_message);

        builder.setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DBHelper dbHelper = new DBHelper(mContext);
                dbHelper.deleteArticle(mArticle);
                Snackbar.make(view,"Deleted", Snackbar.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        builder.show();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_title_favorite)
        TextView mTvTitle;
        @BindView(R.id.item_abstract_favorite)
        TextView mTvAbstract;
        @BindView(R.id.item_byline_favorite)
        TextView mTvByline;
        @BindView(R.id.item_published_date_favorite)
        TextView mTvPublishedDate;

        private View mView;


        ArticleViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }
    }

}
