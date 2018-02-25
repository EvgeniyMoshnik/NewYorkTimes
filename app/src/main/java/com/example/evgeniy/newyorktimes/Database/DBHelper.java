package com.example.evgeniy.newyorktimes.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.evgeniy.newyorktimes.data.model.Article;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "articles_database";
    public static final int DATABASE_VERSION = 1;

    public static final String ARTICLES_TABLE = "articles_table";

    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_ABSTRACT = "abstract";
    public static final String COLUMN_BYLINE = "byline";
    public static final String COLUMN_PUBLISHED_DATA = "published_data";
    public static final String COLUMN_URL = "url";
 //   public static final String COLUMN_TIME_STAMP = "task_time_stamp";

    private static final String ARTICLES_TABLE_CREATE_SCRIPT = "CREATE TABLE " + ARTICLES_TABLE
            + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " TEXT NOT NULL, "
            + COLUMN_ABSTRACT + " TEXT, " + COLUMN_BYLINE + " TEXT, "
            + COLUMN_PUBLISHED_DATA + " TEXT, " + COLUMN_URL + " TEXT);";

    public static final String SELECTION_TiTLE = COLUMN_TITLE + " = ?";

    private QueryManager queryManager;



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        queryManager = new QueryManager(getReadableDatabase());

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ARTICLES_TABLE_CREATE_SCRIPT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + ARTICLES_TABLE);
        onCreate(db);
    }

    public QueryManager query() {

        return queryManager;
    }


    public void saveArticles(Article article) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, article.getTitle());
        cv.put(COLUMN_ABSTRACT, article.getAbstract());
        cv.put(COLUMN_BYLINE, article.getByline());
        cv.put(COLUMN_PUBLISHED_DATA, article.getPublishedDate());
        cv.put(COLUMN_URL, article.getUrl());
       // cv.put(COLUMN_TIME_STAMP, article.getTimeStamp());


        db.insert(ARTICLES_TABLE, null, cv);

        db.close();


    }

    public void removeTask(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ARTICLES_TABLE, SELECTION_TiTLE, new String[]{String.valueOf(article.getTitle())});
        db.close();
    }
}
