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
			return Login();
		}
	}

	static public User Register()
	{
		UserView userView = new UserView();

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

	// public logare() // primesc 2 string uri din presentation, fac cv cu ele si cu
	// DAO (requesturile de ID, daca exista etc)
	// si returnez fie useru fie id-ul

	/// service apeleaza la randu lui DAO,

	/// din presentation nu folosesc direct DAO, tb sa trec prin service (adica
	/// acesta)
}
