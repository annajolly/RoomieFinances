public class Date
{
  private int pYear;
  private int pMonth;
  private int pDay;
  
  public Date(int aYear, int aMonth, int aDay)
  {
    this.pYear = aYear;
    this.pMonth = aMonth;
    this.pDay = aDay;
  }
  
  //returns 1 if this. is older
  public int compare(Date aDate)
  {
    int date1 = this.pYear*10000 + this.pMonth*100 + this.pDay;
    int date2 = aDate.getYear()*10000 + aDate.getMonth()*100 + aDate.getDay();
    if(date1<date2)
    {
      return 1;
    }
    else if(date1 == date2)
    {
      return 0;
    }
    else
    {
      return -1;
    }
  }
    
  public int getYear()
  {
    return this.pYear;
  }

  public int getMonth()
  {
    return this.pMonth;
  }
  
  public int getDay()
  {
    return this.pDay;
  }

  public String toString()
  {
    return Integer.toString(pYear) + "-" + Integer.toString(pMonth) + "-" + Integer.toString(pDay);
  }
}