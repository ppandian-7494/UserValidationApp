package com.iptech;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	public static User[] users = new User[5];
	public void populateUserArray() throws FileNotFoundException, IOException {
		String fileName = "user-data.txt";
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = null;
			int i = 0;
			while((line = br.readLine()) != null) {
				users[i] = new User(line.split(","));
				i++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found!");
			System.exit(0);
		} finally {
			if (br != null) br.close();
		}
	}
}
