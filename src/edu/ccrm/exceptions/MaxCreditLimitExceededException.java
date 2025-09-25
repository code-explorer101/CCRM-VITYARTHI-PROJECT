package edu.ccrm.exceptions;

/**
 * Exception thrown when student tries to enroll in more credits than allowed per semester
 */
public class MaxCreditLimitExceededException extends Exception {
    public MaxCreditLimitExceededException(String message) {
        super(message);
    }
    
    public MaxCreditLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}