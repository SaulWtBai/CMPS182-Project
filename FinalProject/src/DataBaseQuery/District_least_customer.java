package DataBaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
/*
search the districts that has the least number of customers?
*/
public class District_least_customer extends ActionSupport {
//	private String districts;
	private Map<String, Integer> districts;
	private int number;
	public String execute() throws Exception {
		String returnCase = ERROR;
		Connection connection = null;
//		districts = "";
		districts = new HashMap<>();
		//try catch
		try {
			System.out.println("In the first try !");
			Class.forName("org.postgresql.Driver");  //Registering the driver
			System.out.println("after Registering the driver !");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qweiop123890");
			System.out.println("after drive the connection !");
			String query =
					"SELECT district,count(district) " +
					"FROM dv_address, mg_customers " +
					"WHERE dv_address.address_id = mg_customers.address_id " +
					"GROUP BY district " +
					"ORDER BY count(district) ASC" +
					"LIMIT + ? ;";

			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, number);
			
			ResultSet res = stmt.executeQuery();
			if (res == null) 
				System.out.println("ResultSet is null !");
			System.out.println("Before the while loop !");
			while(res.next()) {
				if (res.getString(1) != "")
					districts.put(res.getString(1), res.getInt(2));
				returnCase = SUCCESS;
				//String attribute2 = res.getString(2); //Get first attribute
			}
			System.out.println("success");
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

	public Map<String, Integer> getDistricts() {
		return districts;
	}
	
	public void setDistricts(Map<String, Integer> name) {
		districts = name;
	}
	
	public int getName() {
		return number;
	}
	
	public void setName(int number) {
		this.number = number;
	}
}
