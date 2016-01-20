import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class loggedInGUI
{
  public loggedInGUI(Roomie aRoomie)
  {
    final Roomie pRoomie = aRoomie;

    JButton addBill = new JButton("Add a bill");
    JButton accountSummary = new JButton("View account summaries");
    JButton viewBills = new JButton("View previous bills");
    addBill.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        new addBillGUI(pRoomie);
        //close this window
      }
    });
    accountSummary.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        new accountSummaryGUI(pRoomie);
        //close this window
      }
    });
    viewBills.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        new viewBillsGUI(pRoomie);
        //close this window
      }
    });
    
    JPanel optionsPanel = new JPanel();
    optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.X_AXIS));
    optionsPanel.add(addBill);
    optionsPanel.add(accountSummary);
    optionsPanel.add(viewBills);
    
    JFrame frame = new JFrame();
    frame.setTitle("Roomie Finances");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new JLabel("Choose an option:"), BorderLayout.NORTH);
    frame.add(optionsPanel, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
  }
  
}