package com.officebookingtool.readers;

public interface InputReader<T>
{
	T getValue(String input);

	String getErrorMessage();

	boolean validate(String input);

	String getSuccessfulMessage();

	String getPrompt();
}
