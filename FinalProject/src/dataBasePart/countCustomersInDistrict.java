package dataBasePart;

/**
 * Return the number of customers that live in a given district and have the given active status.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class countCustomersInDistrict extends ActionSupport  {
	private String districtName;
	private boolean active;
	private int countNum;
	
	public String execute() throws Exception {
		String returnCase = ERROR;
		Connection connection = null;
		try {
			System.out.println("In the first try !");
			Class.forName("org.postgresql.Driver");  //Registering the driver
			System.out.println("after Registering the driver !");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qweiop123890");
			System.out.println("after drive the connection !");
			String query =
					"SELECT count(*) " +
					"FROM mg_customers as c " +
					"INNER JOIN dv_address as a " +
					"ON c.address_id = a.address_id " +
					"WHERE c.active = ? " + 
					"AND a.district = ?";

			PreparedStatement stmt = connection.prepareStatement(query);
			System.out.println("after PreparedStatement !");
			stmt.setBoolean(1, active);
			stmt.setString(2, districtName);
			System.out.println("after set query !");
			ResultSet res = stmt.executeQuery();
			if (res == null) System.out.println("ResultSet is null !");
			while(res.next()) {
				countNum = res.getInt(1);
				System.out.println("countNum is " + countNum);
				returnCase = SUCCESS;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("In the first catch !");
			System.out.println(e.getMessage());
			returnCase = ERROR;
		} finally {
			if (connection != null) {
				try{
					connection.close();
				} catch (Exception e) {
					
				}
			}
		}
		return returnCase;
	}
	
	public String getName() {
		return districtName;
	}
	
	public void setName(String districtName) {
		this.districtName = districtName;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public void setActive(String active) {
		this.active = Boolean.valueOf(active);
	}
	
	public int getCountNum() {
		return countNum;
	}
	
	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}
}
