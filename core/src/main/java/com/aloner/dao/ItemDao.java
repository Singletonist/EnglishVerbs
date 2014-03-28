package com.aloner.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.aloner.object.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDao
{
  private static final String LOG_TAG = "myLog";
  private SQLiteDatabase database;
  private DbHelper dbHelper;
  private String[] allColumns =
      {
          DbHelper.COLUMN_ID,
          DbHelper.COLUMN_PRESENT_SIMPLE,
          DbHelper.COLUMN_PAST_SIMPLE,
          DbHelper.COLUMN_PRESENT_PERFECT,
          DbHelper.COLUMN_TRANSLATION
      };
  SQLiteDatabase db;

  public ItemDao(Context context)
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

  public Item createItem(Item item)
  {
    ContentValues cv = new ContentValues();
    cv.put(DbHelper.COLUMN_PRESENT_SIMPLE , item.getPresentSimple());
    cv.put(DbHelper.COLUMN_PAST_SIMPLE, String.valueOf(item.getPastSimple()));
    cv.put(DbHelper.COLUMN_PRESENT_PERFECT , String.valueOf(item.getPresentPerfect()));
    cv.put(DbHelper.COLUMN_TRANSLATION , String.valueOf(item.getTranslation()));
    db = dbHelper.getWritableDatabase();
    long rowID = db.insert(DbHelper.TABLE_ITEMS, null, cv);
    return item;
  }

  public Item getItemById(int id)
  {

    return null;
  }

  public void deleteItem(int id)
  {

  }

  public List<Item> getAllItems()
  {
    db = dbHelper.getReadableDatabase();
    List<Item> itemList = new ArrayList<Item>();
    Cursor cursor = db.query(DbHelper.TABLE_ITEMS, allColumns, null, null, null, null, null);
    cursor.moveToFirst();
    while(!cursor.isAfterLast())
    {
      Item item = cursorToItem(cursor);
      itemList.add(item);
      cursor.moveToNext();
    }
    cursor.close();
    return itemList;
  }

  private Item cursorToItem(Cursor cursor)
  {
    Item item = new Item();
    item.setId(cursor.getInt(0));
    item.setPresentSimple(cursor.getString(1));
    item.setPastSimple(cursor.getString(2));
    item.setPresentPerfect(cursor.getString(3));
    item.setTranslation(cursor.getString(4));
    return item;
  }
}
