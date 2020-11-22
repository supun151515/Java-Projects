import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class JConnection {
    public static Connection ConnectorDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://snk.extremeits.biz/snkmarine", "snkmarine","Iddqd@123");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/extremeits", "root","supun123");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to connect to the server. Please contact your system administrator");
            System.exit(0);
            return null;
        }
    }
}
