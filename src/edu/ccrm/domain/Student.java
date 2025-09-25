package edu.ccrm.domain;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String regNo;
    private StudentStatus status;
    private List<Enrollment> enrollments;
  
    private String phoneNumber;
    
    public Student(String regNo, String name, String email, String dob, String phoneNumber) {
        super(regNo, name, email, dob);
        this.regNo = regNo;
        this.status = StudentStatus.ACTIVE;
        this.enrollments = new ArrayList<>();
        this.phoneNumber = phoneNumber;
    }
    
    // Getters and setters
    public String getRegNo() { return regNo; }
    public StudentStatus getStatus() { return status; }
    public List<Enrollment> getEnrollments() { return enrollments; }
    public String getPhoneNumber() { return phoneNumber; }
    
    public void setStatus(StudentStatus status) { this.status = status; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }
    
    @Override
    public String toString() {
        return String.format("Student[%s: %s (%s)]", regNo, name, status);
    }

    public enum StudentStatus {
        ACTIVE, INACTIVE, GRADUATED, SUSPENDED
    }
}