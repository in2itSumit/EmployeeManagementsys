package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exceptionHandler.CustomException;
import com.example.demo.exceptionHandler.DataNotExistException;
import com.example.demo.exceptionHandler.IllegalAgeException;
import com.example.demo.exceptionHandler.IllegalDateException;
import com.example.demo.exceptionHandler.IllegalNameException;
import com.example.demo.exceptionHandler.IllegalSalaryException;
import com.example.demo.exceptionHandler.Illegal_Id_Exception;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Illegal_Id_Exception.class)
	public ResponseEntity<CustomException> idException(Illegal_Id_Exception ex,WebRequest req)
	{
		CustomException custom=new CustomException();
		custom.setErrMessage(ex.getMessage());
		custom.setErrName(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
		custom.setErrPath(req.getDescription(false));
		custom.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		custom.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(custom);
	}
	
	@ExceptionHandler(IllegalAgeException.class)
	public ResponseEntity<CustomException> ageException(IllegalAgeException ex,WebRequest req)
	{
		CustomException custom=new CustomException();
		custom.setErrMessage(ex.getMessage());
		custom.setErrName(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
		custom.setErrPath(req.getDescription(false));
		custom.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		custom.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(custom);
	}
	
	@ExceptionHandler(IllegalDateException.class)
	public ResponseEntity<CustomException> ageException(IllegalDateException ex,WebRequest req)
	{
		CustomException custom=new CustomException();
		custom.setErrMessage(ex.getMessage());
		custom.setErrName(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
		custom.setErrPath(req.getDescription(false));
		custom.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		custom.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(custom);
	}
	@ExceptionHandler(IllegalNameException.class)
	public ResponseEntity<CustomException> ageException(IllegalNameException ex,WebRequest req)
	{
		CustomException custom=new CustomException();
		custom.setErrMessage(ex.getMessage());
		custom.setErrName(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
		custom.setErrPath(req.getDescription(false));
		custom.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		custom.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(custom);
	}
	@ExceptionHandler(IllegalSalaryException.class)
	public ResponseEntity<CustomException> ageException(IllegalSalaryException ex,WebRequest req)
	{
		CustomException custom=new CustomException();
		custom.setErrMessage(ex.getMessage());
		custom.setErrName(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
		custom.setErrPath(req.getDescription(false));
		custom.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		custom.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(custom);
	}
	@ExceptionHandler(DataNotExistException.class)
	public ResponseEntity<CustomException> dataNotExistException(DataNotExistException ex,WebRequest req)
	{
		CustomException custom=new CustomException();
		custom.setErrMessage(ex.getMessage());
		custom.setErrName(HttpStatus.NOT_FOUND.getReasonPhrase());
		custom.setErrPath(req.getDescription(false));
		custom.setStatusCode(HttpStatus.NOT_FOUND.value());
		custom.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(custom);
	}
}
