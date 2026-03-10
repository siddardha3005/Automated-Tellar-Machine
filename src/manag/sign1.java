package manag;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class sign1 extends JFrame implements ActionListener{
    long random;
    JTextField name1,name2,name3,name4,name5,name6,name7;
    JButton next;
    JRadioButton  male,female;
    JDateChooser date;
    sign1()
    {
        setLayout(null);
        Random r=new Random();
        random=Math.abs((r.nextLong()% 9000L)+2000L);
        
        JLabel text=new JLabel("APPLICATION NO:" + random);
        text.setFont(new Font("Osward",Font.BOLD,35));
        text.setBounds(200,40,400,50);
        add(text);
        
           JLabel personal=new JLabel("Page 1: Personal Details");
        personal.setFont(new Font("Arial",Font.BOLD,22));
        personal.setBounds(240,100,400,50);
        add(personal);
        
        
           JLabel name=new JLabel("Full Name:");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(100,170,400,50);
        add(name);
        
        
         name1=new JTextField();
         name1.setFont(new Font("Raleway",Font.BOLD,15));
        name1.setBounds(250,180,400,30);
        add(name1);
        
            JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(100,220,400,50);
        add(fname);
        
            name2=new JTextField();
         name2.setFont(new Font("Raleway",Font.BOLD,15));
        name2.setBounds(250,230,400,30);
        add(name2);
       
        
        
   
            JLabel DOB=new JLabel("Date Of Birth:");
        DOB.setFont(new Font("Raleway",Font.BOLD,18));
        DOB.setBounds(100,270,400,50);
        add(DOB);
        
         date=new JDateChooser();
       date.setBounds(250,280,200,30);
        add(date);
        
        
            JLabel Gender=new JLabel("Gender:");
        Gender.setFont(new Font("Raleway",Font.BOLD,18));
        Gender.setBounds(100,320,400,50);
        add(Gender);
        
        
         male=new JRadioButton("Male");
        male.setBounds(250,320,200,50);
        add(male);
        
        
          female=new JRadioButton("Female");
        female.setBounds(450,320,200,50);
        add(female);
        
        ButtonGroup gp=new ButtonGroup();
        gp.add(male);
        gp.add(female);
        
        
            JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(100,370,400,50);
        add(email);
        
        
        
            name3=new JTextField();
         name3.setFont(new Font("Raleway",Font.BOLD,15));
        name3.setBounds(250,380,400,30);
        add(name3);
        
            JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,18));
        address.setBounds(100,420,400,50);
        add(address);
        
            name4=new JTextField();
         name4.setFont(new Font("Raleway",Font.BOLD,15));
        name4.setBounds(250,430,400,30);
        add(name4);
      
            JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setBounds(100,470,400,50);
        add(city);
        
        
             name5=new JTextField();
         name5.setFont(new Font("Raleway",Font.BOLD,15));
        name5.setBounds(250,480,400,30);
        add(name5);
        
        
            JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,18));
        state.setBounds(100,520,400,50);
        add(state);
        
               name6=new JTextField();
         name6.setFont(new Font("Raleway",Font.BOLD,15));
        name6.setBounds(250,530,400,30);
        add(name6);
        
        
        
          JLabel pin=new JLabel("Pincode:");
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(100,570,400,50);
        add(pin);
       
           name7=new JTextField();
         name7.setFont(new Font("Raleway",Font.BOLD,15));
        name7.setBounds(250,580,400,30);
        add(name7);
        
  
         next=new JButton("NEXT");
                next.setBackground(Color.BLACK);
next.setForeground(Color.WHITE);

         next.setFont(new Font("Raleway",Font.BOLD,15));
          next.setBounds(620,650,80,30);
          add(next);
          next.addActionListener(this);
        setSize(800,800);
        setVisible(true);
}
       public void actionPerformed(ActionEvent ae)
    {
    String text=""+ random;
    String name=name1.getText();
    String fname=name2.getText();
    String DOB=((JTextField)date.getDateEditor().getUiComponent()).getText();
    String Gender=null;
    if(male.isSelected())
    {
        Gender="Male";
    }
    else if(female.isSelected()){
        
        Gender="Female";
                }
    
    String email=name3.getText();
     String address=name4.getText();
      String city=name5.getText();
       String state=name6.getText();
        String pin=name7.getText();
    try
            {
                if(name.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"name is required");
            }
                else
                {
                    
                    Conn c=new Conn();
                      String query="insert into sign values('"+text+"','"+name+"','"+fname+"','"+DOB+"','"+Gender+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new sign2(text).setVisible(true);
                    
                }
            }catch(Exception e)
                {
                  System.out.print(e);
    }
    }
    public static void main(String args[])
    {
        new sign1();
    }}
