import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class accountSummaryGUI
{
  public accountSummaryGUI(Roomie aRoomie)
  {
    JPanel matrixPanel = new JPanel();
    matrixPanel.setLayout(new GridLayout(5,5));
    //row 0
    matrixPanel.add(new JLabel());
    matrixPanel.add(new JLabel("   Anna    "));
    matrixPanel.add(new JLabel(" Gabrielle "));
    matrixPanel.add(new JLabel("  Illiez   "));
    matrixPanel.add(new JLabel("   Nicky   "));
    //row 1
    matrixPanel.add(new JLabel("   Anna    "));
    matrixPanel.add(new JLabel());
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[0].getStringG()));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[0].getStringI()));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[0].getStringN()));
    //row 2
    matrixPanel.add(new JLabel("   Gabrielle    "));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[1].getStringA()));
    matrixPanel.add(new JLabel());
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[1].getStringI()));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[1].getStringN()));
    //row 3
    matrixPanel.add(new JLabel("   Illiez    "));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[2].getStringA()));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[2].getStringG()));
    matrixPanel.add(new JLabel());
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[2].getStringN()));
    //row 4
    matrixPanel.add(new JLabel("   Nicky    "));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[3].getStringA()));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[3].getStringG()));
    matrixPanel.add(new JLabel(roomieFinances.getRoomies()[3].getStringI()));
    matrixPanel.add(new JLabel());
    
    JPanel reducedPanel = new JPanel();
    if(dAToG <= dGToA)
    {
      dGToA -= dAToG;
      dAToG = 0;
    }
    else
    {
      dAToG -= dGToA;
      dGToA = 0;
    }
    if(dAToI <= dIToA)
    {
      dIToA -= dAToI;
      dAToI = 0;
    }
    else
    {
      dAToI -= dIToA;
      dIToA = 0;
    }
    if(dAToN <= dNToA)
    {
      dNToA -= dAToN;
      dAToN = 0;
    }
    else
    {
      dAToN -= dNToA;
      dNToA = 0;
    }
    if(dIToG <= dGToI)
    {
      dIToA -= dIToG;
      dIToG = 0;
    }
    else
    {
      dIToG -= dGToI;
      dGToI = 0;
    }
    if(dNToG <= dGToN)
    {
      dGToN -= dNToG;
      dNToG = 0;
    }
    else
    {
      dNToG -= dGToN;
      dGToN = 0;
    }
    if(dNToI <= dIToN)
    {
      dIToN -= dNToI;
      dNToI = 0;
    }
    else
    {
      dNToI -= dIToN;
      dIToN = 0;
    }
    reducedPanel.setLayout(new GridLayout(5,5));
    //row 0
    reducedPanel.add(new JLabel());
    reducedPanel.add(new JLabel("   Anna    "));
    reducedPanel.add(new JLabel(" Gabrielle "));
    reducedPanel.add(new JLabel("  Illiez   "));
    reducedPanel.add(new JLabel("   Nicky   "));
    //row 1
    reducedPanel.add(new JLabel("   Anna    "));
    reducedPanel.add(new JLabel());
    reducedPanel.add(new JLabel(String.valueOf(dAToG)));
    reducedPanel.add(new JLabel(String.valueOf(dAToI)));
    reducedPanel.add(new JLabel(String.valueOf(dAToN)));
    //row 2
    reducedPanel.add(new JLabel("   Gabrielle    "));
    reducedPanel.add(new JLabel(String.valueOf(dGToA)));
    reducedPanel.add(new JLabel());
    reducedPanel.add(new JLabel(String.valueOf(dGToI)));
    reducedPanel.add(new JLabel(String.valueOf(dGToN)));
    //row 3
    reducedPanel.add(new JLabel("   Illiez    "));
    reducedPanel.add(new JLabel(String.valueOf(dIToA)));
    reducedPanel.add(new JLabel(String.valueOf(dIToG)));
    reducedPanel.add(new JLabel());
    reducedPanel.add(new JLabel(String.valueOf(dIToN)));
    //row 4
    reducedPanel.add(new JLabel("   Nicky    "));
    reducedPanel.add(new JLabel(String.valueOf(dNToA)));
    reducedPanel.add(new JLabel(String.valueOf(dNToG)));
    reducedPanel.add(new JLabel(String.valueOf(dNToI)));
    reducedPanel.add(new JLabel());
    
    JPanel matrixPanel2 = new JPanel();
    matrixPanel2.setLayout(new BorderLayout());
    matrixPanel2.add(new JLabel("Who owes whom what:"), BorderLayout.NORTH);
    matrixPanel2.add(matrixPanel, BorderLayout.SOUTH);
    
    JPanel reducedPanel2 = new JPanel();
    reducedPanel2.setLayout(new BorderLayout());
    reducedPanel2.add(new JLabel("Reduces to:"), BorderLayout.NORTH);
    reducedPanel2.add(reducedPanel, BorderLayout.SOUTH);
    
    JPanel overviewPanel = new JPanel();
    overviewPanel.setLayout(new BorderLayout());
    overviewPanel.add(matrixPanel2, BorderLayout.NORTH);
    overviewPanel.add(reducedPanel2, BorderLayout.SOUTH);
    
    String[] options = {"Anna", "Gabrielle", "Illiez", "Nicky"};
    JComboBox payer = new JComboBox(options);
    payer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String stType = (String)cb.getSelectedItem();
        payerRoomie = roomieFinances.getRoomieFromString(stType);
      }
    });
    
    JComboBox payee = new JComboBox(options);
    payee.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String stType = (String)cb.getSelectedItem();
        payeeRoomie = roomieFinances.getRoomieFromString(stType);
      }
    });
    
    JPanel amount = new JPanel();
    amount.setLayout(new GridLayout(1,2));
    amount.add(new JLabel("$"));
    amountArea = new JTextArea(1,5);
    amount.add(amountArea);
    
    JPanel form = new JPanel();
    form.setLayout(new FlowLayout());
    form.add(payer);
    form.add(new JLabel("paid"));
    form.add(payee);
    form.add(amount);
    
    JPanel submit = new JPanel();
    submit.setLayout(new FlowLayout());
    JButton submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        //reimbursementAmount = Double.parseDouble(amountArea.getText());
        //t 
        //payeeRoomie.setAmount
        
        
        //new accountSummaryGUI();
      }
    });
    submit.add(submitButton);
    
    JPanel updatePanel = new JPanel();
    updatePanel.setLayout(new BorderLayout());
    updatePanel.add(new JLabel("Reimbursement Form:"), BorderLayout.NORTH);
    updatePanel.add(form, BorderLayout.CENTER);
    updatePanel.add(submit, BorderLayout.SOUTH);
    
    //add scroll bar
    JFrame frame = new JFrame();
    frame.setTitle("Account Summary");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(overviewPanel, BorderLayout.NORTH);
    frame.add(updatePanel, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
  }
  
  private JButton aToG;
  private JButton aToI;
  private JButton aToN;
  
  private double dAToG = roomieFinances.getRoomies()[0].getG();
  private double dAToI = roomieFinances.getRoomies()[0].getI();
  private double dAToN = roomieFinances.getRoomies()[0].getN();
    
  private JButton gToA;
  private JButton gToI;
  private JButton gToN;
  
  private double dGToA = roomieFinances.getRoomies()[1].getA();
  private double dGToI = roomieFinances.getRoomies()[1].getI();
  private double dGToN = roomieFinances.getRoomies()[1].getN();
  
  private JButton iToA;
  private JButton iToG;
  private JButton iToN;
  
  private double dIToA = roomieFinances.getRoomies()[2].getA();
  private double dIToG = roomieFinances.getRoomies()[2].getG();
  private double dIToN = roomieFinances.getRoomies()[2].getN();
  
  private JButton nToA;
  private JButton nToG;
  private JButton nToI;
  
  private double dNToA = roomieFinances.getRoomies()[3].getA();
  private double dNToG = roomieFinances.getRoomies()[3].getG();
  private double dNToI = roomieFinances.getRoomies()[3].getI();
  
  private Roomie payeeRoomie;
  private Roomie payerRoomie;
  private JTextArea amountArea;
  private double reimbursementAmount;
  
}