

package manag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class pinchange  extends JFrame implements ActionListener{
    JPasswordField pintext,repintext;
    JButton change,back;
    String pinnumber;
    pinchange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/clear.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
      
      JLabel image =new JLabel(i3);
     image.setBounds(0,0,700,700);
      add(image);
      
      
       JLabel text=new JLabel("CHANGE YOUR PIN");
     text.setBounds(180,240,600,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
      
      
        JLabel pin=new JLabel("New Pin:");
     pin.setBounds(140,300,600,30);
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("System",Font.BOLD,16));
        image.add(pin);
        pintext=new JPasswordField();
      pintext.setBounds(220,305,160,20);
       pintext.setFont(new Font("System",Font.BOLD,14));
       image.add(pintext);
       
       JLabel repin=new JLabel("Re-Enter PIN:");
     repin.setBounds(120,330,600,30);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("System",Font.BOLD,16));
        image.add(repin);
        repintext=new JPasswordField();
      repintext.setBounds(230,335,160,20);
       repintext.setFont(new Font("System",Font.BOLD,14));
       image.add(repintext);
       
      
       change=new JButton("Change");
      change.setBounds(280,400,100,20);
      change.addActionListener(this);
      image.add(change);
         
       back=new JButton("Back");
      back.setBounds(150,400,100,20);
      back.addActionListener(this);
      image.add(back);
      
      
      
      
      
      
      
      
      
      
      
        setSize(700,700);
        
     setLocation(300,0);
    setUndecorated(true);
        setVisible(true);
}
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==change)
        {
            
        
        
    
    try
    {
        String npin=pintext.getText();
        String rpin=repintext.getText();
        if(!npin.equals(rpin))
        {
            JOptionPane.showMessageDialog(null,"entered pin does not match");
            return;
        }
        if(npin.equals(""))
        {
             JOptionPane.showMessageDialog(null,"enter the pin");
        
        return;
        }
        if(rpin.equals(""))
        {
             JOptionPane.showMessageDialog(null,"re-enter the pin");
        
        return;
        }
        Conn conn=new Conn();
        String query1="update bank set pin ='"+rpin+"' where pin='"+pinnumber+"'";
         String query2="update log set pin ='"+rpin+"' where pin='"+pinnumber+"'"; 
         String query3="update signn set pin ='"+rpin+"' where pin='"+pinnumber+"'";
           conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
           
             conn.s.executeUpdate(query3);
           
         JOptionPane.showMessageDialog(null,"pin changed succesfully");
         
         setVisible(false);
         new transaction(rpin).setVisible(true);
         
    }catch(Exception e)
    {
        System.out.println(e);
    }
    
        }else {
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }}
    
    public static void main(String args[])
    {
        new pinchange("");
    }
}
