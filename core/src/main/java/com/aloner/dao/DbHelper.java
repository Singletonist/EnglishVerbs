package com.aloner.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DbHelper  extends SQLiteOpenHelper
{
  public static final String TABLE_VERBS = "verbs";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_PRESENT_SIMPLE = "present_simple";
  public static final String COLUMN_PAST_SIMPLE = "past_simple";
  public static final String COLUMN_PRESENT_PERFECT = "present_perfect";
  public static final String COLUMN_TRANSLATION = "translation";
  private static final String DATABASE_NAME = "TheEnglish.db";
  private static final int DATABASE_VERSION = 1;
  public static String DB_PATH;
  public final Context context;

  public SQLiteDatabase database;

  public DbHelper(Context context)
  {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    this.context = context;
    DB_PATH = context.getDatabasePath(DATABASE_NAME).toString();
    this.openDataBase();
  }

  public void createDataBase() {
    boolean dbExist = checkDataBase();
    if (!dbExist) {
      this.getReadableDatabase();
      try {
        copyDataBase();
      } catch (IOException e) {
        Log.e(this.getClass().toString(), "Copying error");
        throw new Error("Error copying database!");
      }
    } else {
      Log.i(this.getClass().toString(), "Database already exists");
    }
  }

  private boolean checkDataBase() {
    File dbFile = null;
    try {
      dbFile = new File(DB_PATH);
    } catch (SQLException e) {
      Log.e(this.getClass().toString(), "Error while checking db");
    }
    return dbFile.exists();
  }

  private void copyDataBase() throws IOException
  {
    InputStream externalDbStream = context.getAssets().open(DATABASE_NAME);
    OutputStream localDbStream = new FileOutputStream(DB_PATH);
    byte[] buffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = externalDbStream.read(buffer)) > 0) {
      localDbStream.write(buffer, 0, bytesRead);
    }
    localDbStream.flush();
    localDbStream.close();
    externalDbStream.close();
  }

  public SQLiteDatabase openDataBase() throws SQLException
  {
    if (database == null) {
      createDataBase();
      database = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
    return database;
  }
  @Override
  public synchronized void close() {
    if (database != null) {
      database.close();
    }
    super.close();
  }
  @Override
  public void onCreate(SQLiteDatabase db) {}
  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
