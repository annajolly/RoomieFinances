import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class addBillGUI
{
  public addBillGUI(Roomie aRoomie)
  {
    final Roomie roomie = aRoomie;
    
    JPanel date = new JPanel();
    date.setLayout(new GridLayout(2,1));
    date.add(new JLabel("Date (YYYY-MM-DD)"));
    JPanel amountSubPanel2 = new JPanel();
    amountSubPanel2.setLayout(new FlowLayout());
    amountSubPanel2.add(new JLabel(" "));
    dateArea = new JTextArea(1,10);
    amountSubPanel2.add(dateArea);
    date.add(amountSubPanel2);
    
    JPanel type = new JPanel();
    type.setLayout(new GridLayout(2,1));
    type.add(new JLabel("Type"));
    JPanel amountSubPanel3 = new JPanel();
    amountSubPanel3.setLayout(new FlowLayout());
    amountSubPanel3.add(new JLabel(" "));
    String[] options = {"Food", "Hydro", "Bell", "Other"};
    JComboBox option = new JComboBox(options);
    option.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String stType = (String)cb.getSelectedItem();
        if(stType.equals("Food"))
        {
          billType = Type.fromInt(0);
        }
        else if(stType.equals("Hydro"))
        {
          billType = Type.fromInt(1);
        }
        else if(stType.equals("Bell"))
        {
          billType = Type.fromInt(2);
        }
        else
        {
          billType = Type.fromInt(3);
        }
      }
    });
    option.setSelectedIndex(0);
    amountSubPanel3.add(option);
    type.add(amountSubPanel3);
    
    JPanel amount = new JPanel();
    amount.setLayout(new GridLayout(2,1));
    amount.add(new JLabel("Amount"));
    JPanel amountSubPanel = new JPanel();
    amountSubPanel.setLayout(new FlowLayout());
    amountSubPanel.add(new JLabel("  S"));
    amountArea = new JTextArea(1,5);
    amountSubPanel.add(amountArea);
    amount.add(amountSubPanel);

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(1,3));
    inputPanel.add(date);
    inputPanel.add(type);
    inputPanel.add(amount);          
    Border b = new EtchedBorder();
    inputPanel.setBorder(b);
                        
                        
    annaButton = new JCheckBox("Anna");
    annaButton.setSelected(true);
    annaButton.setEnabled(false);

    gabrielleButton = new JCheckBox("Gabrielle"); 
    gabrielleButton.setSelected(true);
    gabrielleButton.setEnabled(false);

    illiezButton = new JCheckBox("Illliez");
    illiezButton.setSelected(true);
    illiezButton.setEnabled(false);

    nickyButton = new JCheckBox("Nicky");
    nickyButton.setSelected(true);
    nickyButton.setEnabled(false);
      
    JPanel checks = new JPanel();
    checks.setLayout(new GridLayout(1,4));
    checks.add(annaButton);
    checks.add(gabrielleButton);
    checks.add(illiezButton);
    checks.add(nickyButton);
    
    allButton = new JRadioButton("All");
    allButton.setSelected(true);

    someButton = new JRadioButton("Some");
    someButton.setSelected(false);
    
    ButtonGroup choose = new ButtonGroup();
    choose.add(allButton);
    choose.add(someButton);
    
    JPanel chooseOne = new JPanel();
    chooseOne.setLayout(new FlowLayout());
    chooseOne.add(allButton);
    chooseOne.add(someButton);
    
    allButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          annaButton.setEnabled(false);
          gabrielleButton.setEnabled(false);
          illiezButton.setEnabled(false);
          nickyButton.setEnabled(false);
      }
    });

    someButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          annaButton.setEnabled(true);
          gabrielleButton.setEnabled(true);
          illiezButton.setEnabled(true);
          nickyButton.setEnabled(true);
      }
    });
    
    JPanel billTo = new JPanel();
    billTo.setLayout(new GridLayout(3,1));
    billTo.add(new JLabel("Bill to:"));
    billTo.add(chooseOne);
    billTo.add(checks);
    Border bo = new EtchedBorder();
    billTo.setBorder(bo);
    
    JPanel addForm = new JPanel();
    addForm.setLayout(new GridLayout(2,1));
    addForm.add(inputPanel);
    addForm.add(billTo);
      
    JPanel submitPanel = new JPanel();
    submitPanel.setLayout(new FlowLayout());
    JButton submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        String[] dateSplit = dateArea.getText().split("-");
        billDate = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
        billAmount = Double.parseDouble(amountArea.getText());
        if(someButton.isSelected())
        {
          if(annaButton.isSelected())
          {
            namesToBill.add("Anna");
          }
          if(gabrielleButton.isSelected())
          {
            namesToBill.add("Gabrielle");
          }
          if(illiezButton.isSelected())
          {
            namesToBill.add("Illiez");
          }
          if(nickyButton.isSelected())
          {
            namesToBill.add("Nicky");
          }
        }
        else
        {
          namesToBill.add("Anna");
          namesToBill.add("Gabrielle");
          namesToBill.add("Illiez");
          namesToBill.add("Nicky");
        }
        makeList();
        billToSubmit = new Bill(roomie, billDate, billType, billAmount, billToWhom);
        roomieFinances.addBill(billToSubmit);
        new loggedInGUI(roomie);
      }
    });
    submitPanel.add(submitButton);
    
    //add scroll bar
    JFrame frame = new JFrame();
    frame.setTitle("Add a bill");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.add(new JLabel("Add a bill:"), BorderLayout.NORTH);
    frame.add(addForm, BorderLayout.CENTER);
    frame.add(submitPanel, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
  }
  
  public void makeList()
  {
    for(String name : namesToBill)
    {
      for(Roomie roomie : roomieFinances.getRoomies())
      {
        if(name.equals(roomie.getName()))
        {
          billToWhom.add(roomie);
        }
      }
    }
  }

  private Bill billToSubmit;
  private LinkedList<Roomie> billToWhom = new LinkedList<Roomie>();
  private Date billDate;
  private Type billType;
  private double billAmount;
  private JTextArea dateArea;
  private JTextArea amountArea;
  private JCheckBox annaButton;
  private JCheckBox gabrielleButton;
  private JCheckBox illiezButton;
  private JCheckBox nickyButton;
  private JRadioButton allButton;
  private JRadioButton someButton;
  private LinkedList<String> namesToBill = new LinkedList<String>();
  
}