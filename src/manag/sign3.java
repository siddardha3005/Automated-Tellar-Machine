/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class sign3 extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    
    String text;
    public sign3(String text)
    {
        this.text=text;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Arial",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
           JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,18));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
         r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,150,20);
        add(r1);
         r2=new JRadioButton("Fixed Deposit Account");
         r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,250,20);
        add(r2);
         r3=new JRadioButton("Current Account");
         r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,250,20);
        add(r3);
         r4=new JRadioButton("Recurring Deposit Account");
         r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,250,20);
        add(r4);
        ButtonGroup gp=new ButtonGroup();
        gp.add(r1);
         gp.add(r2);
          gp.add(r3);
           gp.add(r4);
        
         JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Arial",Font.BOLD,22));
       card.setBounds(100,300,200,30);
        add(card);
        
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-2811");
          number.setFont(new Font("Arial",Font.BOLD,18));
       number.setBounds(330,300,300,30);
        add(number);
        JLabel number1=new JLabel("Your 16 digit card number");
          number1.setFont(new Font("Arial",Font.BOLD,12));
       number1.setBounds(100,330,300,20);
        add(number1);
        
           JLabel pin=new JLabel("Pin Number:");
        pin.setFont(new Font("Arial",Font.BOLD,22));
       pin.setBounds(100,370,200,30);
        add(pin);
        
        
        JLabel pnumber=new JLabel("XXXX");
          pnumber.setFont(new Font("Arial",Font.BOLD,18));
       pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        
        JLabel pnumber1=new JLabel("Your 4 digit password");
          pnumber1.setFont(new Font("Arial",Font.BOLD,12));
       pnumber1.setBounds(100,400,300,20);
        add(pnumber1);
        
          JLabel services=new JLabel("Services Required:");
          services.setFont(new Font("Arial",Font.BOLD,18));
     services.setBounds(100,450,200,30);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
         c1.setFont(new Font("Arial",Font.BOLD,16));
       c1.setBounds(100,500,200,30);
        add(c1);
        
           c2=new JCheckBox("ATM Card");
         c1.setFont(new Font("Arial",Font.BOLD,16));
       c1.setBounds(100,500,200,30);
        add(c1);
           c2=new JCheckBox("Internet Banking");
         c2.setFont(new Font("Arial",Font.BOLD,16));
       c2.setBounds(350,500,200,30);
        add(c2);
           c3=new JCheckBox("Mobile Banking");
         c3.setFont(new Font("Arial",Font.BOLD,16));
       c3.setBounds(100,550,200,30);
        add(c3);
        
         c4=new JCheckBox("Email & Sms Alerts");
         c4.setFont(new Font("Arial",Font.BOLD,16));
       c4.setBounds(350,550,200,30);
        add(c4);
         c5=new JCheckBox("Cheque Book");
         c5.setFont(new Font("Arial",Font.BOLD,16));
       c5.setBounds(100,600,200,30);
        add(c5);
        
         c6=new JCheckBox("E-Statement");
         c6.setFont(new Font("Arial",Font.BOLD,16));
       c6.setBounds(350,600,200,30);
        add(c6);
        
         c7=new JCheckBox("I hereby declares that above details are correct");
         c7.setFont(new Font("Arial",Font.BOLD,16));
       c7.setBounds(100,680,600,30);
        add(c7);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
       
           cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
         setSize(850,820);
            setVisible(true);
        
        
}
       public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==submit)
        {
            String type=null;
            if(r1.isSelected())
            {
                type="Saving Account";
            }else if(r2.isSelected())
            {
                type="Fixed Deposit Account";
            }else if(r3.isSelected())
            {
                type="Current Account";
            }else if(r4.isSelected())
            {
                type="Recurring Deposit Account";
            } 
            Random random=new Random();
            String card=""+Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pin="" +Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility ="";
            if(c1.isSelected())
            {
                facility=facility + "ATM card";
            }else if(c2.isSelected())
            {
                facility=facility + "Internet Banking";
            }else if(c3.isSelected())
            {
                facility=facility + "Mobile Banking";
            }else if(c4.isSelected())
            {
                facility=facility + "Email & Sms Alerts";
            }else if(c5.isSelected())
            {
                facility=facility + "Cheque Book";
            }else if(c6.isSelected())
            {
                facility=facility + "E-Statement";
            }
            try
            {
                if(type.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Account type required");
                }else
                {
                    Conn conn=new Conn();
                    String query1="insert into signn values('"+text+"','"+type+"','"+card+"','"+pin+"','"+facility+"')";
        String query2="insert into log values('"+text+"','"+card+"','"+pin+"')";
           conn.s.executeUpdate(query1);
           conn.s.executeUpdate(query2);
           JOptionPane.showMessageDialog(null,"card number " + card + "\n pin: " + pin);
           
           setVisible(false);
           new deposit(pin).setVisible(true);
                }}
                catch(Exception e)
                        {
                        System.out.println(e);
                        }
                
            
            
    }else if(ae.getSource()==cancel)
    {
        setVisible(false);
        new login().setVisible(true);
    }
    }
    public static void main(String args[])
    {
        new sign3("");
    }
}
