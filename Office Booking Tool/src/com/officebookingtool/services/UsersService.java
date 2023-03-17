package com.officebookingtool.services;

import com.officebookingtool.PasswordEncryption;
import com.officebookingtool.User;
import com.officebookingtool.database.UserDAO;
import com.officebookingtool.presentation.UserView;

public class UsersService
{

	static public User Login()
	{
		UserView userView = new UserView();

		System.out.println("Please enter your login credentials:\n");

		String username = userView.getUsername();
		String password = userView.getPassword();
		String passwordEncrypted = PasswordEncryption.encrypt(password);

		boolean isValidLogin = UserDAO.validateLogin(username, passwordEncrypted);

		if (isValidLogin)
		{
			System.out.println("Login successful");
			return (UserDAO.getUserByUsername(username));
		} else
		{
			System.out.println("Login failed");
			/// restructurat return-ul !!!
			return Login();
		}
	}

	static public User Register()
	{
		UserView userView = new UserView();

		System.out.println("Please set your login credentials:");

		String username = userView.getUsername();
		String password = userView.getPassword();
		String passwordEncrypted = PasswordEncryption.encrypt(password);
		Integer accessLevel = userView.getAccessLevel();
		String userType = userView.getUserType();

		User user = new User(username, accessLevel, userType, passwordEncrypted);

		boolean isValidRegister = UserDAO.addUser(user);

		if (isValidRegister)
		{
			System.out.println("Registration successful");
			return (user);
		} else
		{
			System.out.println("Registration failed");
			return Register();
		}

	}
}
