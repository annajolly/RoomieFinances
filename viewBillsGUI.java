import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class viewBillsGUI
{
  public viewBillsGUI(Roomie aRoomie)
  {
    final Roomie roomie = aRoomie;
    JPanel back = new JPanel();
    back.setLayout(new FlowLayout());
    JButton backButton = new JButton("Back to menu");
    back.add(backButton);
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        new loggedInGUI(roomie);
      }
    });
    
    int size = roomieFinances.getBills().size();
    JPanel billsPanel = new JPanel();
    billsPanel.setLayout(new GridLayout(size+1,1));
    billsPanel.add(new JLabel("Billing Roommate, Date, Type, Amount, Billed Roommates"));
    for(Bill bill : roomieFinances.getBills())
    {
      billsPanel.add(new JLabel(bill.toString()));
    }
    
    //add scroll bar
    JFrame frame = new JFrame();
    frame.setTitle("View Bills");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(back, BorderLayout.NORTH);
    frame.add(billsPanel, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
  }
}