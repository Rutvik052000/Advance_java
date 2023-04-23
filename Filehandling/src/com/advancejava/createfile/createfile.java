package com.advancejava.createfile;

import java.io.File;
import java.io.IOException;

public class createfile {

	public static void main(String[] args) {
		
		File file = new File("wejm5.txt");
		
		try {
			file.createNewFile();
			System.out.println("File create sucessfully");
		} catch (IOException e) {
			
			System.out.println("File not created");
		}
	}
}
