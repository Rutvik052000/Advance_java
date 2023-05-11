import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Batch {

	public static void main(String[] args) throws SQLException, IOException {
		
		Product product1 = new Product();
		product1.setId(1);
		product1.setName("Mobile");
		product1.setCost(10000);
		product1.setManufacture("vivo");
		
		Product product2 = new Product();
		product2.setId(2);
		product2.setName("Laptop");
		product2.setCost(45000);
		product2.setManufacture("Sony");
		
		Product product3 = new Product();
		product3.setId(3);
		product3.setName("Refregerator");
		product3.setCost(30000);
		product3.setManufacture("Godraj");
		
		ArrayList<Product> arrayList = new ArrayList<Product>();
		arrayList.add(product1);
		arrayList.add(product2);
		arrayList.add(product3);
		
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream = new FileInputStream("productRepo.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO productrepo VALUES(?,?,?,?)");
		
		for(Product product : arrayList) {
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getCost());
			preparedStatement.setString(4, product.getManufacture());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		System.out.println("Batch Executed successfully");
		
		connection.close();
		

	}

}
