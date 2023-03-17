package com.officebookingtool;

/**
 * The User class represents a user of the system.
 * 
 * This class contains methods for getting and setting the user properties, including the username, access level, user type, and encrypted password.
 */
public class User
{
	private String username;
	private int accessLevel;
	private String userType;
	private String passwordEncrypted;

	public User(String username, int accessLevel, String userType, String passwordEncrypted)
	{
		this.username = username;
		this.accessLevel = accessLevel;
		this.userType = userType;
		this.passwordEncrypted = passwordEncrypted;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getAccessLevel()
	{
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel)
	{
		this.accessLevel = accessLevel;
	}

	public String getUserType()
	{
		return userType;
	}

	public void setUserType(String userType)
	{
		this.userType = userType;
	}

	public String getPasswordEncrypted()
	{
		return passwordEncrypted;
	}

	public void setPasswordEncrypted(String passwordEncrypted)
	{
		this.passwordEncrypted = passwordEncrypted;
	}
}
