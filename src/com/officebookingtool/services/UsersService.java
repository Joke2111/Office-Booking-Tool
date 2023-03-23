package com.officebookingtool.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.officebookingtool.database.UserDAO;
import com.officebookingtool.models.User;
import com.officebookingtool.presentation.UserView;

/**
 * This class contains the methods for the login and registration of a user.
 */
public class UsersService
{

	/**
	 * Returns the SHA-256 encrypted password for the given input string.
	 * 
	 * @param password the input password to be encrypted
	 * @return the SHA-256 encrypted password
	 * @throws RuntimeException if the SHA-256 algorithm is not available in the environment
	 */
	static public String encrypt(String password)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] mdArray = md.digest();
			StringBuilder sb = new StringBuilder(mdArray.length * 2);
			for (byte b : mdArray)
			{
				int v = b & 0xff;
				if (v < 16)
				{
					sb.append('0');
				}
				sb.append(Integer.toHexString(v));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method is used to log in a user
	 *
	 * @return The User object if the login is successful, or recursively calls itself if the login fails
	 */
	static public User login()
	{
		UserView userView = new UserView();

		System.out.println("Please enter your login credentials:\n");

		String username = userView.getUsername();
		String password = userView.getPassword();
		String passwordEncrypted = encrypt(password);

		boolean isValidLogin = UserDAO.validateLogin(username, passwordEncrypted);

		if (isValidLogin)
		{
			System.out.println("Login successful");
			return (UserDAO.getUserByUsername(username));
		} else
		{
			System.out.println("Login failed");
			return null;
		}
	}

	/**
	 * This method is used to register a new user
	 *
	 * @return The User object if the registration is successful, or recursively calls itself if the registration fails
	 */
	static public User register()
	{
		UserView userView = new UserView();

		System.out.println("Please set your login credentials:");

		String username = userView.getUsername();
		String password = userView.getPassword();
		String passwordEncrypted = encrypt(password);
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
			return null;
		}

	}
}
