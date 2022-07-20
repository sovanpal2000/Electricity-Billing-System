package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class CustomerDetails extends JFrame implements ActionListener{ 
   JTable table;
   JButton print;
   
   CustomerDetails(){
   super("Customer Details");
   setSize(1200,650);
   setLocation(200,150);
    
   table = new JTable();
   
   try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer2");
        
        table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
    {
    e.printStackTrace();
    }
    
   JScrollPane jp = new JScrollPane(table);
   add(jp);
   
   print = new JButton("Print");
   print.addActionListener(this);
   add(print, "South");
   
    setVisible(true);
    }
   
    public void actionPerformed(ActionEvent ae){
    try{
        table.print();
    }catch (Exception e){
    e.printStackTrace();
    }
    }
    
       public static void main(String[] args)
   {     
   new CustomerDetails(); 
   }
}