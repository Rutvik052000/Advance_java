import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Person1Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
	
		Scanner scanner = new Scanner(System.in);
		
		Person1 person1 = new Person1();
		
		Person1CURD person1curd = new Person1CURD();
		
		boolean condition = true;
		do {
			System.out.println("Enter the choice\n1.save Person1 \n2.Update Person1 \n3. Delete Person1 \n4. GetPerson1 by id \n5. Getall Person1 \n6.Exit");
			
			int choice = scanner.nextInt();
			switch(choice) {
			case 1: {
				System.out.println("Entet the id");
				int id = scanner.nextInt();
				System.out.println("Enter the name");
				String name = scanner.next();
				System.out.println("Enter the email");
				String email = scanner.next();
				
				person1.setId(id);
				person1.setName(name);
				person1.setEmail(email);
				
				person1curd.savePerson(person1);
			}
			break;
			case 2: {
				System.out.println("Entet the id");
				int id = scanner.nextInt();
				System.out.println("Enter the name");
				String name = scanner.next();
				System.out.println("Enter the email");
				String email = scanner.next();
				
				person1.setId(id);
				person1.setName(name);
				person1.setEmail(email);
				
				person1curd.UpdatePerson1(person1);
			}
			break;
			case 3 : {
				System.out.println("Enter a id ");
				int id = scanner.nextInt();
				
				person1.setId(id);
				
				person1curd.deletePerson1(id);
			}
			break;
			
			case 4 : {
				System.out.println("Enter a id ");
				int id  = scanner.nextInt();
				
				person1.setId(id);
				 person1curd.getPerson1ById(id);
			}
			break;
			
			case 5:{
				person1curd.getAllPerson1();
			}
			break;
			default :{
				condition = false;
			}
			}
		}while(condition);

	}

}
