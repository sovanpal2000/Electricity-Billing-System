package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Generatebill extends JFrame implements ActionListener{
   
   String meter;
   JButton bill;
   Choice cmonth;
   JTextArea area;
   Generatebill(String meter){
   this.meter= meter;
  
   setSize(500,700);
   setLocation(550,30);
   setLayout(new BorderLayout());
   JPanel panel = new JPanel();
   JLabel heading = new JLabel("Generate Bill");
   JLabel meternumber = new JLabel(meter);
   
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
     
     area= new JTextArea(50,15);
     area.setText("\n\n\t--------Click On The--------\n\t Generate bill button to get \n\t the bill of the selected Month");
     area.setFont(new Font("Senserif",Font.ITALIC, 18));
     
     JScrollPane pane = new JScrollPane(area);
     
     bill = new JButton("Generate Bill");
     bill.addActionListener(this);
     
     
     panel.add(heading);
     panel.add(meternumber);
     panel.add(cmonth);
     add(panel,"North");
     
     add(pane,"Center");
     add(bill,"South");
     
   
   setVisible(true);

   }
   
public void actionPerformed(ActionEvent ae){

    try{
        Conn c = new Conn();
        String month = cmonth.getSelectedItem();
        area.setText("\t      CESC\nELECTRICITY BILL GENERATED FOR THE MONTH \n\t"+month+" 2022\n\n\n");
        
        ResultSet rs = c.s.executeQuery("Select * from customer2 where METER_NUMBER='"+meter+"'");
        if(rs.next()){
        area.append("\n         Customer Name :"+rs.getString("cname"));
        area.append("\n         Meter Number  :"+rs.getString("METER_NUMBER"));
        area.append("\n         Adress        :"+rs.getString("address"));
        area.append("\n         State         :"+rs.getString("state"));
        area.append("\n         City          :"+rs.getString("city"));
        area.append("\n         Number        :"+rs.getString("phnumber"));
        area.append("\n         Email         :"+rs.getString("email"));
        area.append("\n-----------------------------------------------");
        area.append("\n");
        }
        
        rs = c.s.executeQuery("Select * from meter_info where METER='"+meter+"'");
        if(rs.next()){
        area.append("\n         Meter Number :"+rs.getString("METER"));
        area.append("\n         Meter Location :"+rs.getString("location"));
        area.append("\n         Meter Type        :"+rs.getString("type"));
        area.append("\n         Phase Code         :"+rs.getString("code"));
        area.append("\n         Bill Type          :"+rs.getString("btype"));
        area.append("\n         Days       :"+rs.getString("days"));
        area.append("\n-----------------------------------------------");
        area.append("\n");    
    }
        rs = c.s.executeQuery("Select * from tax");
        if(rs.next()){
 
        area.append("\n");
        area.append("\n         Cost Per Unit         :"+rs.getString("cost_per_unit"));
        area.append("\n         Meter Rent          :"+rs.getString("meter_rent"));
        area.append("\n         Service Charge       :"+rs.getString("service_charge"));
        area.append("\n         Service Tax       :"+rs.getString("service_tax"));
        area.append("\n         Swach Bharat Cess      :"+rs.getString("swacch_bharat_cess"));
        area.append("\n         Fixed Tax       :"+rs.getString("fixed_tax"));
        area.append("\n");
        }
        
        rs = c.s.executeQuery("Select * from bill where meter_no='"+meter+"'and month = '"+month+"'");
        if(rs.next()){
 
        area.append("\n");
        area.append("\n         Current Month        :"+rs.getString("month"));
        area.append("\n         Units Consumed        :"+rs.getString("units"));
        area.append("\n         Total Charges       :"+rs.getString("totalbill"));
        area.append("\n-------------------------------------------------------------");
        area.append("\n         Total Payable       :"+rs.getString("totalbill"));
        }
    }
    catch (Exception e){
    e.printStackTrace();
    }
}
   
   public static void main(String[] args)
   {     
   new Generatebill(""); 
   }
}
