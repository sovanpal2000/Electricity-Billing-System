
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paytm extends JFrame implements ActionListener
{
    String meterno;
   paytm(String meterno)
   {
       setBounds(400,200,600,600);
       setLayout(null);
       this.meterno=meterno;
       JEditorPane j=new JEditorPane();
       j.setEditable(false);
       try{
           j.setPage("https://paytm.com/online-payments");
           
       }
       catch(Exception e)
       {
           j.setContentType("text/html");
           j.setText("<html> Could not load <html>");
       }
       JScrollPane pane=new JScrollPane(j);
       add(pane);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
       //ae.getSource()
   }
   public static void main(String ars[])
   {
       new paytm("");
   }
}
