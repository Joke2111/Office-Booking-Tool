package com.officebookingtool.presentation;

import com.officebookingtool.readers.AccessLevelReader;
import com.officebookingtool.readers.ConsoleReader;
import com.officebookingtool.readers.PasswordReader;
import com.officebookingtool.readers.UserTypeReader;
import com.officebookingtool.readers.UsernameReader;

public class UserView
{
	ConsoleReader reader = new ConsoleReader();

	public Integer getAccessLevel()
	{
		Integer accessLevel = reader.read(new AccessLevelReader());
		return accessLevel;
	}
	/// return
	/// recursive

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
