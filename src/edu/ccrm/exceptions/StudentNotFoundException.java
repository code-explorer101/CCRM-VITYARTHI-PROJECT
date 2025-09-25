package edu.ccrm.exceptions;

/**
 * Exception thrown when a student cannot be found in the system
 */
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
    
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}