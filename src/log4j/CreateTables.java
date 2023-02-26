package log4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables extends Dbconn{
	@Override
	public void createConnection() throws SQLException {
		super.createConnection();
	}
	//Creating tables
	void createEmployeeTable() throws SQLException {
		String query = "CREATE TABLE employee(" + "id integer AUTO_INCREMENT PRIMARY KEY," + "fullname varchar(80),"
				+ "contact_number integer," + "department_work_for varchar(20)" + ");";
		Statement stmt = super.conn.createStatement();
		stmt.execute(query);
		stmt.close();
	}

	void createParkingTypeTable() throws SQLException {
		String query = "CREATE TABLE parking(" + "id integer AUTO_INCREMENT PRIMARY KEY," + "parking_type varchar(20),"
				+ "department varchar(20)," + "employee_dept_id int," + "FOREIGN KEY (id) REFERENCES employee(id)"
				+ ");";
		Statement stmt = super.conn.createStatement();
		stmt.execute(query);
		stmt.close();
	}

	void createClientTable() throws SQLException {
		String query = "CREATE TABLE client(" + "id integer AUTO_INCREMENT PRIMARY KEY," + "fullName varchar(80),"
				+ "contactNum integer," + "address varchar(100)," + "NIC_num integer," + "parking_reserving integer,"
				+ "parkingType varchar(20)" + ");";

		Statement stmt = super.conn.createStatement();
		stmt.execute(query);
		stmt.close();
	}
	@Override
	public void insertData() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void retrieveData() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteData() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateRecord() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	

}
