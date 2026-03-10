
package manag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class balance  extends JFrame implements ActionListener{
  JButton back;
  String pinnumber;
 
    balance(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/clear.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
      
      JLabel image =new JLabel(i3);
     image.setBounds(0,0,700,700);
      add(image);
       
      back=new JButton("Back");
      back.setBounds(150,400,100,20);
      back.addActionListener(this);
      image.add(back);
      
      Conn c=new Conn();
      int balance=0;
                   try
                   {
                       ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                       
                     
                     while(rs.next())
                     {
                         if(rs.getString("type").equals("deposit"))
                         {
                             balance += Integer.parseInt(rs.getString("amount"));
        }
                         else
                         {
                                 balance -= Integer.parseInt(rs.getString("amount"));
                                 }
    }
                   }catch(Exception e)
                   {
                       System.out.println(e);
                   }
                   

      JLabel text=new JLabel("Your currrent balance is RS " + balance);
       text.setForeground(Color.WHITE);
      text.setBounds(150,300,300,20);
      image.add(text);
      
      
        setSize(700,700);
        
     setLocation(300,0);
    setUndecorated(true);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
    {
       setVisible(false);
       new transaction(pinnumber).setVisible(true);
    }
    public static void main(String args[])
    {
        new balance("");
    }}
