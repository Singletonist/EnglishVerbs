package com.aloner.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper  extends SQLiteOpenHelper
{
  private static final String LOG_TAG = "myLog";
  public static final String TABLE_ITEMS = "items";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_PRESENT_SIMPLE = "presentSimple";
  public static final String COLUMN_PAST_SIMPLE = "pastSimple";
  public static final String COLUMN_PRESENT_PERFECT = "presentPerfect";
  public static final String COLUMN_TRANSLATION = "translation";

  private static final String DATABASE_NAME = "translator.db";
  private static final int DATABASE_VERSION = 1;

  private static final String DATABASE_CREATE =
      "create table "+ TABLE_ITEMS + "("
          + COLUMN_ID + " integer primary key autoincrement, "
          + COLUMN_PRESENT_SIMPLE + " text not null,"
          + COLUMN_PAST_SIMPLE + " text not null,"
          + COLUMN_PRESENT_PERFECT + " text not null,"
          + COLUMN_TRANSLATION + " text not null);";

  public DbHelper(Context context)
  {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database)
  {
    Log.w(LOG_TAG, "----try to create DB---");
    database.execSQL(DATABASE_CREATE);
    Log.w(LOG_TAG, "----DB is created----");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
  {
    Log.w(DbHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data"
    );
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
    onCreate(db);
  }
}
