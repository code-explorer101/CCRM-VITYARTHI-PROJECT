package edu.ccrm.io;

import java.io.*;
import java.util.List;
import edu.ccrm.domain.*;
import edu.ccrm.service.*;


public class ImportExportService {
    private StudentService studentService;
    private CourseService courseService;
    
    public ImportExportService() {
        this.studentService = new StudentService();
        this.courseService = new CourseService();
    }
    
    public void exportStudentsToCSV(String filename, List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // CSV Header
            writer.println("RegNo,Name,Email,DateOfBirth,PhoneNumber,Status");
            
            for (Student student : students) {
                writer.printf("%s,%s,%s,%s,%s,%s%n",
                    student.getRegNo(),
                    student.getName(),
                    student.getEmail(),
                    student.getDateOfBirth(),
                    student.getPhoneNumber(),
                    student.getStatus());
            }
            
            System.out.println("✅ Students exported to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error exporting students: " + e.getMessage());
        }
    }
    
    public void exportCoursesToCSV(String filename, List<Course> courses) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Code,Title,Credits,InstructorId,Semester,Department,Status");
            
            for (Course course : courses) {
                writer.printf("%s,%s,%d,%s,%s,%s,%s%n",
                    course.getCode(),
                    course.getTitle(),
                    course.getCredits(),
                    course.getInstructorId(),
                    course.getSemester(),
                    course.getDepartment(),
                    course.getStatus());
            }
            
            System.out.println("✅ Courses exported to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error exporting courses: " + e.getMessage());
        }
    }

    public void importStudentsFromCSV(String filename) {
        System.out.println("📥 Import from CSV - Implementation needed");
       
    }
}