package com.sprint;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Indicates that this class is a " AppExceptionHandler", developed for the
 * sprint project "Online Plant Nursery Application" This class is a part of
 * example package which is a mechanism to handle the runtime errors so that
 * normal flow of application can be maintained We can create custom exception
 * classes to handle the exceptions in the application Exception Handler
 * annotation is used to handle the specific exception and send in custom
 * response to the class
 * 
 * @Date 24.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

//CENTRALIZED EXCEPTION HANDLING
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { IllegalArgumentException.class, NullPointerException.class,
			EntityNotFoundException.class, NoSuchElementException.class })
	public ResponseEntity<Object> IAExceptionHandler(Exception e, WebRequest request) {
		String msg = "Error in operation: " + e.getMessage();
		return handleExceptionInternal(e, msg, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	// CUSTOM EXCEPTION HANDLING
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> errorList = e.getBindingResult().getFieldErrors().stream()
				.map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
		return handleExceptionInternal(e, errorList, headers, HttpStatus.BAD_REQUEST, request);
	}
}
