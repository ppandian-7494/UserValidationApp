package com.iptech;

public class UserService {
	public User isValidUser(String username, String password) {
		for (User user : FileService.users) {
			if (user.getUsername().equalsIgnoreCase(username) &&
					user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
