package com.aloner.object;

public class Verb
{
  private int id;
  private String presentSimple;
  private String pastSimple;
  private String presentPerfect;
  private String translation;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getPresentSimple()
  {
    return presentSimple;
  }

  public void setPresentSimple(String presentSimple)
  {
    this.presentSimple = presentSimple;
  }

  public String getPastSimple()
  {
    return pastSimple;
  }

  public void setPastSimple(String pastSimple)
  {
    this.pastSimple = pastSimple;
  }

  public String getPresentPerfect()
  {
    return presentPerfect;
  }

  public void setPresentPerfect(String presentPerfect)
  {
    this.presentPerfect = presentPerfect;
  }

  public String getTranslation()
  {
    return translation;
  }

  public void setTranslation(String translation)
  {
    this.translation = translation;
  }


}
