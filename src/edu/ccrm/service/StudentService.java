package edu.ccrm.service;

import java.util.*;
import java.util.stream.Collectors;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Student.StudentStatus;
import edu.ccrm.exceptions.StudentNotFoundException;
import edu.ccrm.io.Validators;

public class StudentService {

    private Map<String, Student> students = new HashMap<>();
    
    public void addStudent(Student student) {
        // Validate student data
        if (!Validators.isValidEmail(student.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        if (students.containsKey(student.getRegNo())) {
            throw new IllegalArgumentException("Student with this registration number already exists");
        }
        
        students.put(student.getRegNo(), student);

    }
    
    public Student getStudent(String regNo) throws StudentNotFoundException {
        Student student = students.get(regNo);
        if (student == null) {
            throw new StudentNotFoundException("Student not found: " + regNo);
        }
        return student;
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    
    public List<Student> getAllActiveStudents() {
        return students.values().stream()
            .filter(student -> student.getStatus() == StudentStatus.ACTIVE)
            .collect(Collectors.toList());
    }
    
    public void deactivateStudent(String regNo) throws StudentNotFoundException {
        Student student = getStudent(regNo);
        student.setStatus(StudentStatus.INACTIVE);

    }
    
    public void updateStudent(Student student) throws StudentNotFoundException {
        if (!students.containsKey(student.getRegNo())) {
            throw new StudentNotFoundException("Cannot update non-existent student: " + student.getRegNo());
        }
        students.put(student.getRegNo(), student);
    }
    

    public int getActiveStudentCount() {
        return (int) students.values().stream()
            .filter(student -> student.getStatus() == StudentStatus.ACTIVE)
            .count();
    }
}