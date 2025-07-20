package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener{
    JTextField nametextfield,fatnametextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,pintextfield;
    long rnd;
    JButton next;
    JRadioButton married,unmarried,other,male,female;
    JDateChooser jdc;
    Signupone(){
        
        setLayout(null);
        setTitle("Page 1");
    
        getContentPane().setBackground(Color.WHITE);
    
        Random r=new Random();
        rnd=Math.abs(r.nextLong()%9000L+1000L);
        
        JLabel formno=new JLabel("Application Form No"+rnd);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(180,20,600,40);
        add(formno);
        
        JLabel personalDetails=new JLabel("Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(280,80,600,25);
        add(personalDetails);
        
        JLabel page=new JLabel("1");
        page.setFont(new Font("Raleway",Font.BOLD,22));
        page.setBounds(400,700,600,25);
        add(page);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,150,300,30);
        add(name);
        
        nametextfield=new JTextField();
        nametextfield.setFont(new Font("Raleway",Font.BOLD,15));
        nametextfield.setBounds(300,150,300,30);
        add(nametextfield);
        
        JLabel fatname=new JLabel("Father's Name:");
        fatname.setFont(new Font("Raleway",Font.BOLD,22));
        fatname.setBounds(100,200,300,30);
        add(fatname);
        
        fatnametextfield=new JTextField();
        fatnametextfield.setFont(new Font("Raleway",Font.BOLD,15));
        fatnametextfield.setBounds(300,200,300,30);
        add(fatnametextfield);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,250,300,30);
        add(dob);
        
        jdc=new JDateChooser();
        jdc.setBounds(300,250,300,30);
        jdc.setForeground(new Color(105,105,105));
        add(jdc);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,300,300,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,300,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(370,300,120,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,350,300,30);
        add(email);
        
        emailtextfield=new JTextField();
        emailtextfield.setFont(new Font("Raleway",Font.BOLD,15));
        emailtextfield.setBounds(300,350,300,30);
        add(emailtextfield);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,400,300,30);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBounds(300,400,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400,400,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(500,400,100,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup maritalbg=new ButtonGroup();
        maritalbg.add(married);
        maritalbg.add(unmarried);
        maritalbg.add(other);
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,450,300,30);
        add(address);
        
        addresstextfield=new JTextField();
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,15));
        addresstextfield.setBounds(300,450,300,30);
        add(addresstextfield);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,500,300,30);
        add(city);
        
        citytextfield=new JTextField();
        citytextfield.setFont(new Font("Raleway",Font.BOLD,15));
        citytextfield.setBounds(300,500,300,30);
        add(citytextfield);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,550,300,30);
        add(state);
        
        statetextfield=new JTextField();
        statetextfield.setFont(new Font("Raleway",Font.BOLD,15));
        statetextfield.setBounds(300,550,300,30);
        add(statetextfield);
        
        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,600,300,30);
        add(pin);
        
        pintextfield=new JTextField();
        pintextfield.setFont(new Font("Raleway",Font.BOLD,15));
        pintextfield.setBounds(300,600,300,30);
        add(pintextfield);
        
        next=new JButton("Next");
        next.setBounds(500,640,100,30);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
    
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
}
      public void actionPerformed(ActionEvent ae){
          String formno=""+rnd;
          String name=nametextfield.getText();
          String fatname=fatnametextfield.getText();
          String dob=((JTextField)jdc.getDateEditor().getUiComponent()).getText();
          String gender=null;
          if(male.isSelected()){
              gender="Male";
          }else if(female.isSelected()){
              gender="Female";
          }
          String email=emailtextfield.getText();
          String marital=null;
          if(married.isSelected()){
              marital="Married";
          }else if(unmarried.isSelected()){
              marital="Unmarried";
          }else if(other.isSelected()){
              marital="Other";
          }
          String address=addresstextfield.getText();
          String state=statetextfield.getText();
          String city=citytextfield.getText();
          String pin=pintextfield.getText();
          
          try{
              if(name.equals("")){
                  JOptionPane.showMessageDialog(null,"Please Enter your Name");
              }else if(fatname.equals("")){
                     JOptionPane.showMessageDialog(null,"Please Enter your Father's Name");
              }else if(dob.equals("")){
                     JOptionPane.showMessageDialog(null,"Please Enter your Date Of Birth");
              }else if(gender.equals("")){
                     JOptionPane.showMessageDialog(null,"Choose your Gender");
              }else if(email.equals("")){
                     JOptionPane.showMessageDialog(null,"Please Enter your Email");
              }else if(address.equals("")){
                     JOptionPane.showMessageDialog(null,"Please Enter your Address");
              }else if(city.equals("")){
                     JOptionPane.showMessageDialog(null,"Please Enter your City");
              }else if(state.equals("")){
                     JOptionPane.showMessageDialog(null,"Please Enter your State");
              }else if(pin.equals("")){
                     JOptionPane.showMessageDialog(null,"Please Enter your Pin Code");
              }else{
                  Conn c=new Conn();
                  String query="insert into signup values('"+formno+"','"+name+"','"+fatname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                  c.s.executeUpdate(query);
                  
                  setVisible(false);
                 new Signuptwo(formno).setVisible(true);
              }
          }catch(Exception e){
              System.out.println(e);
          }
      }  

public static void main(String args[])
{
    new Signupone();
}
}