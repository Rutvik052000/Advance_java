package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updatedata {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		// 1.register a load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Establish connection 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dmart","root","Rutvikbh@9960");
		
		//3.Create statement 
		
		Statement statement = connection.createStatement();
		
		
		// 4.Exicute a statement
		statement.execute("UPDATE shop SET name = 'ice-cream center' WHERE idshop = 1 ");
		
		//5.close connection 
		
		connection.close();

	}

}
