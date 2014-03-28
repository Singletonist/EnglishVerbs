package com.aloner.service;

import android.content.Context;

import com.aloner.dao.ItemDao;
import com.aloner.object.Item;

import java.util.List;

public class ItemService
{
  ItemDao itemDao;
  public ItemService(Context context)
  {
    this.itemDao = itemDao;
    itemDao = new ItemDao(context);
  }

  public Item createItem(Item item)
  {
    return itemDao.createItem(item);
  }

  public Item getItemById(int id)
  {
    return itemDao.getItemById(id);
  }

  public void deleteItem(int id)
  {
    itemDao.deleteItem(id);
  }

  public List<Item> getAllItems()
  {
    return itemDao.getAllItems();
  }
}
