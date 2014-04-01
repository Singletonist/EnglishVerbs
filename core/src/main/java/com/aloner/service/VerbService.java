package com.aloner.service;

import android.content.Context;

import com.aloner.dao.VerbDao;
import com.aloner.object.Verb;

import java.util.List;

public class VerbService
{
  VerbDao verbDao;
  public VerbService(Context context)
  {
    verbDao = new VerbDao(context);
  }

  public Verb createVerb(Verb verb)
  {
    return verbDao.createVerb(verb);
  }

  public Verb getVerbById(int id)
  {
    return verbDao.getVerbById(id);
  }

  public void deleteVerb(int id)
  {
    verbDao.deleteVerb(id);
  }

  public List<Verb> getAllVerbs()
  {
    return verbDao.getAllVerbs();
  }
}
