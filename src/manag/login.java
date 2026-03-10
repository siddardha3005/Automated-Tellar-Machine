package manag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener {
    
    JButton login,clear,signup;
            JTextField jt1; JPasswordField jt2;
    login()
    {
        
        setTitle("AUTOMATED TELLAR MACHINE");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/image1.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(90,10,100,100);
        add(label);
        
        JLabel text=new JLabel("WELCOME TO  ATM");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(200,40,400,50);
        add(text);
        
          JLabel text1=new JLabel("CARD NO:");
        text1.setFont(new Font("Raleway",Font.BOLD,28));
      
        text1.setBounds(120,150,150,30);
        add(text1);
        
         jt1=new JTextField();
        jt1.setBounds(300,150,250,30);
         jt1.setFont(new Font("Arial",Font.BOLD,15));
        add(jt1);
       
          JLabel text2=new JLabel("PIN:");
        text2.setFont(new Font("Raleway",Font.BOLD,28));
        text2.setBounds(120,220,250,30);
        add(text2);
        
            jt2=new JPasswordField();
        jt2.setBounds(300,220,250,30);
         jt2.setFont(new Font("Arial",Font.BOLD,15));
        add(jt2);
       
         login=new JButton("SIGN IN");
        login.setBounds(280,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
           clear=new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
         clear.addActionListener(this);
        add(clear);
        
          signup=new JButton("SIGNUP");
        signup.setBounds(300,350,200,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
         signup.addActionListener(this);
        add(signup);
        
        setSize(700,500);
        setVisible(true);
        setLocation(350,200);
}
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==clear)
        {
            jt1.setText("");
            jt2.setText("");
    }else if(ae.getSource()== login){
        
        Conn conn=new Conn();
        String cardnumber=jt1.getText();
        String pinnumber=jt2.getText();
        String query="select * from log where card_number='"+cardnumber+"' and pin='"+pinnumber+"'";
        try
        {
           ResultSet rs= conn.s.executeQuery(query);
           if(rs.next())
           {
               setVisible(false);
        
       new transaction(pinnumber).setVisible(true);
           }
           else
           {
               JOptionPane.showMessageDialog(null,"incorrect cardnumber or pin");
                 
    }
        }
        catch(Exception e)
            
        {
            System.out.println(e);
                }
           
    }
           else if(ae.getSource()== signup){
        
        setVisible(false);
        new sign1().setVisible(true);
        
    }
    }
    
    public static void main(String args[])
    {
        new login();
    }
}
