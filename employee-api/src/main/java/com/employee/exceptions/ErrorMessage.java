package com.employee.exceptions;

public class ErrorMessage
{
    private String message;
    private String details;
    
    public ErrorMessage(final String message, final String details) {
        this.message = message;
        this.details = details;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public String getDetails() {
        return this.details;
    }
    
    public void setDetails(final String details) {
        this.details = details;
    }
}