package ltweb05.config;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConnectSQLServer {

	public static Connection connectDB(){

        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=DB1;user=zubair;password=zubair1234");
                //JOptionPane.showMessageDialog(null,"Connection established");
                return conn;
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            return null;
        }
    }
}
