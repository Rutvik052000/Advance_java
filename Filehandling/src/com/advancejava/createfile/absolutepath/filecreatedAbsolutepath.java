package com.advancejava.createfile.absolutepath;

import java.io.File;
import java.io.IOException;

public class filecreatedAbsolutepath {

	public static void main(String[] args) {
	
		File file = new File("D:\\Advance java\\wejm5.txt");
		
		try {
			file.createNewFile();
			System.out.println("File created sucessfully");
		} catch (IOException e) {
			
			System.out.println("File not created");
		}

	}

}
