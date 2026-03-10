package manag;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class sign2 extends JFrame implements ActionListener{
  
    JTextField name5,name6;
    JRadioButton syes,sno;
    JButton next;
    JComboBox valreligion,valCategory,valIncome,valEducation,valoccupation;
  String text;
     public sign2(String text)
    {
        this.text=text;
        setLayout(null);
       setTitle("Application Form Page-2");
     
           JLabel addn=new JLabel("Page 2: Additional Details");
        addn.setFont(new Font("Arial",Font.BOLD,22));
        addn.setBounds(240,90,400,50);
        add(addn);
        
        
           JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,18));
        religion.setBounds(100,170,400,30);
        add(religion);
        
        String val[]={"Hindu","Muslim","Christian","Other"};
         valreligion=new JComboBox(val);
           valreligion.setBounds(250,170,400,30);
        add(valreligion);
        
            JLabel Category=new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,18));
       Category.setBounds(100,220,400,30);
        add(Category);
        
         String val2[]={"General","OBC","ST","SC","Other"};
         valCategory=new JComboBox(val2);
           valCategory.setBounds(250,220,400,30);
        add(valCategory);
        
        
   
            JLabel Income=new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,18));
        Income.setBounds(100,270,400,50);
        add(Income);
          String val3[]={"NULL","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
       valIncome=new JComboBox(val3);
           valIncome.setBounds(250,280,400,30);
        add(valIncome);
      
        
            JLabel Education=new JLabel("Education");
        Education.setFont(new Font("Raleway",Font.BOLD,18));
        Education.setBounds(100,320,400,50);
        add(Education);
        
        
   
            JLabel Qualification=new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway",Font.BOLD,18));
        Qualification.setBounds(100,360,400,50);
        add(Qualification);
        
         String val4[]={"Non-Graduation","Graduate","Post-Graduation","Doctrate","Other"};
         valEducation=new JComboBox(val4);
           valEducation.setBounds(250,350,400,30);
        add(valEducation);
        
        
            JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,18));
       occupation.setBounds(100,420,400,50);
        add(occupation);
        
           String val5[]={"Student","Salaried","Buiseness","Retired","Other"};
 valoccupation=new JComboBox(val5);
           valoccupation.setBounds(250,430,400,30);
        add(valoccupation);
      
            JLabel pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,18));
        pan.setBounds(100,470,400,50);
        add(pan);
        
        
             name5=new JTextField();
         name5.setFont(new Font("Raleway",Font.BOLD,15));
        name5.setBounds(250,480,400,30);
        add(name5);
        
        
            JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,18));
        aadhar.setBounds(100,520,400,50);
        add(aadhar);
        
               name6=new JTextField();
         name6.setFont(new Font("Raleway",Font.BOLD,15));
        name6.setBounds(250,530,400,30);
        add(name6);
        
        
        
          JLabel exist=new JLabel("Existing Acc:");
        exist.setFont(new Font("Raleway",Font.BOLD,18));
        exist.setBounds(100,590,200,30);
        add(exist);
       
         syes=new JRadioButton("Yes");
         syes.setBounds(300,590,100,30);
         add(syes);
                 sno=new JRadioButton("No");
         sno.setBounds(450,590,100,30);
         add(sno);
  ButtonGroup eexist=new ButtonGroup();
  eexist.add(syes);
  eexist.add(sno);
  
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
   
    String sreligion=(String) valreligion.getSelectedItem();
    String scategory=(String) valCategory.getSelectedItem();
    String sincome=(String) valIncome.getSelectedItem();
    String seducation=(String) valEducation.getSelectedItem();
    String soccupation=(String) valoccupation.getSelectedItem();
   
    
    String span=name5.getText();
       String saadhar=name6.getText();
     
        String exist=null;
        if(syes.isSelected())
        {
            exist="Yes";
        }else if(sno.isSelected())
        {
            exist="No";
        }
        
        
    try
            {
           
                    
                    Conn c=new Conn();
                      String query="insert into signtwoo values('"+text+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+exist+"')";
                    c.s.executeUpdate(query);
                setVisible(false);
                new sign3(text).setVisible(true);
                    
                    
                    
            }catch(Exception e)
                {
                  System.out.print(e);
    }
    }
    public static void main(String args[])
    {
        new sign2("");
    }
}

