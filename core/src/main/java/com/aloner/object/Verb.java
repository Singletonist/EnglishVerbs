package com.aloner.object;

public class Verb
{
  private int id;
  private String infinitive;
  private String pastSimple;
  private String pastParticiple;
  private String translation;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getInfinitive()
  {
    return infinitive;
  }

  public void setInfinitive(String infinitive)
  {
    this.infinitive = infinitive;
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
    return pastParticiple;
  }

  public void setPresentPerfect(String pastParticiple)
  {
    this.pastParticiple = pastParticiple;
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
