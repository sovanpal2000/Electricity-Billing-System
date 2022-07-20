
package electricity.billing.system;
import javax.swing.*;
public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash()
    {
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        JLabel im= new JLabel(i1);
        add(im);
        setVisible(true);
        for(int i=2;i<500;i+=4)
        {
        setSize(i+90,i);
        setLocation(1000-i,400-(i/2));
        try
        {
            Thread.sleep(10);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        t=new Thread(this);
        t.start();
        setVisible(true);
    }
    public void run()
    {
        try{
          Thread.sleep(5000);
          setVisible(false);
          new login();
          
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }
    public static void main(String ars[])
    {
      new Splash();  
    }
}
