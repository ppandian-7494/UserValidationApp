package com.iptech;

import java.io.IOException;
import java.util.Scanner;

public class UserValidationApp {
	private static UserService userService = new UserService();
	private static FileService fileService = new FileService();

	public static void main(String[] args) throws IOException {
		fileService.populateUserArray();
		
		Scanner scanner = new Scanner(System.in);

		boolean validLogin = false;
		int numberOfLoginAttempts = 0;
		while (!validLogin && numberOfLoginAttempts < 5) {	
			System.out.println("Enter your email:");
			String username = scanner.nextLine();
			System.out.println("Enter your password: ");
			String password = scanner.nextLine();

			User validUser = userService.isValidUser(username, password);
			if (validUser != null) {
				System.out.println("Welcome: " + validUser.getName());
				validLogin = true;
			} else {
				numberOfLoginAttempts++;
				if (numberOfLoginAttempts >= 5) {
					System.out.println("Too many failed login attempts, you are now locked out.");
				} else {
					System.out.println("Invalid login, please try again");
				}
			}
		}
		scanner.close();
	}
}
