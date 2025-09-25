package edu.ccrm.domain;

public class Course {
    private String code;
    private String title;
    private int credits;
    private String instructorId;
    private Semester semester;
    private String department;
    private CourseStatus status;
    
    private Course(Builder builder) {
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
        this.instructorId = builder.instructorId;
        this.semester = builder.semester;
        this.department = builder.department;
        this.status = CourseStatus.ACTIVE;
    }
    
    // Getters
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getInstructorId() { return instructorId; }
    public Semester getSemester() { return semester; }
    public String getDepartment() { return department; }
    public CourseStatus getStatus() { return status; }
    
    public void setStatus(CourseStatus status) { this.status = status; }
    
    
    public static class Builder {
        private String code;
        private String title;
        private int credits;
        private String instructorId;
        private Semester semester;
        private String department;
        
        public Builder setCode(String code) {
            this.code = code;
            return this;
        }
        
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public Builder setCredits(int credits) {
            this.credits = credits;
            return this;
        }
        
        public Builder setInstructorId(String instructorId) {
            this.instructorId = instructorId;
            return this;
        }
        
        public Builder setSemester(Semester semester) {
            this.semester = semester;
            return this;
        }
        
        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }
        
        public Course build() {
            if (code == null || title == null || credits <= 0) {
                throw new IllegalArgumentException("Course must have code, title, and valid credits");
            }
            return new Course(this);
        }
    }
    
    public enum CourseStatus {
        ACTIVE, INACTIVE, CANCELLED
    }
    
    @Override
    public String toString() {
        return String.format("Course[%s: %s (%d credits)]", code, title, credits);
    }
}