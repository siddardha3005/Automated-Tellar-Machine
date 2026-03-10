package manag;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.*;
import java.util.*;

public class withdraw extends JFrame implements ActionListener{
    String pinnumber;
    JButton withdraw,back;
    JTextField amount;
    public withdraw(String pinnumber)
    {
       this.pinnumber=pinnumber;
        setLayout(null);
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/clear.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
      
      JLabel image =new JLabel(i3);
     image.setBounds(0,0,700,700);
      add(image);
      
       JLabel text=new JLabel("Enter amount you want to withdraw");
     text.setBounds(130,240,600,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
    amount=new JTextField();
      amount.setBounds(130,280,250,20);
       amount.setFont(new Font("System",Font.BOLD,16));
       image.add(amount);
        
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(140,400,100,20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        back=new JButton("Back");
        back.setBounds(280,400,100,20);
        back.addActionListener(this);
        image.add(back);
       
        setSize(700,700);
        
     setLocation(300,0);
   
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==withdraw)
        {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"please enter amount to be withdraw");
            }
            else
            {
                try
                {
                    
                Conn conn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
                conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"RS "+number+" withdrawn succesfully");
                 setVisible(false);
                 new transaction(pinnumber).setVisible(true);
            }catch(Exception e)
                    {
                    System.out.println(e);
                    }
        }
        }else if(ae.getSource()==back)
        {
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
public static void main(String args[])
{
    new withdraw("");
}
}