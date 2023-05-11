package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeDeleteRows {

	public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a id of employee");
		int id = scanner.nextInt();
		
		String url = "jdbc:mysql://localhost:3306/employeedb1?user=root&password=Rutvikbh@9960";
		String query = "DELETE FROM employeedata WHERE id=?";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection(url);
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		int count = preparedStatement.executeUpdate(); //DML statement
		
		if(count ==1) {
			System.out.println("Delete data sucessfully"); 
		}else {
			System.out.println("Delete not do sucessfully");
		}
		connection.close();

	}

}
