package edu.ccrm.exceptions;

/**
 * Exception thrown when a course cannot be found in the system
 */
public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String message) {
        super(message);
    }
    
    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
