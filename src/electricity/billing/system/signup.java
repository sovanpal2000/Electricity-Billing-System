
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener
{
    JButton create,back;
    Choice ch;
    JTextField meterno,unm,name1,pass1;
    signup()
    {
        super("SIGN UP PAGE");
        setSize(700,400);
        setLocation(600,200);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
         
        JPanel panel= new JPanel();
        panel.setBounds(20,20, 650, 320);
        panel.setBorder(new TitledBorder(new LineBorder(Color.blue),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,Color.blue));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        add(panel);
        JLabel i2=new JLabel("Create  Account");
        i2.setBounds(70,50,120,20);
        i2.setForeground(Color.GRAY);
        i2.setFont(new Font("Tahama",Font.BOLD,14));
        panel.add(i2);
        ch=new Choice();
        ch.add("Admin");
        ch.add("Customer");
        ch.setBounds(210,50,200,30);
        panel.add(ch);
        
        JLabel meter=new JLabel("Meter Number");
        meter.setBounds(70,80,120,20);
        meter.setForeground(Color.GRAY);
        meter.setFont(new Font("Tahama",Font.BOLD,14));
        panel.add(meter);
        //meter.setVisible(false);
        
         meterno= new JTextField();
        meterno.setBounds(210, 80, 200, 20);
        panel.add(meterno);
        
        JLabel uname=new JLabel("User Name");
        uname.setBounds(70,110,120,20);
        uname.setForeground(Color.GRAY);
        uname.setFont(new Font("Tahama",Font.BOLD,14));
        panel.add(uname);
        
        unm= new JTextField();
        unm.setBounds(210, 110, 200, 20);
        panel.add(unm);
        
        JLabel name=new JLabel("Full Name");
        name.setBounds(70,140,120,20);
        name.setForeground(Color.GRAY);
        name.setFont(new Font("Tahama",Font.BOLD,14));
        panel.add(name);
        
        name1= new JTextField();
        name1.setBounds(210, 140, 200, 20);
        panel.add(name1);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(70,170,120,20);
        pass.setForeground(Color.GRAY);
        pass.setFont(new Font("Tahama",Font.BOLD,14));
        panel.add(pass);
        
        pass1= new JTextField();
        pass1.setBounds(210, 170, 200, 20);
        panel.add(pass1);
        
    
        
         create =new JButton("Create");
        create.setBounds(100,210,90,20);
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        create.addActionListener(this);
        panel.add(create);
        
         back =new JButton("BACK");
        back.setBounds(240,210,100,20);
        back.setBackground(Color.gray);
        back.setForeground(Color.blue);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon im= new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
       Image i6=im.getImage().getScaledInstance(240,240, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i6);
        JLabel img=new JLabel(i3);
        img.setBounds(420,20,240,240);
        panel.add(img);
     setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==create)
        {
            String atype=ch.getSelectedItem();
            String uname=unm.getText();
            String name=name1.getText();
            String pass=pass1.getText();
            String meterno1=meterno.getText();
            try{
                Conn c=new  Conn();
                String query="Insert into login values('"+meterno1+"','"+uname+"','"+name+"','"+pass+"','"+atype+"')";
                c.s.executeUpdate(query);//this function used for dml commend.
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new login();
            }
            catch(Exception e)
            {
                e.printStackTrace();;
            }
        }
        else
        {
            setVisible(false);
            new login();       
        }
        
    }
    public static void main(String ars[])
    {
        new signup();
    }
    
}
