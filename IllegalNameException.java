package com.example.demo.exceptionHandler;

public class IllegalNameException extends Throwable {
	public IllegalNameException(String str)
	{
		super(str);
	}
}
