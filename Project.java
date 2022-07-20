package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{ 
    String meter,atype,meterno;
   Project(String atype,String meter1,String meterno)
   {  
       this.meterno=meterno;
    meter=meter1;
    this.atype=atype;
   setExtendedState(JFrame.MAXIMIZED_BOTH);
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
   Image i2 = i1.getImage().getScaledInstance(1550, 850,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel Image = new JLabel(i3);
   add(Image);
   JMenuBar mb = new JMenuBar();
   setJMenuBar(mb);
   // Master
   JMenu Master = new JMenu("Master");
   
   Master.setForeground(Color.blue);
   
   JMenuItem New_customer = new JMenuItem("New_customer");
   New_customer.setFont(new Font("monospaced",Font.PLAIN,12));
   New_customer.setBackground(Color.WHITE);
   ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
   Image image1 = icon1.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   New_customer.setIcon(new ImageIcon(image1));
   New_customer.setMnemonic('A');
   New_customer.addActionListener(this);
   New_customer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
   Master.add(New_customer);
   
   JMenuItem Customer_details = new JMenuItem("Customer_details");
   Customer_details.setFont(new Font("monospaced",Font.PLAIN,12));
   Customer_details.setBackground(Color.WHITE);
   ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
   Image image2 = icon2.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Customer_details.setIcon(new ImageIcon(image2));
   Customer_details.setMnemonic('B');
   Customer_details.addActionListener(this);
   Customer_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
   Master.add(Customer_details);
   
   JMenuItem Deposit_details = new JMenuItem("Deposit_details");
   Deposit_details.setFont(new Font("monospaced",Font.PLAIN,12));
   Deposit_details.setBackground(Color.WHITE);
   ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
   Image image3 = icon3.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Deposit_details.setIcon(new ImageIcon(image3));
   Deposit_details.setMnemonic('C');
   Deposit_details.addActionListener(this);
   Deposit_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
   Master.add(Deposit_details);
   
   JMenuItem Calculate_bill = new JMenuItem("Calculate_bill");
   Calculate_bill.setFont(new Font("monospaced",Font.PLAIN,12));
   Calculate_bill.setBackground(Color.WHITE);
   ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
   Image image4 = icon4.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Calculate_bill.setIcon(new ImageIcon(image4));
   Calculate_bill.setMnemonic('D');
   Calculate_bill.addActionListener(this);
   Calculate_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
   Master.add(Calculate_bill);
   
   // Information
   JMenu Information = new JMenu("Information");
   
   Information.setForeground(Color.red);
   
   JMenuItem Update_information = new JMenuItem("Update_information");
   Update_information.setFont(new Font("monospaced",Font.PLAIN,12));
   Update_information.setBackground(Color.WHITE);
   ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
   Image image5 = icon5.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Update_information.setIcon(new ImageIcon(image5));
   Update_information.setMnemonic('E');
   Update_information.addActionListener(this);
   Update_information.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
   Information.add(Update_information);
   
   JMenuItem View_information = new JMenuItem("View_information");
   View_information.setFont(new Font("monospaced",Font.PLAIN,12));
   View_information.setBackground(Color.WHITE);
   ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
   Image image6 = icon6.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   View_information.setIcon(new ImageIcon(image6));
   View_information.setMnemonic('F');
   View_information.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
   View_information.addActionListener(this);
   Information.add(View_information);
   
   //User
   JMenu User = new JMenu("User");
   
   User.setForeground(Color.blue);
   
   JMenuItem Pay_bill = new JMenuItem("Pay_bill");
   Pay_bill.setFont(new Font("monospaced",Font.PLAIN,12));
   Pay_bill.setBackground(Color.WHITE);
   ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
   Image image7 = icon7.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Pay_bill.setIcon(new ImageIcon(image7));
   Pay_bill.setMnemonic('G');
   Pay_bill.addActionListener(this);
   Pay_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
   User.add(Pay_bill);
   
   JMenuItem Bill_details = new JMenuItem("Bill_details");
   Bill_details.setFont(new Font("monospaced",Font.PLAIN,12));
   Bill_details.setBackground(Color.WHITE);
   ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
   Image image8 = icon8.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Bill_details.setIcon(new ImageIcon(image8));
   Bill_details.setMnemonic('H');
   Bill_details.addActionListener(this);
   Bill_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
   User.add(Bill_details);
   
   //Report
   JMenu Report = new JMenu("Report");
 
   Report.setForeground(Color.red);
   
   JMenuItem Generate_bill = new JMenuItem("Generate_bill");
   Generate_bill.setFont(new Font("monospaced",Font.PLAIN,12));
   Generate_bill.setBackground(Color.WHITE);
   ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
   Image image9 = icon9.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Generate_bill.setIcon(new ImageIcon(image9));
   Generate_bill.setMnemonic('I');
   Generate_bill.addActionListener(this);
   Generate_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
   Report.add(Generate_bill);
   
   //Utility
   JMenu Utility = new JMenu("Utility");
   
   Utility.setForeground(Color.blue);
   
   JMenuItem Notepad = new JMenuItem("Notepad");
   Notepad.setFont(new Font("monospaced",Font.PLAIN,12));
   Notepad.setBackground(Color.WHITE);
   ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
   Image image10 = icon10.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Notepad.setIcon(new ImageIcon(image10));
   Notepad.setMnemonic('J');
   Notepad.addActionListener(this);
   Notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
   Utility.add(Notepad);
   
   JMenuItem Calculator = new JMenuItem("Calculator");
   Calculator.setFont(new Font("monospaced",Font.PLAIN,12));
   Calculator.setBackground(Color.WHITE);
   ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
   Image image11 = icon11.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
   Calculator.setIcon(new ImageIcon(image11));
   Calculator.setMnemonic('K');
   Calculator.addActionListener(this);
   Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K ,ActionEvent.CTRL_MASK));
   Utility.add(Calculator);
   
   //Exit
   JMenu Exit = new JMenu("Exit");
   
   Exit.setForeground(Color.red);
   
   JMenuItem exit = new JMenuItem("exit");
   exit.setFont(new Font("monospaced",Font.PLAIN,12));
   exit.setBackground(Color.WHITE);
   exit.addActionListener(this);
   ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
   Image image12 = icon12.getImage().getScaledInstance(20, 20,20); // problem in this line , cannot get the method 
  exit.setIcon(new ImageIcon(image12));
   exit.setMnemonic('L');
   exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
   Exit.add(exit);
   if(atype.equals("Admin"))
   {
   mb.add(Master);
   }
   else
   {
   mb.add(Information);
   mb.add(User);
   mb.add(Report);
   }
   mb.add(Utility);
   mb.add(Exit);
   
   setLayout(new FlowLayout());
   setVisible(true); 
   } 
   
   public void actionPerformed(ActionEvent ae){
   String msg = ae.getActionCommand();
   if(msg.equals("New_customer")){
       new Newcustomer();
   } else if(msg.equals("Customer_details")){
       new CustomerDetails();
   } else if(msg.equals("Deposit_details")){
       new DepositDetails();
   } else if(msg.equals("Calculate_bill")){
       new CalculateBill();
   }else if(msg.equals("View_information"))
   {
       new ViewInformation(meter);
   }
   else if(msg.equals("Update_information"))
   {
       new UpdateCustomer(meterno);
   }else if(msg.equals("Bill_details"))
   {
       new Billdetails(meterno);
   }
     else if(msg.equals("Notepad"))
   {
       try{
           Runtime.getRuntime().exec("notepad.exe");
           
       }catch(Exception e)
       {
           e.printStackTrace();
       }
   }else if(msg.equals("Calculator"))
   {
       try{
           Runtime.getRuntime().exec("calc.exe");
           
       }catch(Exception e)
       {
           e.printStackTrace();
       }
   }
   else if(msg.equals("exit"))
   {
       setVisible(false);
       new login();
   }
   else if(msg.equals("Pay_bill"))
   {
       new Paybill (meterno);
   }
   else if(msg.equals("Generate_bill"))
   {
       new Generatebill(meterno);
   }
   
  } 
   public static void main(String[] args)
   {
   new Project(" "," "," "); 
   }
}