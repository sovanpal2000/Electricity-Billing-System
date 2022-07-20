
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewInformation extends JFrame implements ActionListener
{
    String meterno;
    JButton cancel;
    ViewInformation(String meterno)
    {
        this.meterno=meterno;
        setBounds(300,150,800,600);
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel heading = new JLabel("View Customer Information");
       heading.setBounds(250,0,500,40);
       heading.setFont(new Font("Tohoma",Font.PLAIN,20));
       add(heading);
       
       JLabel lb1name= new JLabel("Name");
       lb1name.setBounds(80,60,100,20);
       lb1name.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1name);
       
       JLabel name= new JLabel("");
       name.setBounds(250,60,100,20);
       add(name);
       
       JLabel lb1meternumber= new JLabel("Meter Number");
       lb1meternumber.setBounds(80,120,100,20);
       lb1meternumber.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1meternumber);
       
       JLabel meter= new JLabel("");
       meter.setBounds(250,120,100,20);
       add(meter);
       
       JLabel lb1address= new JLabel("Adress");
       lb1address.setBounds(80,180,100,20);
       lb1address.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1address);
       
       JLabel address= new JLabel("");
       address.setBounds(250,180,100,20);
       add(address);
       
       JLabel lb1city= new JLabel("City");
       lb1city.setBounds(80,240,100,20);
       lb1city.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1city);
       
       JLabel city= new JLabel("");
       city.setBounds(250,240,100,20);
       add(city);
       
       JLabel lb1state= new JLabel("State");
       lb1state.setBounds(380,60,100,20);
       lb1state.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1state);
       
       JLabel state= new JLabel("");
       state.setBounds(450,60,100,20);
       add(state);
       
       JLabel lb1email= new JLabel("Email");
       lb1email.setBounds(380,120,100,20);
       lb1email.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1email);
       
       JLabel email= new JLabel("");
       email.setBounds(450,120,100,20);
       add(email);
       
       JLabel lb1phone= new JLabel("Phone number");
       lb1phone.setBounds(380,180,100,20);
       lb1phone.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1phone);
       
       JLabel phone= new JLabel("");
       phone.setBounds(550,180,150,20);
       add(phone);
       
       try
       {
          Conn c=new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer2 where METER_NUMBER = '"+meterno+"'");
          while(rs.next())
          {
              name.setText(rs.getString("Cname"));
              address.setText(rs.getString("address"));
              city.setText(rs.getString("city"));
              meter.setText(rs.getString("meter_number"));
              state.setText(rs.getString("state"));
              email.setText(rs.getString("email"));
              phone.setText(rs.getString("phnumber"));
              
          }
       }
      catch(Exception e)
      {
          e.printStackTrace();
      }


       cancel=new JButton("Cancel");
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.white);
       cancel.setBounds(350,340,100,25);
       cancel.addActionListener(this);
       add(cancel);
       
       ImageIcon im= new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
       Image i6=im.getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT);
       ImageIcon im1=new ImageIcon(i6);
       JLabel image= new JLabel(im1);
       image.setBounds(20,350,600,300);
       add(image);
       
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }
    public static void main(String ars[])
    {
        new ViewInformation("");
    }
    
}
