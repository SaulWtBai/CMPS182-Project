package dataBasePart;

/**
 * Return a list of phone numbers of customers, given a first name and last name.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class getCustomerPhoneFromFirstLastName extends ActionSupport  {
	private String firstName;
	private String lastName;
	private String phone;
	
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
					"SELECT a.phone " +
					"FROM mg_customers AS c " +
					"INNER JOIN dv_address AS a " +
					"ON c.address_id = a.address_id " +
					"WHERE c.first_name = ? " +
					"AND c.last_name = ? ";

			PreparedStatement stmt = connection.prepareStatement(query);
			System.out.println("after PreparedStatement !");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			System.out.println("after set query !");
			ResultSet res = stmt.executeQuery();
			if (res == null) System.out.println("ResultSet is null !");
			while(res.next()) {
				phone = res.getString(1);
				System.out.println("phone is " + phone);
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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
