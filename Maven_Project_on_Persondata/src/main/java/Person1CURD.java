import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Person1CURD {

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fileInputStream = new FileInputStream("personrepo.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		
		Connection connection =DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
				
		return connection;
		
	}
	
	public void savePerson(Person1 person1) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO personrepo VALUES(?,?,?)");
		preparedStatement.setInt(1, person1.getId());
		preparedStatement.setString(2, person1.getName());
		preparedStatement.setString(3, person1.getEmail());
		int count = preparedStatement.executeUpdate();
		
		if(count ==1 ) {
			System.out.println("Data inserted successfullly");
		}else {
			System.out.println("Data not inserted");
		}
		connection.close();
	}
	
	public void UpdatePerson1(Person1 person1) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE personrepo SET name =? email=? WHERE id=?");
		preparedStatement.setInt(1, person1.getId());
		preparedStatement.setString(2, person1.getName());
		preparedStatement.setString(3, person1.getEmail());
		
		int count = preparedStatement.executeUpdate();
		
		if(count ==1) {
			System.out.println("Data Update successfully");
		}else {
			System.out.println("Data not Update");
		}
		
		connection.close();
	}
	
	public void deletePerson1(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM personrepo WHERE id =? ");
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Delete successfully");
		}else {
			System.out.println("not deleted");
		}
		connection.close();
		
	}
	
	public void getPerson1ById(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM personrepo WHERE id =? ");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString("name"));
			System.out.println(resultSet.getString("email"));
		}
		connection.close();
		
	}
	public void getAllPerson1() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM personrepo");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString("email"));
		}
		connection.close();
	}
	
	
}
