
package manag;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
 
public class fastcash extends JFrame implements ActionListener{
    JButton deposit,withdraw,cash,statement,pin,balance,exit;
    String pinnumber;
    fastcash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/clear.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
      
      JLabel image =new JLabel(i3);
     image.setBounds(0,0,700,700);
      add(image);
    
        JLabel text=new JLabel("Select withdrawl amount");
     text.setBounds(150,240,600,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
         deposit=new JButton("RS 100");
        deposit.setBounds(130,350,110,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
         
         withdraw=new JButton("Rs 500");
        withdraw.setBounds(250,350,150,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
          
       cash=new JButton("RS 1000");
        cash.setBounds(130,380,110,25);
        cash.addActionListener(this);
        image.add(cash);
        
 statement=new JButton("Rs 5000");
statement.setBounds(250,380,150,25);
statement.addActionListener(this);
        image.add(statement);
        
        
          pin=new JButton("RS 10000");
        pin.setBounds(130,410,110,25);
        pin.addActionListener(this);
        image.add(pin);
        
               balance=new JButton("RS 20000");
balance.setBounds(250,410,150,25);
balance.addActionListener(this);
        image.add(balance);
        
        
               exit=new JButton("BACK");
exit.setBounds(250,440,150,25);
exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        
        
        
        setSize(700,700);
        
     setLocation(300,0);
     setUndecorated(true);
        setVisible(true);
}
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
           setVisible(false);
        new transaction(pinnumber).setVisible(true);
    
        }else 
        {
            String amount=((JButton)ae.getSource()).getText().substring(3);
                   Conn c=new Conn();
                   try
                   {
                       ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                       
                     int balance=0;
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
                     
                     if(ae.getSource() != exit && balance < Integer.parseInt(amount))
                     {
                         JOptionPane.showMessageDialog(null,"insufficinet balance");
                         return;
                     }
                     Date date=new Date();
                     String query="insert into bank values('"+pinnumber+"','"+date+"','withdrwal','"+amount+"')";
                         
                     c.s.executeUpdate(query);
                     
                     JOptionPane.showMessageDialog(null,"RS" +amount+" debited succefully");
                     setVisible(false);
                     new transaction(pinnumber).setVisible(true);
                   }catch(Exception e)
                   {
                       System.out.println(e);
                   }
        }
    }
    public static void main(String args[])
    {
        new fastcash("");
    }
}
