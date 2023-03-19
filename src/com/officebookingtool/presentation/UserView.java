package com.officebookingtool.presentation;

import com.officebookingtool.readers.*;

public class UserView
{
	ConsoleReader reader = new ConsoleReader();

	public Integer getAccessLevel()
	{
		Integer accessLevel = reader.read(new AccessLevelReader());
		return accessLevel;
	}

	public String getUsername()
	{
		String username = reader.read(new UsernameReader());
		return username;
	}

	public String getUserType()
	{
		String userType = reader.read(new UserTypeReader());
		return userType;
	}

	public String getPassword()
	{
		String password = reader.read(new PasswordReader());
		return password;
	}
}
