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
import com.example.evgeniy.newyorktimes.R;
import com.example.evgeniy.newyorktimes.data.model.Article;
import com.example.evgeniy.newyorktimes.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;



public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ArticleViewHolder>  {

    private List<Article> mArticles;
    private Context mContext;

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
    public void onBindViewHolder(final FavoriteAdapter.ArticleViewHolder holder, final int position) {
        // Article article = mArticles.get(position);
        holder.mTvTitle.setText(mArticles.get(position).getTitle());
        holder.mTvAbstract.setText(mArticles.get(position).getAbstract());
        holder.mTvByline.setText(mArticles.get(position).getByline());

        //  String formateDate = DateFormat.format("yyyy-MM-dd", mArticles.get(position).getPublishedDate());

        holder.mTvPublishedDate.setText(mArticles.get(position).getPublishedDate());

        //Error catch me
      //  if (mArticles.get(position).getMedia() != null &&
      //          mArticles.get(position).getMedia().get(0).getMediaMetadatas() != null) {

         //   Picasso.with(mContext).load(mArticles.get(position).getMedia().get(0).getMediaMetadatas().get(0).getUrl()).into(holder.mCircleIVArticle);
       // }

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
            public boolean onLongClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

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

    public void addFavoriteArticle(final View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setMessage(R.string.add_favorite_message);

        builder.setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


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

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvTitle;
        public TextView mTvAbstract;
        public TextView mTvByline;
        public TextView mTvPublishedDate;
    //    public CircleImageView mCircleIVArticle;
        public View mView;

        //  private Article mArticle;


        public ArticleViewHolder(View view) {
            super(view);
            mView = view;

            mTvTitle = (TextView) view.findViewById(R.id.item_title_favorite);
            mTvAbstract = (TextView) view.findViewById(R.id.item_abstract_favorite);
            mTvByline = (TextView) view.findViewById(R.id.item_byline_favorite);
            mTvPublishedDate = (TextView) view.findViewById(R.id.item_published_date_favorite);
          //  mCircleIVArticle = (CircleImageView) view.findViewById(R.id.circle_image_article);
        }
    }

}
