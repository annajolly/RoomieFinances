import java.io.*;
import java.util.LinkedList;
import java.util.Collections;

public class roomieFinances
{
  private static Roomie[] roomies;
  private static LinkedList<Bill> bills;
  
  public static void main(String[] args)
  {
    roomies = loadRoomies();
    bills = loadBills();
    Collections.sort(bills);
    new loginGUI();
  }
  
  public static Roomie[] loadRoomies()
  {
    try
    {
      BufferedReader br = new BufferedReader(new FileReader("roomies.csv"));
      Roomie[] roomies = new Roomie[4];
      String currentLine = br.readLine();
      String[] currentLineSplit;
      for(int i=0; i<4; i++)
      {
        currentLineSplit = currentLine.split(",");
        double aToAnna = Double.parseDouble(currentLineSplit[1]);
        double aToGabrielle = Double.parseDouble(currentLineSplit[2]);
        double aToIlliez = Double.parseDouble(currentLineSplit[3]);
        double aToNicky = Double.parseDouble(currentLineSplit[4]);
        Roomie roomie = new Roomie(currentLineSplit[0], aToAnna, aToGabrielle, aToIlliez, aToNicky);
        roomies[i]=roomie;
        currentLine = br.readLine();
      }
      br.close();
      return roomies;
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File not found.");
    }
    catch(Exception exc)
    {
      System.out.println(exc);
    }
    return null;
  }
  
  public static LinkedList<Bill> loadBills()
  {
    try
    {
      BufferedReader br = new BufferedReader(new FileReader("bills.csv"));
      bills = new LinkedList<Bill>();
      LinkedList<Roomie> roomiesToBill = new LinkedList<Roomie>();
      String currentLine = br.readLine();
      String[] currentLineSplit;
      String[] dateSplit;
      String[] namesSplit;
      while( currentLine != null)
      {
        roomiesToBill.clear();
        currentLineSplit = currentLine.split(",");
        dateSplit = currentLineSplit[1].split("-");
        Date date = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
        Type type = Type.fromString(currentLineSplit[2]);
        double amount = Double.parseDouble(currentLineSplit[3]);
        namesSplit = currentLineSplit[4].split(" ");
        Roomie billingRoomie = new Roomie("fuckDaCompiler");
        for(int i=0; i<4; i++)
        {
          for(int j=0; j<namesSplit.length; j++)
          {
            if(namesSplit[j].equals(roomies[i].getName()))
            {
              roomiesToBill.add(roomies[i]);
            }
          }
          if(currentLineSplit[0].equals(roomies[i].getName()))
          {
            billingRoomie = roomies[i];
          }
        }
        Bill bill = new Bill(billingRoomie, date, type, amount, roomiesToBill);
        bills.add(bill);
        currentLine = br.readLine();
      }
      return bills;
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File not found.");
    }
    catch(Exception exc)
    {
      System.out.println(exc);
    }
    return null;
  }
  
  public static void addBill(Bill aBill)
  {
    int size = aBill.getRoomiesToBill().size();
    double charge = aBill.getAmount() / size;
    for(Roomie roomie : aBill.getRoomiesToBill())
    {
      roomie.chargeRoomie(aBill.getRoomie(), charge);
    }
    bills.add(aBill);
    try
    {
      BufferedWriter bw = new BufferedWriter(new FileWriter("bills.csv"));
      BufferedWriter bw2 = new BufferedWriter(new FileWriter("roomies.csv"));
      for(Bill bill : bills)
      {
        bw.write(bill.toStringIO() + "\n");
      }
      for(Roomie roomie : roomies)
      {
        bw2.write(roomie.toStringIO() + "\n");
      }
      bw.close();
      bw2.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    Collections.sort(bills);
  }
  
  public static Roomie[] getRoomies()
  {
    return roomies.clone();
  }
  
  public static LinkedList<Bill> getBills()
  {
    //clone() returns Object, not LinkedList<Bill>
    return bills;
  }
  
  public static Roomie getRoomieFromString(String aRoomieStr)
  {
    for(Roomie roomie : roomies)
    {
      if(roomie.getName().equals(aRoomieStr))
      {
        return roomie;
      }
    }
    return null;
  }
}