import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class loginGUI
{
  public loginGUI()
  {
    final JTextArea nameArea = new JTextArea(1,25);
    
    JPanel submitPanel = new JPanel();
    submitPanel.setLayout(new FlowLayout());
    JButton submitButton = new JButton("Submit");
    
    submitPanel.add(submitButton);
    
    JFrame frame = new JFrame();
    frame.setTitle("Sign in");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new JLabel("Enter your first name:"), BorderLayout.NORTH);
    frame.add(nameArea, BorderLayout.CENTER);
    frame.add(submitPanel, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
    
    ActionListener submit = new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        if (validateName(nameArea.getText()) == true)
        {
          new loggedInGUI(curRoomie);
          //close this window
          //frame.close();
        }
        else
        {
          nameArea.setText("Invalid. Try again.");
        }
      }
    };
    
    submitButton.addActionListener(submit);
  }
  
  public boolean validateName(String name)
  {
    for (int i=0; i<roomieFinances.getRoomies().length; i++)
    {
      if (roomieFinances.getRoomies()[i].getName().equals(name))
      {
        curRoomie = roomieFinances.getRoomies()[i];
        return true;
      }
    }
    return false;
  }
  
  private Roomie curRoomie;
}