package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. Load or register a Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dmart","root","Rutvikbh@9960");
		
		//3. Create Statement
		Statement statement = connection.createStatement();
		
		//4.Execute statement
//		statement.execute("INSERT INTO shop VALUES(2,'Cloth','T-shart', 56879)");
		statement.execute("INSERT INTO shop VALUES(3,'Shoes','lower', 78954)");
		//5.Colse connection
		connection.close();

	}

}
