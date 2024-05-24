package com.example.demo.exceptionHandler;

public class DataNotExistException extends Throwable{
	public DataNotExistException(String str)
	{
		super(str);
	}
}
