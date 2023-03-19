package com.officebookingtool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The PasswordEncryption class provides methods for encrypting passwords using SHA-256 algorithm.
 * 
 * This class contains a single static method for encrypting passwords, which returns the SHA-256 encrypted password for the given input string.
 * 
 * @throws RuntimeException if the SHA-256 algorithm is not available in the environment
 */
public class PasswordEncryption
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
}
