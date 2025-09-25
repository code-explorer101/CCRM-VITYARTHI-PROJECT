package edu.ccrm.exceptions;

/**
 * Exception thrown when attempting to enroll a student in a course they're already enrolled in
 */
public class DuplicateEnrollmentException extends Exception {
    public DuplicateEnrollmentException(String message) {
        super(message);
    }
    
    public DuplicateEnrollmentException(String message, Throwable cause) {
        super(message, cause);
    }
}