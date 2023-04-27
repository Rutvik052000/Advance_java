package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class insertemployeedata {

	public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id ");
		int id = scanner.nextInt();
		System.out.println("Enter the name of employee");
		String name = scanner.next();
		System.out.println("Enter a phone of employee");
		long phone = scanner.nextLong();
		System.out.println("Enter the salary of employee");
		int salary = scanner.nextInt();
		
		String url = "jdbc:mysql://localhost:3306/employeedb1?user=root&password=Rutvikbh@9960";
		String query = "INSERT INTO employeedb1.employeedata VALUES(?,?,?,?)";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection(url);
		
		PreparedStatement preparedstatement = connection.prepareStatement(query);
		
		preparedstatement.setInt(1, id);
		preparedstatement.setString(2, name);
		preparedstatement.setLong(3,phone);
		preparedstatement.setInt(4, salary);
		
		int count = preparedstatement.executeUpdate();
		
		if(count==1) {
			System.out.println("Data inserted sucessfully");
		}else {
			System.out.println("Date not inserted sucessfully");
		}
		connection.close();
				

	}

}
