package log4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee extends Dbconn{
	private String fullname;
	private int contactNum;
	private String departmentWorkFor;
	
	Employee(String fullname, int contactNum, String departmentWorkFor){
		this.fullname = fullname;
		this.contactNum = contactNum;
		this.departmentWorkFor = departmentWorkFor;
	}

	@Override
	public void insertData() throws SQLException {
		String query = "INSERT INTO employee (fullname, contact_number, department_work_for) VALUES (?,?,?)";
		PreparedStatement stmt = super.conn.prepareStatement(query);
		stmt.setString(1, fullname);
		stmt.setInt(2, contactNum);
		stmt.setString(3, departmentWorkFor);
		stmt.execute();
		stmt.close();
	}

	@Override
	public void retrieveData() throws SQLException {
		String query = "Select * from employee";
		Statement stmt = super.conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			int id = rs.getInt("id");
			String fullname = rs.getString("fullname");
			int contact_Number = rs.getInt("contact_number");
			String department_work_for = rs.getString("department_work_for");
			System.out.println("ID: " + id + " Fullname: " + fullname + " Contact Number: " + contact_Number + " Department woking for: " + department_work_for);
		}
	}

	@Override
	public void deleteData() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRecord() throws SQLException {
		String query = "UPDATE employee SET  fullname ='Tej' where id=1";
		try {
			PreparedStatement stmt = super.conn.prepareStatement(query);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void createConnection() throws SQLException {
		super.createConnection();
	}
	
	

}
