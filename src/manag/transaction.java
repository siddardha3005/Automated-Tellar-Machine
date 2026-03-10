
package manag;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class transaction extends JFrame implements ActionListener{
    JButton deposit,withdraw,cash,statement,pin,balance,exit;
    String pinnumber;
    transaction(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/clear.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
      
      JLabel image =new JLabel(i3);
     image.setBounds(0,0,700,700);
      add(image);
    
        JLabel text=new JLabel("Please select your Transaction");
     text.setBounds(150,240,600,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
         deposit=new JButton("Deposit");
        deposit.setBounds(130,350,110,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
         
         withdraw=new JButton("Cash Withdrawl");
        withdraw.setBounds(250,350,150,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
          
       cash=new JButton("Fast Cash");
        cash.setBounds(130,380,110,25);
        cash.addActionListener(this);
        image.add(cash);
        
 statement=new JButton("Mini Statement");
statement.setBounds(250,380,150,25);
statement.addActionListener(this);
        image.add(statement);
        
        
          pin=new JButton("Pin Change");
        pin.setBounds(130,410,110,25);
        pin.addActionListener(this);
        image.add(pin);
        
               balance=new JButton("Balance Enquiry");
balance.setBounds(250,410,150,25);
balance.addActionListener(this);
        image.add(balance);
        
        
               exit=new JButton("Exit");
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
            System.exit(0);
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw)
        {
            setVisible(false);
            new withdraw(pinnumber).setVisible(true);
                
                    
        }else if(ae.getSource()==cash)
                {
                    setVisible(false);
                    new fastcash(pinnumber).setVisible(true);
                }  
        else if(ae.getSource()==pin)
                {
                    setVisible(false);
                    new pinchange(pinnumber).setVisible(true);
                }  
    
else if(ae.getSource()== balance)
                {
                    setVisible(false);
                    new balance(pinnumber).setVisible(true);
                } 
        
        else if(ae.getSource()== statement)
                {
                    setVisible(false);
                    new ministatement(pinnumber).setVisible(true);
                } 
        
}
    public static void main(String args[])
    {
        new transaction("");
    }
}
