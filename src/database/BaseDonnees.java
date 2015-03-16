package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BaseDonnees {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e) {
			System.out.println("Error Class.forName");
		}
	}
	
	private String url = null;
	private String user = null;
	private String password = null;
	
	Connection co = null;
	
	public void open() {
		if (url == null) {
			ResourceBundle rb = ResourceBundle.getBundle("base");
			url = rb.getString("url");
			System.out.println("url = "+url);
			user = rb.getString("user");
			System.out.println("user = "+user);
			password = rb.getString("password");
		}
		System.out.println("Openning mysql connection...");
		try {
			co = DriverManager.getConnection(url, user, password);
			System.out.println("Connection opened.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getConnection "+ e.getMessage());
		}
	}
	
	public void close() {
		System.out.println("Connection closed.");
		if (co != null) try {co.close();} catch (Exception e) {}
	}
}
