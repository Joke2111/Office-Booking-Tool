package com.officebookingtool.presentation;

import com.officebookingtool.readers.*;

/**
 * The {@code UserView} class provides methods to read user input from the console, for the purpose of retrieving information about a user.
 */
public class UserView
{

	ConsoleReader reader = new ConsoleReader();

	/**
	 * Reads and returns an {@code Integer} representing the access level of the user.
	 *
	 * @return the access level of the user.
	 */
	public Integer getAccessLevel()
	{
		Integer accessLevel = reader.read(new AccessLevelReader());
		return accessLevel;
	}

	/**
	 * Reads and returns a {@code String} representing the username of the user.
	 *
	 * @return the username of the user.
	 */
	public String getUsername()
	{
		String username = reader.read(new UsernameReader());
		return username;
	}

	/**
	 * Reads and returns a {@code String} representing the type of user.
	 *
	 * @return the type of user.
	 */
	public String getUserType()
	{
		String userType = reader.read(new UserTypeReader());
		return userType;
	}

	/**
	 * Reads and returns a {@code String} representing the password of the user.
	 *
	 * @return the password of the user.
	 */
	public String getPassword()
	{
		String password = reader.read(new PasswordReader());
		return password;
	}
}
