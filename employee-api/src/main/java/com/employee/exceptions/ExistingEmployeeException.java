package com.employee.exceptions;

public class ExistingEmployeeException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    public ExistingEmployeeException(final String message) {
        super(message);
    }
}