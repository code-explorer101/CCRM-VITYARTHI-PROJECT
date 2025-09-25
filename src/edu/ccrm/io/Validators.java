package edu.ccrm.io;

import java.util.regex.Pattern;

public class Validators {
    
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^[\\\\+]?[1-9]?[0-9]{7,15}$");
    
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }
    
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }

        String cleanPhone = phone.replaceAll("[\\\\s-()]", "");
        return PHONE_PATTERN.matcher(cleanPhone).matches();
    }
    
    public static boolean isValidRegNo(String regNo) {
        if (regNo == null || regNo.trim().isEmpty()) {
            return false;
        }

        return regNo.trim().length() >= 4 && regNo.trim().length() <= 10;
    }
    
    public static boolean isValidCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            return false;
        }

        return Pattern.matches("^[A-Z]{2,4}\\\\d{3}$", courseCode.trim().toUpperCase());
    }
    
    public static void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
    }
}