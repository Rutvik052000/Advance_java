package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Deletedata {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dmart","root","Rutvikbh@9960");
				
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("DELETE FROM shop WHERE idshop =1");
		
		connection.close();
	}

}
