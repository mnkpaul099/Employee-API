package com.employee.exceptions;

public class EmployeeNotFoundException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    public EmployeeNotFoundException(final String message) {
        super(message);
    }
}
