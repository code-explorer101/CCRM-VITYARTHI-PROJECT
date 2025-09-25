package edu.ccrm.exceptions;

/**
 * Exception thrown when an enrollment record cannot be found
 */
public class EnrollmentNotFoundException extends Exception {
    public EnrollmentNotFoundException(String message) {
        super(message);
    }
    
    public EnrollmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}