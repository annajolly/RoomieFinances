class Entry
{
  public static final String GROCERIES = "Groceries";
  public static final String HYDRO = "Hydro";
  public static final String INTERNET = "Internet";
  public static final String OTHER = "Other";
  
  public enum Category
  {GROCERIES, HYDRO, INTERNET, OTHER};
  
  private String aUser;
  private Category aCategory;
  private double aAmount;
  
  public Entry( String pUser, Category pCategory, double pAmount)
  {
    this.aUser = pUser;
    this.aCategory = pCategory;
    this.aAmount = pAmount;
  }
}