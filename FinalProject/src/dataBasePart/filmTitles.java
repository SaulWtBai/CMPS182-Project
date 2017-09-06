package dataBasePart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class filmTitles extends ActionSupport  {
	private int length1;
	private int length2;
	private String name;
	
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
					"SELECT title " +
					"FROM dv_film " +
					"WHERE length >= ? " +
					"AND   length <= ? " ;

			PreparedStatement stmt = connection.prepareStatement(query);
			System.out.println("after PreparedStatement !");
			stmt.setInt(1, length1);
			stmt.setInt(2, length2);
			
			ResultSet res = stmt.executeQuery();
			if (res == null) 
				System.out.println("ResultSet is null !");
			System.out.println("Before the while loop !");
			while(res.next()) {
				name = res.getString(1); //Get first attribute
				returnCase = SUCCESS;
				//String attribute2 = res.getString(2); //Get first attribute
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
	
	public int getLength1() {
		return length1;
	}
	
	public void setLength1(int length1) {
		this.length1 = length1;
	}
	
	public int getLength2() {
		return length2;
	}
	
	public void setLength2(int length2) {
		this.length2 = length2;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
