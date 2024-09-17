package ltweb05.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {

	private static String USERNAME = "root";
	private static String PASSWORD = "Donggiasang1."; //Your passwork
	private static String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	private static String URL = "jdbc:mysql://localhost:3306/05_09_2024";//your db name

	public static Connection getDatabaseConnection() throws SQLException, Exception{
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
        	new DBConnectMySQL();
            System.out.println(DBConnectMySQL.getDatabaseConnection());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
