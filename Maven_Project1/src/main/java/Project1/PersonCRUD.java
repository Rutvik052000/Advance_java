package Project1;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PersonCRUD {

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fileInputStream = new FileInputStream("persondb.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection= DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		return connection;
		
	}
	public void saveperson(int id, String name, String email) throws ClassNotFoundException, IOException, SQLException{
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person VALUES(?,?,?)"); 
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, email);
		
		int count = preparedStatement.executeUpdate();
		
		if(count==1) {
			System.out.println("Data inserted Succesfully");
		}else {
			System.out.println("Data not inserted");
		}
		
		connection.close();
	}
	
}
