package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Signuptwo extends JFrame implements ActionListener{
    JTextField pan,addhar;
    JButton next;
    JRadioButton eay,ean,sy,sn;
    JComboBox religion,category,income,education,occupation;
    String formno;
    Signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM-Page 2");
    
        getContentPane().setBackground(Color.WHITE);
    
        JLabel additionaldetails=new JLabel("Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(280,80,600,25);
        add(additionaldetails);
        
        JLabel page=new JLabel("2");
        page.setFont(new Font("Raleway",Font.BOLD,22));
        page.setBounds(400,700,600,25);
        add(page);
        
        JLabel r=new JLabel("Religion:");
        r.setFont(new Font("Raleway",Font.BOLD,22));
        r.setBounds(100,150,300,30);
        add(r);
        
        String valueOfReligion[]={"Hindu","Muslim","Cristian","Sikh","Other"};
        religion=new JComboBox(valueOfReligion);
        religion.setBounds(300,150,300,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel c=new JLabel("Category:");
        c.setFont(new Font("Raleway",Font.BOLD,22));
        c.setBounds(100,200,300,30);
        add(c);
        
        String Valcategory[]={"General","OBC","ST","SC","Other"};
        category=new JComboBox(Valcategory);     
        category.setBounds(300,200,300,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel i=new JLabel("Income:");
        i.setFont(new Font("Raleway",Font.BOLD,22));
        i.setBounds(100,250,300,30);
        add(i);
        
        String valincome[]={"Null","<1,50,000","2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(valincome) ;
        income.setBounds(300,250,300,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel e=new JLabel("Educational:");
        e.setFont(new Font("Raleway",Font.BOLD,22));
        e.setBounds(100,300,300,30);
        add(e);
        
        
        JLabel q=new JLabel("Qualificational:");
        q.setFont(new Font("Raleway",Font.BOLD,22));
        q.setBounds(100,325,300,30);
        add(q);
        
        String valeducation[]={"Under-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
        education=new JComboBox(valeducation) ;
        education.setBounds(300,325,300,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel o=new JLabel("Occupation:");
        o.setFont(new Font("Raleway",Font.BOLD,22));
        o.setBounds(100,400,300,30);
        add(o);
        
        String valoccupation[]={"Salaried","self-Employed","Student","Bussinessman","Retired","Others"};
        occupation=new JComboBox(valoccupation) ;
        occupation.setBounds(300,400,300,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel p=new JLabel("Pan Number:");
        p.setFont(new Font("Raleway",Font.BOLD,22));
        p.setBounds(100,450,300,30);
        add(p);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(300,450,300,30);
        add(pan);
        
        JLabel ad=new JLabel("Addhar Number:");
        ad.setFont(new Font("Raleway",Font.BOLD,22));
        ad.setBounds(100,500,300,30);
        add(ad);
        
        addhar=new JTextField();
        addhar.setFont(new Font("Raleway",Font.BOLD,15));
        addhar.setBounds(300,500,300,30);
        add(addhar);
        
        JLabel sc=new JLabel("Senior Citizen:");
        sc.setFont(new Font("Raleway",Font.BOLD,22));
        sc.setBounds(100,550,300,30);
        add(sc);
        
        sy=new JRadioButton("YES");
        sy.setBounds(300,550,100,30);
        sy.setBackground(Color.white);
        add(sy);
        
        sn=new JRadioButton("NO");
        sn.setBounds(400,550,100,30);
        sn.setBackground(Color.white);
        add(sn);
       
        ButtonGroup SC=new ButtonGroup();
        SC.add(sy);
        SC.add(sn);
        
        JLabel EA=new JLabel("Exsisting Account:");
        EA.setFont(new Font("Raleway",Font.BOLD,22));
        EA.setBounds(100,600,300,30);
        add(EA);
        
        eay=new JRadioButton("YES");
        eay.setBounds(300,600,100,30);
        eay.setBackground(Color.white);
        add(eay);
        
        ean=new JRadioButton("NO");
        ean.setBounds(400,600,100,30);
        ean.setBackground(Color.white);
        add(ean);
       
        ButtonGroup ea=new ButtonGroup();
        ea.add(eay);
        ea.add(ean);
        
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
    @Override
      public void actionPerformed(ActionEvent ae){
          String sreligion=(String) religion.getSelectedItem();
          String scategory=(String) category.getSelectedItem();
          String sincome=(String) income.getSelectedItem();
          String seq=(String) education.getSelectedItem();
          String so=(String) occupation.getSelectedItem();
          String span=(String) pan.getText();
          String saddh=(String) addhar.getText();
          String ssc=null;
          if(sy.isSelected()){
              ssc="YES";
          }else if(sn.isSelected()){
              ssc="NO";
          }
          String sexistingaccount=null;
          if(eay.isSelected()){
              sexistingaccount="YES";
          }else if(ean.isSelected()){
              sexistingaccount="NO";
          }
          
          try {
            Conn c = new Conn();
            if (c.s == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

             String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seq+"','"+so+"','"+span+"','"+saddh+"','"+ssc+"','"+sexistingaccount+"')";
             c.s.executeUpdate(query);
            setVisible(false);
            new Signupthree(formno).setVisible(true);
        } catch (SQLException e) {
            System.out.print(e);
        }
      }  

public static void main(String args[])
{
        Signuptwo signuptwo = new Signuptwo("");
}
}