package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class CalculateBill extends JFrame implements ActionListener{  
   JTextField tfname ,tfadress ,tfunits;
   JButton submit,cancel;
   JLabel lblname, lbladress;
   Choice meternumber, cmonth;
   CalculateBill()
   {
     setSize(700,500);
     setLocation(400,200);
    
     JPanel p = new JPanel();
     p.setLayout(null);
     p.setBackground(new Color(173,216,230));
     add(p);
     
     JLabel heading = new JLabel("Calculate Electricity Bill");
     heading.setBounds(100, 10, 400, 25);
     heading.setFont(new Font("Tahoma",Font.PLAIN,24));
     p.add(heading);
     
     JLabel lblmeterno = new JLabel("Meter Number");
     lblmeterno.setBounds(100, 80, 100, 20); 
     p.add(lblmeterno);
     
     meternumber = new Choice();
     try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer2");
        while(rs.next()){
        meternumber.add(rs.getString("METER_NUMBER"));
        }
    }catch (Exception e){
    e.printStackTrace();
    }
     meternumber.setBounds(240, 80, 200, 20);
     p.add(meternumber);
     
     JLabel lblnames = new JLabel("Customer Name");
     lblnames.setBounds(100, 120, 100, 20); 
     p.add(lblnames);
     
     lblname = new JLabel("");
     lblname.setBounds(240, 120, 100, 20); 
     p.add(lblname);
     
     JLabel lbladresss = new JLabel("Adress");
     lbladresss.setBounds(100, 160, 100, 20); 
     p.add(lbladresss);
     
     lbladress = new JLabel();
     lbladress.setBounds(240, 160 , 200 , 20);
     p.add(lbladress);
         try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer2 where METER_NUMBER in '"+meternumber.getSelectedItem()+"'");
        while(rs.next()){
        lblname.setText(rs.getString("CNAME"));
        lbladress.setText(rs.getString("ADDRESS"));
        }
    }catch (Exception e){
    e.printStackTrace();
    }
   
    meternumber.addItemListener(new ItemListener() {
       public void itemStateChanged(ItemEvent ie){
           try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select*from customer2 where METER_NUMBER = '"+meternumber.getSelectedItem()+"'");
        while(rs.next()){
        lblname.setText(rs.getString("CNAME"));
        lbladress.setText(rs.getString("ADDRESS"));
        }
    }catch (Exception e){
    e.printStackTrace();
    }
       } 
    });
    
    JLabel lblunits = new JLabel("Units Consumed");
     lblunits.setBounds(100, 200, 100, 20); 
     p.add(lblunits);
     
     tfunits = new JTextField();
     tfunits.setBounds(240, 200 , 200 , 20);
     p.add(tfunits);
     
     JLabel lblmonth = new JLabel("Month");
     lblmonth .setBounds(100, 240, 100, 20); 
     p.add(lblmonth );

     cmonth = new Choice();
     cmonth.setBounds(240, 240 , 200 , 20);
     cmonth.add("January");
     cmonth.add("February");
     cmonth.add("March");
     cmonth.add("April");
     cmonth.add("May");
     cmonth.add("June");
     cmonth.add("July");
     cmonth.add("August");
     cmonth.add("September");
     cmonth.add("October");
     cmonth.add("November");
     cmonth.add("December");
     p.add(cmonth);
     
     submit = new JButton("Submit");
     submit.setBounds(120, 350, 100, 25);
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.addActionListener(this);
     p.add(submit);
     
     cancel = new JButton("Cancel");
     cancel.setBounds(250, 350, 100, 25);
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE); 
     cancel.addActionListener(this);
     p.add(cancel);
     
   setLayout(new BorderLayout());
   add(p,"Center");
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
   Image i2 = i1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel image = new JLabel(i3);
   add(image,"West");
   getContentPane().setBackground(Color.WHITE);
   setVisible(true);
   }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== submit){
    
    String meter = meternumber.getSelectedItem();
    String units = tfunits.getText();
    String month = cmonth.getSelectedItem();
    
    int totalbill = 0;
    int units_consued = Integer.parseInt(units);
    String query1="select * from tax";
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query1);
        while(rs.next()){
        totalbill += units_consued *Integer.parseInt(rs.getString("cost_per_unit"));
        totalbill += Integer.parseInt(rs.getString("meter_rent"));
        totalbill += Integer.parseInt(rs.getString("service_charge"));
        totalbill += Integer.parseInt(rs.getString("service_tax"));
        totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
        totalbill += Integer.parseInt(rs.getString("fixed_tax"));
        }
    }catch (Exception e){
    e.printStackTrace();
    }
    String query2="Insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalbill+"','not paid')";    
    try{
    Conn c = new Conn();
    c.s.executeUpdate(query2);
    JOptionPane.showMessageDialog(null,"Customer Bill Uploaded Successfully");
    setVisible(false);
    }
    catch(Exception e){
    e.printStackTrace();}
    }
    else {
    setVisible(false);
    }
    }
    public static void main(String[] args)
   {     
   new CalculateBill(); 
   }
}