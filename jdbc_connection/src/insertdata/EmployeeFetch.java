package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeFetch {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a id of Employee");
		int id =scanner.nextInt();
		
		String url = "jdbc:mysql://localhost:3306/employeedb1?user=root&password=Rutvikbh@9960";
		String query = "SELECT * FROM employeedata WHERE id=?";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection(url);
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString("name"));
			System.out.println(resultSet.getLong("phone"));
			System.out.println(resultSet.getInt(4));
	}
		connection.close();

}
}
