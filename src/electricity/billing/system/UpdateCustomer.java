package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCustomer extends JFrame implements ActionListener
{
    JTextField tfaddress,tfemail,tfcity,tfphnumber,tfstate;
    JButton update,cancel;
    String meterno;
    UpdateCustomer(String meterno)
    {
        this.meterno=meterno;
       setBounds(200,200,1000,450); 
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel heading = new JLabel("Update Customer Information");
       heading.setBounds(350,0,500,40);
       heading.setFont(new Font("Tohoma",Font.PLAIN,20));
       add(heading);
       
       JLabel lb1name= new JLabel("Name");
       lb1name.setBounds(30,60,100,20);
       lb1name.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1name);
       
        JLabel name= new JLabel("");
       name.setBounds(230,60,100,20);
       add(name);
       
       JLabel lb1meternumber= new JLabel("Meter Number");
       lb1meternumber.setBounds(30,100,100,20);
       lb1meternumber.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1meternumber);
       
       JLabel meter= new JLabel("");
       meter.setBounds(230,100,200,20);
       add(meter);
       
       JLabel lb1address= new JLabel("Address");
       lb1address.setBounds(30,140,100,20);
       lb1address.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1address);
       
       tfaddress= new JTextField();
       tfaddress.setBounds(230,140,200,20);
       add(tfaddress);
       
       JLabel lb1city= new JLabel("City");
       lb1city.setBounds(30,180,100,20);
       lb1city.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1city);
       
      tfcity= new JTextField();
       tfcity.setBounds(230,180,200,20);
       add(tfcity);
       
       JLabel lb1state= new JLabel("State");
       lb1state.setBounds(30,220,100,20);
       lb1state.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1state);
       
       tfstate= new JTextField();
       tfstate.setBounds(230,220,200,20);
       add(tfstate);
       
       JLabel lb1email= new JLabel("Email");
       lb1email.setBounds(30,260,100,20);
       lb1email.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1email);
       
        tfemail= new JTextField();
       tfemail.setBounds(230,260,200,20);
       add(tfemail);
       
       JLabel lb1phone= new JLabel("Phone number");
       lb1phone.setBounds(30,300,100,20);
       lb1phone.setFont(new Font("Tohoma",Font.PLAIN,15));
       add(lb1phone);
       
        tfphnumber= new JTextField();
     tfphnumber.setBounds(230,300,200,20);
       add(tfphnumber);
      
       try
       {
          Conn c=new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer2 where METER_NUMBER = '"+meterno+"'");
          while(rs.next())
          {
              name.setText(rs.getString("Cname"));
              tfaddress.setText(rs.getString("address"));
              tfcity.setText(rs.getString("city"));
              meter.setText(rs.getString("meter_number"));
              tfstate.setText(rs.getString("state"));
              tfemail.setText(rs.getString("email"));
              tfphnumber.setText(rs.getString("phnumber"));
              
          }
       }
      catch(Exception e)
      {
          e.printStackTrace();
      }


       cancel=new JButton("Cancel");
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.white);
       cancel.setBounds(300,340,100,25);
       //cancel.addActionListener(this);
       add(cancel);
       
       update=new JButton("Update");
       update.setBackground(Color.BLACK);
      update.setForeground(Color.white);
       update.setBounds(600,340,100,25);
       update.addActionListener(this);
       add(update);

       
       ImageIcon im= new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
       Image i6=im.getImage().getScaledInstance(300,250, Image.SCALE_DEFAULT);
       ImageIcon im1=new ImageIcon(i6);
       JLabel image= new JLabel(im1);
       image.setBounds(550,50,300,250);
       add(image);

       
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            String address=tfaddress.getText();
            String city=tfcity.getText();
            String state=tfstate.getText();
            String Email=tfemail.getText();
            String Phnumber=tfphnumber.getText();
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer2 set address='"+address+"', city='"+city+"', state='"+state+"', email='"+Email+"', phnumber='"+Phnumber+"' where METER_NUMBER='"+meterno+"' ");
                JOptionPane.showMessageDialog(null,"Customer Update Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    public static void main(String ars[])
    {
        new UpdateCustomer("");
    }
}
