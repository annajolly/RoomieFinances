public class Roomie
{
  private String pName;
  private double pToAnna;
  private double pToGabrielle;
  private double pToIlliez;
  private double pToNicky;
  
  public Roomie(String aName)
  {
    this.pName = aName;
    this.pToAnna = 0;
    this.pToGabrielle = 0;
    this.pToIlliez = 0;
    this.pToNicky = 0;
  }
  
  public Roomie(String aName, double aToAnna, double aToGabrielle, double aToIlliez, double aToNicky)
  {
    this.pName = aName;
    this.pToAnna = aToAnna;
    this.pToGabrielle = aToGabrielle;
    this.pToIlliez = aToIlliez;
    this.pToNicky = aToNicky;
  }
  
  public void chargeRoomie(Roomie aRoomie, double aCharge)
  {
    if(aRoomie.getName().equals("Anna"))
    {
      pToAnna += aCharge;
    }
    else if(aRoomie.getName().equals("Gabrielle"))
    {
      pToGabrielle += aCharge;
    }
    else if(aRoomie.getName().equals("Illiez"))
    {
      pToIlliez += aCharge;
    }
    else if(aRoomie.getName().equals("Nicky"))
    {
      pToNicky += aCharge;
    }
  }
  
  public String getName()
  {
    return pName;
  }
  
  public String getStringA()
  {
    return String.valueOf(this.pToAnna);
  }
  
  public String getStringG()
  {
    return String.valueOf(this.pToGabrielle);
  }
  
  public String getStringI()
  {
    return String.valueOf(this.pToIlliez);
  }
  
  public String getStringN()
  {
    return String.valueOf(this.pToNicky);
  }
  
  public double getA()
  {
    return this.pToAnna;
  }
  
  public double getG()
  {
    return this.pToGabrielle;
  }
  
  public double getI()
  {
    return this.pToIlliez;
  }
  
  public double getN()
  {
    return this.pToNicky;
  }
  
  public String toString()
  {
    return pName + " " + Double.toString(pToAnna) + " " + Double.toString(pToGabrielle) + " " + Double.toString(pToIlliez) + " " + Double.toString(pToNicky);
  }
  
  public String toStringIO()
  {
    return pName + "," + Double.toString(pToAnna) + "," + Double.toString(pToGabrielle) + "," + Double.toString(pToIlliez) + "," + Double.toString(pToNicky);
  }
}