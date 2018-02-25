package com.example.evgeniy.newyorktimes.Database;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.evgeniy.newyorktimes.adapters.ArticlesAdapter;
import com.example.evgeniy.newyorktimes.data.model.Article;

import java.util.ArrayList;
import java.util.List;

public class QueryManager {

    private SQLiteDatabase database;

    public QueryManager(SQLiteDatabase database)
    {
        this.database = database;
    }

   // public Article getArticle(long timeStamp) {
   //     Article article = null;
  //      Cursor cursor = database.query(DBHelper.ARTICLES_TABLE, null, DBHelper.SELECTION_TIME_STAMP,
   //             new String[]{Long.toString(timeStamp)}, null, null, null);
   //     if (cursor.moveToFirst()) {
   //         String title = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TITLE));
    //        String abstractText = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ABSTRACT));
   //         String byline = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_BYLINE));
    //        String publishedDate = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PUBLISHED_DATA));
    //        String url = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_URL));

       //     article = new Article(title,abstractText, byline, publishedDate, url);
      //  }

      //  cursor.close();
    //    return article;
  //  }

    public List<Article> getArticles () {
        List<Article> articles = new ArrayList<>();
        String selection = "SELECT * FROM " + DBHelper.ARTICLES_TABLE;
        Cursor cursor = database.rawQuery(selection, null);
        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TITLE));
                String abstractText = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ABSTRACT));
                String byline = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_BYLINE));
                String publishedDate = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PUBLISHED_DATA));
                String url = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_URL));
              //  long timeStamp = cursor.getLong(cursor.getColumnIndex(DBHelper.COLUMN_TIME_STAMP));

                Article article = new Article(title, abstractText, byline, publishedDate, url);
                articles.add(article);
                Log.e("myLog", title);

            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();

        return articles;
    }

}
