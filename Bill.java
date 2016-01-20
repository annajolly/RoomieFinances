import java.util.*;

public class Bill implements Comparable<Bill>
{
  private Roomie pRoomie;
  private Date pDate;
  private Type pBillType;
  private double pAmount;
  private LinkedList<Roomie> pRoomiesToBill;
  
  public Bill(Roomie aRoomie, Date aDate, Type aBillType, double aAmount, LinkedList<Roomie> aRoomiesToBill)
  {
    this.pRoomie = aRoomie;
    this.pDate = aDate;
    this.pBillType = aBillType;
    this.pAmount = aAmount;
    this.pRoomiesToBill = aRoomiesToBill;
  }
  
  public Roomie getRoomie()
  {
    return this.pRoomie;
  }
  
  public Date getDate()
  {
    return this.pDate;
  }
  
  public double getAmount()
  {
    return this.pAmount;
  }
  
  public LinkedList<Roomie> getRoomiesToBill()
  {
    return this.pRoomiesToBill;
  }
  
  @Override
  public int compareTo(Bill other)
  {
    return this.pDate.compare(other.getDate());
  }
  
  public String toString()
  {
    String roomiesToBill = "";
    for(Roomie roomie : pRoomiesToBill)
    {
      roomiesToBill = roomiesToBill + " " + roomie.getName();
    }
    return pRoomie.getName() + "    " + pDate.toString() + "    " + pBillType + "    $" + Double.toString(pAmount) + "    " + roomiesToBill;
  }
  
  public String toStringIO()
  {
    String roomiesToBill = "";
    for(Roomie roomie : pRoomiesToBill)
    {
      roomiesToBill = roomiesToBill + " " + roomie.getName();
    }
    return pRoomie.getName() + "," + pDate.toString() + "," + pBillType + "," + Double.toString(pAmount) + "," + roomiesToBill;
  }
}