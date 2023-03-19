package com.officebookingtool.services;

import com.officebookingtool.PasswordEncryption;
import com.officebookingtool.User;
import com.officebookingtool.database.UserDAO;
import com.officebookingtool.presentation.UserView;

/**
 * This class contains the methods for the login and registration of a user.
 */
public class UsersService
{
	/**
	 * This method is used to log in a user
	 *
	 * @return The User object if the login is successful, or recursively calls itself if the login fails
	 */
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

	/**
	 * This method is used to register a new user
	 *
	 * @return The User object if the registration is successful, or recursively calls itself if the registration fails
	 */
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
