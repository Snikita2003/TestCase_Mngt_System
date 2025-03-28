package com.tc.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler( ResNotFoundExc.class )
	public ResponseEntity<ApiResponce> handleException(ResNotFoundExc res)
	{
		
		String msg= res.getMessage();
		ApiResponce responce=new ApiResponce(msg,false);
		
		return new ResponseEntity<ApiResponce>(responce,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidExp(MethodArgumentNotValidException  ex)
	{
		Map<String, String> errors=new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((e)->{
			
			String fname=  (( FieldError) e).getField() ;
			String msg=e.getDefaultMessage();
			errors.put(fname,msg);
		});
		
		
		return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
	}
	
	
}
