/** 
 * 
 * */

package log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);
	Connection conn;

	public static void main(String[] args) throws SQLException {
		String log4jConfigFile = "C:\\Users\\User\\Desktop\\Java\\Workspace\\car_management_system\\log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
		
//		Client c = new Client("Tej Punchoye", 57913101, "Glen Park Vacoas Buxoo Lane", 596325145, 21, "Premium");
//		c.createConnection();
//		c.deleteData();
		
		
		Employee e = new Employee("Tej Punchoye", 57913101, "Premium");
		e.createConnection();
		e.updateRecord();
	}
}