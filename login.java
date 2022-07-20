
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener {
    JButton Login,signup,cancel;
    JTextField username,password;
    Choice login1;
    
    login()
    {
        
        super("LOGIN PAGE");
        getContentPane().setBackground(Color.blue);
        setLayout(null);
       
       JLabel uname=new JLabel("USER NAME");
       uname.setBounds(50,30,150,20);
       add(uname);
       username = new JTextField();
       username.setBounds(250,30,200,30);
       add(username);
       JLabel pass=new JLabel("PASSWORD");
       pass.setBounds(50,80,150,20);
       add(pass);
       password = new JTextField();
       password.setBounds(250,80,200,30);
       add(password);
       JLabel loginas=new JLabel("Log in as");
       loginas.setBounds(50,130,150,20);
       add(loginas);
       login1=new Choice();
       login1.setBounds(250,130,200,30);
       login1.add("Admin");
       login1.add("Customer");
       add(login1);
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
       Image i2=i1.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        Login =new JButton("LOG IN", new ImageIcon(i2));
       Login.setBounds(100, 190,100,30);
       Login.addActionListener(this);
       add(Login);
       ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
       Image i4=i3.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        cancel =new JButton("CANCEL", new ImageIcon(i4));
       cancel.setBounds(250, 190,150,30);
       cancel.addActionListener(this);
       add(cancel);
       ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
       Image i6=i5.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        signup =new JButton("SIGN UP", new ImageIcon(i6));
       signup.setBounds(200, 250,150,30);
       signup.addActionListener(this);
       add(signup);
       
       setSize(600,400);
       setLocation(600,200);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Login)
        {
            String susername=username.getText();
            String spassword=password.getText();
            String user=login1.getSelectedItem();
            try
            {
                Conn c =new Conn();
                String query="select * from login where user_name='"+susername+"' and password='"+spassword+"' and ACCOUNT_TYPE='"+user+"' ";
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next())
                {
                    String meter=rs.getString("METER_NO");
                    
                   setVisible(false);
                   new Project(user,rs.getString("METER_NO"),rs.getString("METER_NO"));
                }
                else
                {
                   JOptionPane.showMessageDialog(null,"Invalid Username or Password"); 
                   username.setText("");
                   password.setText("");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new signup();
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String ars[])
    {
        new login();
    }
}
