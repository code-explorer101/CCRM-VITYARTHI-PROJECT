package edu.ccrm.domain;

public class Enrollment {
    private String studentRegNo;
    private String courseCode;
    private Semester semester;
    private Grade grade;
    private String enrollmentDate;
    
    public Enrollment(String studentRegNo, String courseCode, Semester semester) {
        this.studentRegNo = studentRegNo;
        this.courseCode = courseCode;
        this.semester = semester;
        this.enrollmentDate = java.time.LocalDate.now().toString();
    }
    
    // Getters and setters
    public String getStudentRegNo() { return studentRegNo; }
    public String getCourseCode() { return courseCode; }
    public Semester getSemester() { return semester; }
    public Grade getGrade() { return grade; }
    public String getEnrollmentDate() { return enrollmentDate; }
    
    public void setGrade(Grade grade) { this.grade = grade; }
    
    @Override
    public String toString() {
        return String.format("Enrollment[%s -> %s (%s): %s]", 
            studentRegNo, courseCode, semester, 
            grade != null ? grade : "No Grade");
    }
}