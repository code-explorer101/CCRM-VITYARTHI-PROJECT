package edu.ccrm.service;

import java.util.*;
import java.util.stream.Collectors;
import edu.ccrm.domain.*;
import edu.ccrm.exceptions.*;
import edu.ccrm.config.AppConfig;

public class EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();
    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();
    
   
    private static final int MAX_CREDITS_PER_SEM = 27; 
    
    public void enrollStudent(String studentRegNo, String courseCode, Semester semester) 
            throws StudentNotFoundException, CourseNotFoundException, 
                   DuplicateEnrollmentException, MaxCreditLimitExceededException {
        
 
        Student student = studentService.getStudent(studentRegNo);
        Course course = courseService.getCourse(courseCode);
        
  
        boolean alreadyEnrolled = enrollments.stream()
            .anyMatch(e -> e.getStudentRegNo().equals(studentRegNo) && 
                          e.getCourseCode().equals(courseCode) &&
                          e.getSemester() == semester);
                          
        if (alreadyEnrolled) {
            throw new DuplicateEnrollmentException(
                "Student " + studentRegNo + " is already enrolled in " + courseCode + " for " + semester);
        }
        

        int currentCredits = getTotalCreditsForSemester(studentRegNo, semester);
        if (currentCredits + course.getCredits() > MAX_CREDITS_PER_SEM) {
            throw new MaxCreditLimitExceededException(
                "Adding this course would exceed maximum credits per semester (" + MAX_CREDITS_PER_SEM + ")");
        }
        
    
        Enrollment enrollment = new Enrollment(studentRegNo, courseCode, semester);
        enrollments.add(enrollment);
        student.addEnrollment(enrollment);
        
        
        System.out.println("Debug: Enrollment created successfully by VITYARTHI CCRM"); 
    }
    
    public List<Enrollment> getStudentEnrollments(String studentRegNo) {
        return enrollments.stream()
            .filter(e -> e.getStudentRegNo().equals(studentRegNo))
            .collect(Collectors.toList());
    }
    
    public void updateGrade(String studentRegNo, String courseCode, Grade grade) 
            throws EnrollmentNotFoundException {
        
        Optional<Enrollment> enrollmentOpt = enrollments.stream()
            .filter(e -> e.getStudentRegNo().equals(studentRegNo) && 
                        e.getCourseCode().equals(courseCode))
            .findFirst();
            
        if (enrollmentOpt.isEmpty()) {
            throw new EnrollmentNotFoundException("Enrollment not found for student " + 
                studentRegNo + " in course " + courseCode);
        }
        
        enrollmentOpt.get().setGrade(grade);
    }
    
    
    public double calculateSemesterGPA(String studentRegNo, Semester semester) {
        List<Enrollment> semesterEnrollments = enrollments.stream()
            .filter(e -> e.getStudentRegNo().equals(studentRegNo) && 
                        e.getSemester() == semester &&
                        e.getGrade() != null)
            .collect(Collectors.toList());
            
        if (semesterEnrollments.isEmpty()) {
            return 0.0;
        }
        
        double totalGradePoints = 0.0;
        int totalCredits = 0;
        
        for (Enrollment enrollment : semesterEnrollments) {
            try {
                Course course = courseService.getCourse(enrollment.getCourseCode());
                double gradePoints = enrollment.getGrade().getGradePoints();
                int credits = course.getCredits();
                
                totalGradePoints += gradePoints * credits;
                totalCredits += credits;
            } catch (CourseNotFoundException e) {
               
                continue;
            }
        }
        
        return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }
    
    public double calculateOverallGPA(String studentRegNo) {
       
        List<Enrollment> allEnrollments = getStudentEnrollments(studentRegNo).stream()
            .filter(e -> e.getGrade() != null)
            .collect(Collectors.toList());
            
        if (allEnrollments.isEmpty()) {
            return 0.0;
        }
        
        double totalGradePoints = 0.0;
        int totalCredits = 0;
        
        for (Enrollment enrollment : allEnrollments) {
            try {
                Course course = courseService.getCourse(enrollment.getCourseCode());
                double gradePoints = enrollment.getGrade().getGradePoints();
                int credits = course.getCredits();
                
                totalGradePoints += gradePoints * credits;
                totalCredits += credits;
            } catch (CourseNotFoundException e) {
                continue;
            }
        }
        
        return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }
    
    private int getTotalCreditsForSemester(String studentRegNo, Semester semester) {
        return enrollments.stream()
            .filter(e -> e.getStudentRegNo().equals(studentRegNo) && e.getSemester() == semester)
            .mapToInt(e -> {
                try {
                    return courseService.getCourse(e.getCourseCode()).getCredits();
                } catch (CourseNotFoundException ex) {
                    return 0;
                }
            })
            .sum();
    }
}