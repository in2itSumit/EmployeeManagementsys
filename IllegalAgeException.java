package com.example.demo.exceptionHandler;

public class IllegalAgeException extends Throwable{
	public IllegalAgeException(String str)
	{
		super(str);
	}
}
