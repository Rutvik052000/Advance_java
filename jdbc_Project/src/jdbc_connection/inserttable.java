package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class inserttable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Rutvikbh@9960");
		
		Statement statement = connection.createStatement();
		
//		statement.execute("INSERT INTO usertable VALUES(2,'putvik Bhojane', 9960738040, 'putvikbhojane123@gmail.com', 'pass@123', 'wakad pune')");
//		
//		 connection.close();
		
		System.out.println("choice your valuable option :");
		System.out.println("1.To insert a data \n 2.To update a data \n 3.To delete a data \n 4.Fetch a data");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		switch(a) {
		
		case 1 : statement.execute("INSERT INTO usertable VALUES(3,'Jay ', 9960738041, 'jaywankhde123@gmail.com', 'pass@123', 'wakad pune')");
		
		 		 connection.close();
		 		 System.out.println("Your data is insert a sucessfully");
		 		 break;
		 
		case 2 : statement.execute("UPDATE usertable SET name = 'Jay Wankhade' WHERE id = 3" );
				 
				 connection.close();
				 System.out.println("your data is update sucessfully");
				 break;
		}
		
		
		
	}
}

