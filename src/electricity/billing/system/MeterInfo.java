package electricity.billing.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MeterInfo extends JFrame implements ActionListener{  
   JButton submit;
   JLabel lblmeter;
   Choice meterlocation, metertype, phasecode, billtype;
   String meternumber;
   MeterInfo(String meternumber)
   {
     this.meternumber = meternumber;
       setSize(700,500);
     setLocation(400,200);
    
     JPanel p = new JPanel();
     p.setLayout(null);
     p.setBackground(new Color(173,216,230));
     add(p);
     
     JLabel heading = new JLabel("Meter Information");
     heading.setBounds(180, 10, 200, 25);
     heading.setFont(new Font("Tahoma",Font.PLAIN,24));
     p.add(heading);
     
     JLabel lblname = new JLabel("Meter Number");
     lblname.setBounds(100, 80, 100, 20); 
     p.add(lblname);
     
     JLabel lblmeternumber = new JLabel(meternumber);
     lblmeternumber.setBounds(240, 80, 100, 20); 
     p.add(lblmeternumber);
     
     JLabel lblmeterloc = new JLabel("Meter Location");
     lblmeterloc.setBounds(100, 120, 100, 20); 
     p.add(lblmeterloc);
     meterlocation = new Choice();
     meterlocation.add("Outside");
     meterlocation.add("Inside");
     meterlocation.setBounds(240, 120 , 200 , 20);
     p.add(meterlocation);
      
     JLabel lblmetertype = new JLabel("Meter Type");
     lblmetertype.setBounds(100, 160, 100, 20); 
     p.add(lblmetertype);
     
     metertype = new Choice();
     metertype.add("Electric Meter");
     metertype.add("Solar Meter");
     metertype.add("Smart Meter");
     metertype.setBounds(240, 160 , 200 , 20);
     p.add(metertype);
     
     JLabel lblphasecode = new JLabel("Phase Code");
     lblphasecode.setBounds(100, 200, 100, 20); 
     p.add(lblphasecode);
     
     phasecode = new Choice();
     phasecode.add("011");
     phasecode.add("022");
     phasecode.add("033");
     phasecode.add("044");
     phasecode.add("055");
     phasecode.add("066");
     phasecode.add("077");
     phasecode.add("088");
     phasecode.add("099");
     phasecode.setBounds(240, 200 , 200 , 20);
     p.add(phasecode);
    
     JLabel lblbilltype = new JLabel("Bill Type");
     lblbilltype.setBounds(100, 240, 100, 20); 
     p.add(lblbilltype);
     
     billtype = new Choice();
     billtype.add("Normal");
     billtype.add("Industrial");
     billtype.setBounds(240, 240 , 200 , 20);
     p.add(billtype);
     
     JLabel lblday = new JLabel("Days");
     lblday.setBounds(100, 280, 100, 20); 
     p.add(lblday);
     
     JLabel lbldays = new JLabel("30 days");
     lbldays.setBounds(240, 280, 100, 20); 
     p.add(lbldays);
     
     JLabel lblnote = new JLabel("Note");
     lblnote.setBounds(100, 320, 100, 20); 
     p.add(lblnote);
     
     JLabel lblnotes = new JLabel("By default the bill is calculated for 30 days only");
     lblnotes .setBounds(240, 320, 500, 20); 
     p.add(lblnotes);
     
     submit = new JButton("Submit");
     submit.setBounds(120, 390, 100, 25);
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.addActionListener(this);
     p.add(submit);

   setLayout(new BorderLayout());
   add(p,"Center");
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
   Image i2 = i1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel image = new JLabel(i3);
   add(image,"West");
   getContentPane().setBackground(Color.WHITE);
  
   setVisible(true);
   }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== submit){
    String meter = meternumber;
    String location = meterlocation.getSelectedItem();
    String type = metertype.getSelectedItem();
    String code = phasecode.getSelectedItem();
    String btype = billtype.getSelectedItem();
    String days = "30";

    String query1="Insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+btype+"','"+days+"')";
    try{
        Conn c = new Conn();
        c.s.executeUpdate(query1);
        JOptionPane.showMessageDialog(null,"Meter Information added Successfully");
        setVisible(false);
    }catch (Exception e){
    e.printStackTrace();
    }
    }
    else {
    setVisible(false);
    }
    }
    public static void main(String[] args)
   {     
   new MeterInfo(""); 
   }
}
