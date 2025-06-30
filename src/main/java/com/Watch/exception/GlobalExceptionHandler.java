package com.Watch.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
 
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		
		ExceptionResponse e= new ExceptionResponse(LocalDate.now(),ex.getMessage(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString()); ;
		return new ResponseEntity<ExceptionResponse>(e,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(WatchNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(RuntimeException ex, WebRequest request) {
		ExceptionResponse e= new ExceptionResponse(LocalDate.now(),ex.getMessage(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString()); ;

		return new ResponseEntity<ExceptionResponse>(e , HttpStatus.NOT_FOUND);
	}
 
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatusCode status, WebRequest request) {	
		Map<String, String> map= new HashMap<String, String>();


		ex.getBindingResult().getFieldErrors().forEach(er->map.put(er.getField(),er.getDefaultMessage()));
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
}
