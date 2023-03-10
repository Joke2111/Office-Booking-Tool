package com.officebookingtool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption
{
/// security package adaugat
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
