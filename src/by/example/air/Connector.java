package by.example.air;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connector {
	public static final String URL = "jdbc:mysql://localhost:3333/airport?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF8";
	private static Connection db = null;
	public static Connection getDatabase() {
		if(db == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				db = DriverManager.getConnection(URL, "root", "admin");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return db;
	}
}
