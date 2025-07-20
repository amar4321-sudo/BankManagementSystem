package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
        JLabel text,cardno,pin;
        JTextField cardtextfield;
        JPasswordField pintextfield;
        JButton login,clear,signup;
        Login()
        {
            setLayout(null);
            setTitle("AUTOMATED TEILER MACHINE");
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
            Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT );
            ImageIcon i3=new ImageIcon(i2);
            JLabel label1=new JLabel(i3);
           
            label1.setBounds(70,10,100,100);
            add(label1);
            
            text=new JLabel("Welcome To ATM");
            text.setFont(new Font("Osward",Font.BOLD,38));
            text.setBounds(200,40,400,40);
            add(text);
            
            cardno=new JLabel("Card No:");
            cardno.setFont(new Font("Raleway",Font.BOLD,28));
            cardno.setBounds(120,150,150,30);
            add(cardno);
            
            cardtextfield=new JTextField();
            cardtextfield.setBounds(270,155,250,30);
            cardtextfield.setFont(new Font("Arial",Font.BOLD,14));
            add(cardtextfield);
            
            pin=new JLabel("PIN:");
            pin.setFont(new Font("Raleway",Font.BOLD,28));
            pin.setBounds(120,250,250,40);
            add(pin);
            
            pintextfield=new JPasswordField();
            pintextfield.setBounds(270,250,250,30);
            cardtextfield.setFont(new Font("Arial",Font.BOLD,14));
            add(pintextfield);
            
            login=new JButton("Sign In");
            login.setBounds(270,300,100,30);
            login.setBackground(Color.BLACK);
            login.addActionListener(this);
            login.setForeground(Color.white);
            add(login);
            
            clear=new JButton("Clear");
            clear.setBounds(420,300,100,30);
            clear.addActionListener(this);
            clear.setBackground(Color.BLACK);
            clear.setForeground(Color.white);
            add(clear);
            
            signup=new JButton("Sign Up");
            signup.setBounds(270,350,250,30);
            signup.addActionListener(this);
            signup.setBackground(Color.BLACK);
            signup.setForeground(Color.white);
            add(signup);
            
            getContentPane().setBackground(Color.WHITE);
            
            setSize(800,480);
            setVisible(true);
            setLocation(350,200);
        }
         public void actionPerformed(ActionEvent ae)
         {
             if(ae.getSource()==login){
                 {
                 Conn conn=new Conn();
                 String cardnumber=cardtextfield.getText();
                 String pinnumber=pintextfield.getText();
                 String query = "SELECT * FROM login WHERE cardnumber='" + cardnumber + "' AND pinnumber='" + pinnumber + "'";

                 try{
                     ResultSet rs=conn.s.executeQuery(query);
                     if(rs.next()){
                         setVisible(false);
                         new Transaction(pinnumber).setVisible(true);
                     }else{
                         JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin number");
                     }
                 }catch(Exception e){
                     System.out.println(e);
                 }
             }
             }
             else if(ae.getSource()==clear){
                 cardtextfield.setText("");
                 pintextfield.setText("");
             }
             else if(ae.getSource()==signup){
                 setVisible(false);
               new  Signupone().setVisible(true);
             }
                 
         }
        public static void main(String[] args) 
       {
          Login l= new Login();
       }
}