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
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder> {

    private List<Article> mArticles;
    private Context mContext;
    private  Article mArticle;

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
        mArticle = mArticles.get(position);
        holder.mTvTitle.setText(mArticles.get(position).getTitle());
        holder.mTvByline.setText(mArticles.get(position).getByline());


        holder.mTvPublishedDate.setText(mArticles.get(position).getPublishedDate());

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

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addFavoriteArticle(v);
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

    private void addFavoriteArticle(final View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setMessage(R.string.add_favorite_message);

        builder.setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DBHelper dbHelper = new DBHelper(mContext);
                dbHelper.saveArticles(mArticle);
                Snackbar.make(view,"Added", Snackbar.LENGTH_LONG).show();
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

        @BindView(R.id.item_title)
        TextView mTvTitle;
        @BindView(R.id.item_byline)
        TextView mTvByline;
        @BindView(R.id.item_published_date)
        TextView mTvPublishedDate;
        @BindView(R.id.circle_image_article)
        CircleImageView mCircleIVArticle;
        View mView;


         ArticleViewHolder(View view) {
            super(view);
            mView = view;

             ButterKnife.bind(this, view);
        }
    }

}
