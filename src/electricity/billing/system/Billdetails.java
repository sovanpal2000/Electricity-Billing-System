package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Billdetails extends JFrame {
    String meter;
    Billdetails(String meter)
    {
        this.meter=meter;
        setBounds(400,200,600,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JTable table=new JTable();
        try{
            Conn c=new Conn();
            String query="Select * from bill where meter_no='"+meter+"'";
            ResultSet rs=c.s.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(rs));
                    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane js=new JScrollPane(table);
        js.setBounds(0,0,600,400);
        add(js);
        
        
        setVisible(true);
        
    }
    public static void main(String ars[])
    {
        new Billdetails("");
    }
}
