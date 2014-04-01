package com.aloner.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.aloner.object.Verb;

import java.util.ArrayList;
import java.util.List;

public class VerbDao
{
  private SQLiteDatabase database;
  private DbHelper dbHelper;
  private String[] allColumns =
      {
          DbHelper.COLUMN_ID,
          DbHelper.COLUMN_INFINITIVE,
          DbHelper.COLUMN_PAST_SIMPLE,
          DbHelper.COLUMN_PAST_PARTICIPLE,
          DbHelper.COLUMN_TRANSLATION
      };

  public VerbDao(Context context)
  {
    dbHelper = new DbHelper(context);
  }

  public void open() throws SQLException
  {
    database = dbHelper.getWritableDatabase();
  }

  public void close()
  {
    dbHelper.close();
  }

  public Verb createVerb(Verb verb)
  {
    ContentValues cv = new ContentValues();
    cv.put(DbHelper.COLUMN_INFINITIVE, verb.getInfinitive());
    cv.put(DbHelper.COLUMN_PAST_SIMPLE, String.valueOf(verb.getPastSimple()));
    cv.put(DbHelper.COLUMN_PAST_PARTICIPLE , String.valueOf(verb.getPresentPerfect()));
    cv.put(DbHelper.COLUMN_TRANSLATION , String.valueOf(verb.getTranslation()));
    database = dbHelper.getWritableDatabase();
    database.insert(DbHelper.TABLE_VERBS, null, cv);
    return verb;
  }

  public Verb getVerbById(int id)
  {

    return null;
  }

  public void deleteVerb(int id)
  {

  }

  public List<Verb> getAllVerbs()
  {
    database = dbHelper.getReadableDatabase();
    List<Verb> verbList = new ArrayList<Verb>();
    Cursor cursor = database.query(DbHelper.TABLE_VERBS, allColumns, null, null, null, null, null);
    cursor.moveToFirst();
    while(!cursor.isAfterLast())
    {
      Verb verb = cursorToItem(cursor);
      verbList.add(verb);
      cursor.moveToNext();
    }
    cursor.close();
    return verbList;
  }

  private Verb cursorToItem(Cursor cursor)
  {
    Verb verb = new Verb();
    verb.setId(cursor.getInt(0));
    verb.setInfinitive(cursor.getString(1));
    verb.setPastSimple(cursor.getString(2));
    verb.setPresentPerfect(cursor.getString(3));
    verb.setTranslation(cursor.getString(4));
    return verb;
  }
}
