// REDO USING ch.7.1 of 303 TEXTBOOK

public class Type
{
  private Type() {};
  
  public static final Type FOOD = new Type();
  public static final Type HYDRO = new Type();
  public static final Type BELL = new Type();
  public static final Type OTHER = new Type();
  
  public static Type fromInt(int x)
  {
    switch(x)
    {
      case 0:
        return FOOD;
      case 1:
        return HYDRO;
      case 2:
        return BELL;
      case 3:
        return OTHER;
    }
    return null;
  }
  
  public static Type fromString(String x)
  {
    if(x.equals("FOOD"))
    {
      return FOOD;
    }
    else if(x.equals("HYDRO"))
    {
      return HYDRO;
    }
    else if(x.equals("BELL"))
    {
      return BELL;
    }
    else
    {
      return OTHER;
    }
  }
}