package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1;
    MiniStatement(String pinnumber){
        setLayout(null);
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
        JLabel l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        add(l1);
        
        JLabel l2 = new JLabel("Union Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where PinNumber = '"+pinnumber+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("CardNo").substring(0, 4) + "XXXXXXXX" + rs.getString("CardNo").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            System.out.println(e);
        }
        
        b1 = new JButton("Exit");
        b1.addActionListener(this);
        b1.setBounds(20, 500, 100, 25);
        add(b1);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}