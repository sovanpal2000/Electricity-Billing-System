
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Paybill extends JFrame implements ActionListener {
    Choice cmonth;
    String meterno;
    JButton pay,back;
    Paybill(String meterno)
    { 
        this.meterno=meterno;
        setBounds(300,150,800,600);
        setLayout(null);
        JLabel heading =new JLabel("Electicity Bill");
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setBounds(300,5, 400, 30);
        add(heading);
        
        JLabel lbmeter =new JLabel("Meter Number");
        lbmeter.setFont(new Font("Tahoma",Font.BOLD,20));
        lbmeter.setBounds(30,75, 150, 30);
        add(lbmeter);
        
        JLabel meter=new JLabel("");
        meter.setBounds(240,75, 200, 30);
        add(meter);

        JLabel lbname =new JLabel("Name");
        lbname.setFont(new Font("Tahoma",Font.BOLD,20));
        lbname.setBounds(30,135, 150, 30);
        add(lbname);

        JLabel name =new JLabel("");
        name.setBounds(240,135, 200, 30);
        add(name);

        JLabel lbmonth =new JLabel("Month");
        lbmonth.setFont(new Font("Tahoma",Font.BOLD,20));
        lbmonth.setBounds(30,200, 150, 30);
        add(lbmonth);
        
        cmonth = new Choice();
   cmonth.setBounds(240, 200, 200, 30);
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
   add(cmonth);  
   
   JLabel lbunits =new JLabel("Units");
   lbunits.setFont(new Font("Tahoma",Font.BOLD,20));
   lbunits.setBounds(30,265, 150, 30);
   add(lbunits);
   JLabel units1 =new JLabel("");
   //lbunits.setFont(new Font("Tahoma",Font.BOLD,20));
   units1.setBounds(240,265, 200, 30);
   add(units1);
    JLabel lbtotal =new JLabel("Total Bill");
   lbtotal.setFont(new Font("Tahoma",Font.BOLD,20));
   lbtotal.setBounds(30,320, 150, 30);
   add(lbtotal);
   JLabel total =new JLabel("");
   //lbunits.setFont(new Font("Tahoma",Font.BOLD,20));
   total.setBounds(240,320, 200, 30);
   add(total);
   
   
    JLabel lbstatus =new JLabel("Status");
   lbstatus.setFont(new Font("Tahoma",Font.BOLD,20));
   lbstatus.setBounds(30,360, 150, 30);
   lbstatus.setForeground(Color.red);
   add(lbstatus);
   JLabel Status =new JLabel("");
   //lbunits.setFont(new Font("Tahoma",Font.BOLD,20));
   Status.setBounds(240,360, 200, 30);
   add(Status);
   
   try
       {
          Conn c=new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer2 where METER_NUMBER = '"+meterno+"'");
          while(rs.next())
          {
              name.setText(rs.getString("Cname"));
              meter.setText(meterno);
              
          }
          rs = c.s.executeQuery("select * from bill where METER_NO = '"+meterno+"' and month='"+cmonth.getSelectedItem()+"'");
          while(rs.next())
          {
              units1.setText(rs.getString("units"));
              total.setText(rs.getString("totalbill"));
              Status.setText(rs.getString("status"));
          }
       }
      catch(Exception e)
      {
          e.printStackTrace();
      }
   
   
       cmonth.addItemListener(new ItemListener(){
           @Override
           public void itemStateChanged(ItemEvent ae)
           {
                try
                {
                    Conn c=new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where METER_NO = '"+meterno+"' and month='"+cmonth.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        units1.setText(rs.getString("units"));
                        total.setText(rs.getString("totalbill"));
                        Status.setText(rs.getString("status"));
                    }
                }
      catch(Exception e)
      {
          e.printStackTrace();
      }
           }
       });
       
       pay=new JButton("PAYBILL");
       pay.setBackground(Color.black);
       pay.setForeground(Color.white);
       pay.setBounds(100,450, 100, 30);
       pay.addActionListener(this);
       add(pay);
       
       back=new JButton("BACK");
       back.setBackground(Color.black);
       back.setForeground(Color.white);
       back.setBounds(270,450, 100, 30);
       back.addActionListener(this);
       add(back);
       getContentPane().setBackground(Color.white);
        ImageIcon im= new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
       Image i6=im.getImage().getScaledInstance(500,250, Image.SCALE_DEFAULT);
       ImageIcon im1=new ImageIcon(i6);
       JLabel image= new JLabel(im1);
       image.setBounds(350,200,500,250);
       add(image);
       
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==pay)
        {
            try
            {
               Conn c=new Conn(); 
               c.s.executeUpdate("update bill set status='paid' where meter_no='"+meterno+"' and month='"+cmonth.getSelectedItem()+"'");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            setVisible(false);
            new paytm(meterno);
        }else
        {
            setVisible(false);
        }
    }
    public static void main(String ars[])
    {
        new Paybill("");
    }
}
