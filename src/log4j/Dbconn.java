package log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dbconn {
	Connection conn;
	
	public void createConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3307/car_park";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Loading the driver
			this.conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection created");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
//			logger.getLogger(Main.class.getName()).log(null, ex);
		}
	}
	
	public abstract void insertData() throws SQLException;
	public abstract void retrieveData() throws SQLException;
	public abstract void deleteData() throws SQLException;
	public abstract void updateRecord() throws SQLException;
	
}
