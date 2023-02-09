package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLJTDSConnection {
	public static Connection getSQLJTDSConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationfc";
		String userName = "sa";
		String password = "Chuem1976";
		return getSQLJTDSConnection(hostName, sqlInstanceName, database, userName, password);
	}
	private static Connection getSQLJTDSConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;
		try {
			// khai bao class driver cho mysql
			// viec nay can thiet voi java 5
			// java 6 tu dong tim kiem driver thich hop - ko bat buoc can dong nay
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver");
			// cau truc URL connection danh cho mysql
			// vi du: jdbc:mysql://localhost:1433/automationfc
			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":57569/" + database + ";instance" + sqlInstanceName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}


}
