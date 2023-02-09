package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String dbName = "automationfc";
		String userName = "root";
		String password = "Chuem1976";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			// khai bao class driver cho mysql
			// viec nay can thiet voi java 5
			// java 6 tu dong tim kiem driver thich hop - ko bat buoc can dong nay
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver");
			// cau truc URL connection danh cho mysql
			// vi du: jdbc:mysql://localhost:3306/automationfc
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

}
