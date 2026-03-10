
package manag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ministatement  extends JFrame {
    
        

        ministatement(String pinnumber)
                {
                  
                    setTitle("Statement");
                    setLayout(null);
                    JLabel mini=new JLabel();
                    add(mini);
                    JLabel bank=new JLabel("INDIAN BANK");
                    bank.setBounds(150,20,100,20);
                    add(bank);
                     JLabel card=new JLabel("INDIAN BANK");
                    card.setBounds(20,80,300,20);
                    add(card);
                    JLabel balance=new JLabel();
                    balance.setBounds(20,400,300,20);
                    add(balance);
                         
                    
                    
                    
                    
                    
                    
                    try
                    {
                        Conn conn=new Conn();
                        ResultSet rs=conn.s.executeQuery("select * from log where pin='"+pinnumber+"'");
                        while(rs.next())
                        {
                            card.setText("card number:" +rs.getString("card_number").substring(0,4)+"XXXXXXXX" +rs.getString("card_number").substring(12));
                        }
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                  
                    try
                    {
                        Conn conn=new Conn();
                   int bal=0; 
                       ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                       
                     
                     while(rs.next())
                     {
                     
                            mini.setText(mini.getText() + "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("type" ) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount"));
                            if(rs.getString("type").equals("deposit"))
                         {
                             bal += Integer.parseInt(rs.getString("amount"));
        }
                         else
                         {
                                 bal -= Integer.parseInt(rs.getString("amount"));
                                 }
    }
                            
                            
                            
                         balance.setText("your currentbalance is" +bal);   
                            
                        
                    
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    
                    mini.setBounds(20,140,400,200);
                    
                    setSize(400,600);
                    setLocation(20,20);
                    setVisible(true);
                    
                }
    
   public static void main(String args[])
                {
                    new ministatement("");
                    
                }
}