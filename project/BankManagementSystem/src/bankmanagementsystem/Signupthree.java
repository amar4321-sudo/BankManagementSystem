package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Signupthree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signupthree(String formno) {
        this.formno = formno;
        setTitle("Signup - Page 3");
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setFont(new Font("Raleway", Font.BOLD, 16));

        r1.setBackground(Color.WHITE);
        r2.setBackground(Color.WHITE);
        r3.setBackground(Color.WHITE);
        r4.setBackground(Color.WHITE);

        r1.setBounds(100, 180, 200, 20);
        r2.setBounds(350, 180, 250, 20);
        r3.setBounds(100, 220, 250, 20);
        r4.setBounds(350, 220, 250, 20);

        add(r1);
        add(r2);
        add(r3);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-3421");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 250, 30);
        add(number);

        JLabel carddetails = new JLabel("Your 16-digit Card No");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 330, 250, 20);
        add(carddetails);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 200, 30);
        add(pnumber);

        JLabel pindetails = new JLabel("Your 4-digit Password");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 400, 300, 20);
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 250, 22);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("Email & SMS Alerts");
        c5 = new JCheckBox("Check Book");
        c6 = new JCheckBox("E Statement");
        c7 = new JCheckBox("I hereby declare that the above-entered details are correct.");

        JCheckBox[] checkBoxes = {c1, c2, c3, c4, c5, c6, c7};
        int yPos = 500;
        for (JCheckBox c : checkBoxes) {
            c.setBackground(Color.WHITE);
            c.setFont(new Font("Raleway", Font.BOLD, 16));
            c.setBounds(100, yPos, 500, 30);
            add(c);
            yPos += 50;
        }

        submit = new JButton("Submit");
        cancel = new JButton("Cancel");

        submit.setBackground(Color.BLACK);
        cancel.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        cancel.setForeground(Color.WHITE);

        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));

        submit.setBounds(250, 720, 100, 30);
        cancel.setBounds(420, 720, 100, 30);

        submit.addActionListener(this);
        cancel.addActionListener(this);

        add(submit);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==submit)
        {
            String accountType=null;
            if(r1.isSelected())
            {
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="Recurring Deposit Account";
            }
            Random rand=new Random();
            String cardnumber=""+ Math.abs((rand.nextLong()%90000000L)+ 6709062000000000L);
            String pinnumber=""+Math.abs((rand.nextLong()%9000L)+1000L);
            
            String facility="";
            if(c1.isSelected())
            {
                facility=facility+" ATM Card";
            }else if(c2.isSelected())
            {
                facility=facility+" Internet Banking";
            }else if(c3.isSelected())
            {
                facility=facility+" Mobile Banking";
            }else if(c4.isSelected())
            {
                facility=facility+" EMAIL & SMS Alerts";
            }else if(c5.isSelected())
            {
                facility=facility+" Cheqe Book";
            }else if(c6.isSelected())
            {
                facility=facility+" E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type Required");
                }
                 
                    else{
                     Conn c=new Conn();
                     String q1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                     String q2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                     c.s.executeUpdate(q1);
                     c.s.executeUpdate(q2);
                     
                     JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\n PIN number:"+pinnumber);
                     setVisible(false);
                     new Transaction(pinnumber).setVisible(true);
                }
                
            } catch(Exception e)
            {
                System.out.println(e);
            }
            
        }else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signupthree("");
    }
}
