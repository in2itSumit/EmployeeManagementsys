package com.example.demo.exceptionHandler;

public class IllegalSalaryException extends Throwable {
	public IllegalSalaryException(String str)
	{
		super(str);
	}
}
