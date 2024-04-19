package com.demo.globalException;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice//this is global exception handling class for me
public class MyControllerExceptionHandler extends ResponseEntityExceptionHandler{
	//we need to use multiple method in order to handle the exception
	
	//if i want to add the employee and i have provided the name as null so it should throw th exception as employee is empty
	@ExceptionHandler(emptyInputException.class)
	public ResponseEntity<String>handleEmptyInput(emptyInputException emptyInputException){
		return new ResponseEntity<String>("input field is empty",HttpStatus.BAD_REQUEST);
	}
	
	//if id is not present is database then no such element exception
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String>noSuchelement(NoSuchElementException noSuchElementException){
		return new ResponseEntity<String>("no such element is present in database,please change your request or id",HttpStatus.NOT_FOUND);
	}

	
	//ResponseEntityExceptionHandler is inbuilt class and have some methods  to thrrow the exception
	//below is one of them
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("please change your method type",HttpStatus.NOT_FOUND);
	}
	
}
