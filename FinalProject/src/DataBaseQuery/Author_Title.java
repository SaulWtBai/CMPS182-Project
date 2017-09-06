package DataBaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
/*
search the first name, last name and title for each book in city books.
*/
public class Author_Title extends ActionSupport {
//	private String districts;
	private List<String> books;
	public String execute() throws Exception {
		String returnCase = ERROR;
		Connection connection = null;
		books = new ArrayList<>();
		//try catch
		try {
			System.out.println("In the first try !");
			Class.forName("org.postgresql.Driver");  //Registering the driver
			System.out.println("after Registering the driver !");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qweiop123890");
			System.out.println("after drive the connection !");
			String query =
					"SELECT cb_authors.first_name, cb_authors.last_name, cb_books.title " +
					"FROM cb_books, cb_authors " +
					"WHERE cb_books.author_id = cb_authors.author_id;";

			PreparedStatement stmt = connection.prepareStatement(query);
			
			ResultSet res = stmt.executeQuery();
			if (res == null) 
				System.out.println("ResultSet is null !");
			System.out.println("Before the while loop !");
			while(res.next()) {
				String value = res.getString(1) + ", " + res.getString(2) + ", " + res.getString(3);
				books.add(value);
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
	
//	public String getDistricts() {
//		return districts;
//	}
	public List<String> getBooks() {
		return books;
	}
	
//	public void setDistricts(String name) {
	public void setDistricts(List<String> list) {
		books = list;
	}
}
