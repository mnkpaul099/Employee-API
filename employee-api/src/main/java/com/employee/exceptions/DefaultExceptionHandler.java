package com.employee.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler
{
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler({ EmployeeNotFoundException.class })
    public final ResponseEntity<ErrorMessage> employeeNotFound(final EmployeeNotFoundException ex) {
        final ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "Employee not found.");
        return (ResponseEntity<ErrorMessage>)new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler({ ExistingEmployeeException.class })
    public final ResponseEntity<ErrorMessage> existingOrder(final ExistingEmployeeException ex) {
        final ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "Employee already exist.");
        return (ResponseEntity<ErrorMessage>)new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
}