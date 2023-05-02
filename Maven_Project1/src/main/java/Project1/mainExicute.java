package Project1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class mainExicute {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the id ");
		int id = scanner.nextInt();
		System.out.println("Enter the name");
		String name = scanner.next();
		System.out.println("Enter the email");
		String email = scanner.next();
		
		PersonCRUD crud = new PersonCRUD();
		
		try {
			crud.saveperson(id, name, email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
