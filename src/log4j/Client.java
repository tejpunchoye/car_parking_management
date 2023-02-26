package log4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client extends Dbconn {
	private String fullName;
	private int contactNumber;
	private String address;
	private long NIC;
	private int parkingNo;
	private String parkingType;
	

	@Override
	public void createConnection() throws SQLException {
		super.createConnection();
	}
	
	Client(String fullName, int contactNumber, String address, long NIC, int parkingNo, String parkingType){
		this.fullName = fullName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.NIC = NIC;
		this.parkingNo = parkingNo;
		this.parkingType = parkingType;
	}
	
	@Override
	public void insertData() {
		try {
			String query = "INSERT INTO client (fullName, contactNum, address, NIC_num, parking_reserving, parkingType) VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt = super.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, this.fullName);
			stmt.setInt(2, this.contactNumber);
			stmt.setString(3, this.address);
			stmt.setLong(4, this.NIC);
			stmt.setInt(5, this.parkingNo);
			stmt.setString(6, this.parkingType);
			
			stmt.execute();
			stmt.close();
		}catch(SQLException ex) {
			
		}
	}
	public void retrieveData() throws SQLException{
		String query = "SELECT * from client";
		Statement stmt = super.conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			int id = rs.getInt("id");
			String fullname = rs.getString("fullName");
			int contactNum = rs.getInt("contactNum");
			String address = rs.getString("address");
			int NIC = rs.getInt("NIC_num");
			int parking_reserving = rs.getInt("parking_reserving");
			String parking_type = rs.getString("parkingType");
			
			System.out.println("ID: "  + id + " Full Name: "  + fullname + " Contact Number: "+ contactNum + " Address: " + address
					+ " NIC " +   NIC + " Parking Reserving " + parking_reserving + " Parking Type " + parking_type);
		}
	}
	@Override
	public void updateRecord() throws SQLException {
		String query = "UPDATE client SET  fullname ='Tej' where id=4";
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
	public void deleteData() throws SQLException {
		String query = "DELETE from client where parkingType = 'normal'";
		try {
			PreparedStatement stmt = super.conn.prepareStatement(query);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

//public int getParkingNo() {
//	return parkingNo;
//}
//public void setParkingNo(String parkingNo) {
//	parkingNo = parkingNo;
//}
//public String getParkingType() {
//	return parkingType;
//}
//public void setParkingType(String parkingType) {
//	this.parkingType = parkingType;
//}
//public void setNIC(long nIC) {
//	NIC = nIC;
//}
//public String getFullName() {
//	return fullName;
//}
//public void setFullName(String fullName) {
//	this.fullName = fullName;
//}
//public int getContactNumber() {
//	return contactNumber;
//}
//public void setContactNumber(int contactNumber) {
//	this.contactNumber = contactNumber;
//}
//public String getAddress() {
//	return address;
//}
//public void setAddress(String address) {
//	this.address = address;
//}
//public long getNIC() {
//	return NIC;
//}
//public void setNIC(int nIC) {
//	NIC = nIC;
//}
