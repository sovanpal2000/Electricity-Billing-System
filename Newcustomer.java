
package electricity.billing.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Newcustomer extends JFrame implements ActionListener{  
   JTextField tfname ,tfadress ,tfstate ,tfcity , tfemail , tfnumber;
   JButton next,cancel;
   JLabel lblmeter;
   Newcustomer()
   {
     setSize(700,500);
     setLocation(400,200);
    
     JPanel p = new JPanel();
     p.setLayout(null);
     p.setBackground(new Color(173,216,230));
     add(p);
     
     JLabel heading = new JLabel("New Customer");
     heading.setBounds(180, 10, 200, 25);
     heading.setFont(new Font("Tahoma",Font.PLAIN,24));
     p.add(heading);
     
     JLabel lblname = new JLabel("Customer Name");
     lblname.setBounds(100, 80, 100, 20); 
     p.add(lblname);
     
     tfname = new JTextField();
     tfname.setBounds(240, 80 , 200 , 20);
     p.add(tfname);
     
     JLabel lblmeterno = new JLabel("Meter Number");
     lblmeterno.setBounds(100, 120, 100, 20); 
     p.add(lblmeterno);
     
     lblmeter = new JLabel("");
     lblmeter.setBounds(240, 120, 100, 20); 
     p.add(lblmeter);
     
     Random ran = new Random();
     long number = ran.nextLong()% 1000000;
     lblmeter.setText(""+ Math.abs(number));
     
     JLabel lbladress = new JLabel("Adress");
     lbladress.setBounds(100, 160, 100, 20); 
     p.add(lbladress);
     
     tfadress = new JTextField();
     tfadress.setBounds(240, 160 , 200 , 20);
     p.add(tfadress);
     
     JLabel lblstate = new JLabel("State");
     lblstate.setBounds(100, 200, 100, 20); 
     p.add(lblstate);
     
     tfstate = new JTextField();
     tfstate.setBounds(240, 200 , 200 , 20);
     p.add(tfstate);
     
     JLabel lblcity = new JLabel("City");
     lblcity.setBounds(100, 240, 100, 20); 
     p.add(lblcity);
     
     tfcity = new JTextField();
     tfcity.setBounds(240, 240 , 200 , 20);
     p.add(tfcity);
     
     JLabel lblemail = new JLabel("E-mail");
     lblemail.setBounds(100, 280, 100, 20); 
     p.add(lblemail);
     
     tfemail = new JTextField();
     tfemail.setBounds(240, 280 , 200 , 20);
     p.add(tfemail);
     
     JLabel lblphone = new JLabel("Phone Number");
     lblphone.setBounds(100, 320, 100, 20); 
     p.add(lblphone);
     
     tfnumber = new JTextField();
     tfnumber.setBounds(240, 320 , 200 , 20);
     p.add(tfnumber);
    
     next = new JButton("Next");
     next.setBounds(120, 390, 100, 25);
     next.setBackground(Color.BLACK);
     next.setForeground(Color.WHITE);
     next.addActionListener(this);
     p.add(next);
     
     cancel = new JButton("Cancel");
     cancel.setBounds(250, 390, 100, 25);
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE); 
     cancel.addActionListener(this);
     p.add(cancel);
     
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
    if(ae.getSource()== next){
//        tfname ,tfadress ,tfstate ,tfcity , tfemail , tfnumber
    String name = tfname.getText();
    String meterno = lblmeter.getText();
    String adress = tfadress.getText();
    String state = tfstate.getText();
    String city = tfcity.getText();
    String email = tfemail.getText();
    String number = tfnumber.getText();
    
    String query1="Insert into customer2 values('"+name+"','"+meterno+"','"+adress+"','"+state+"','"+city+"','"+email+"','"+number+"')";
    //String query2="Insert into login values('"+meterno+"','','"+name+"','','')";

    try{
        Conn c = new Conn();
        c.s.executeUpdate(query1);
        //c.s.executeUpdate(query2);
        JOptionPane.showMessageDialog(null,"Customer Details added Successfully");
        setVisible(false);
        // new frame meter info will start from here
        new MeterInfo(meterno);
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
   new Newcustomer(); 
   }
}
