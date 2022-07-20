
package electricity.billing.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn()
    {
        try
        {
          //Register the jdbc driver  
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      //Getting the connection
      String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
      c = DriverManager.getConnection(oracleUrl, "hr", "123456");
          s=c.createStatement();
        }
        
       catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String ars[])
    {
        new Conn();
        
    }
}
