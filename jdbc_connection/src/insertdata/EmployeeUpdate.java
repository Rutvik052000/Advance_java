package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeUpdate {

	public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a id");
		int id = scanner.nextInt();
		System.out.println("Enter a name");
		String name = scanner.next();
		System.out.println("Enter a phone");
		long phone = scanner.nextLong();
		System.out.println("Enter a salary");
		int salary = scanner.nextInt();
		
		String url = "jdbc:mysql://localhost:3306/employeedb1?user=root&password=Rutvikbh@9960";
		String query = "UPDATE employeedata SET name=?, phone=?, salary=? WHERE id =?";
//		String query = "DELETE FROM studentdata WHERE id=?";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection(url);
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,name);
		preparedStatement.setLong(2,phone);
		preparedStatement.setInt(3, salary);
		preparedStatement.setInt(4, id);
		
		int count = preparedStatement.executeUpdate();
		
		if(count==1) {
			System.out.println("Data is updated");
		}
		else {
			System.out.println("Data is not updated");
		}
		connection.close();


	}

}
