package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(250, 280, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 15));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 15));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.setCursor(new Cursor(Cursor.HAND_CURSOR));
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change)
        {
        try {
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            
            if(npin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
                return;
            }
            
            if(rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return;
            }
            
            Conn conn=new Conn();
            String q1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
            String q2="update login set PinNumber='"+rpin+"' where PinNumber='"+pinnumber+"'";
            String q3="update signupthree set PinNumber='"+rpin+"' where PinNumber='"+pinnumber+"'";
            
            conn.s.executeUpdate(q1);
            conn.s.executeUpdate(q2);
            conn.s.executeUpdate(q3);
            
            JOptionPane.showMessageDialog(null,"PIN changed successfully");
            setVisible(false);
            new Transaction(rpin).setVisible(true);
            
        }catch(Exception e) {
            System.out.println(e);
        }
        }else
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
