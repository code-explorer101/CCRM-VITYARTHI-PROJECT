package edu.ccrm.cli;

import java.util.Scanner;
import edu.ccrm.service.*;
import edu.ccrm.domain.*;
import edu.ccrm.io.*;
import edu.ccrm.exceptions.*;
import edu.ccrm.config.AppConfig;


public class AppCLI {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService = new StudentService();
    private static CourseService courseService = new CourseService();
    private static EnrollmentService enrollmentService = new EnrollmentService();
    private static ImportExportService ioService = new ImportExportService();
    private static BackupService backupService = new BackupService();
    
    public static void main(String[] args) {
        initializeSampleData();
        
        System.out.println("🎓 Welcome to VITYARTHI Campus Course & Records Manager!");
        System.out.println("==================================================");
        
        boolean running = true;
        while (running) {
            showMainMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                running = handleMenuChoice(choice);
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
            }
        }
        
        
        System.out.println("BYE,Thanks for using VITYARTHI CCRM! Hope you like it!");
        scanner.close();
    }
    
    private static void showMainMenu() {
        System.out.println("\n--- VIT Student Manager ---"); 
        System.out.println("1. Students");
        System.out.println("2. Courses");
        System.out.println("3. Enrollment");
        System.out.println("4. Import");
        System.out.println("5. Export");
        System.out.println("6. Backup");
        System.out.println("7. Reports");
        System.out.println("8. Exit");
        System.out.print("Choose: ");
    }
    
    private static boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1: handleStudentMenu(); break;
            case 2: handleCourseMenu(); break;
            case 3: handleEnrollmentMenu(); break;
            case 4: handleImport(); break;
            case 5: handleExport(); break;
            case 6: handleBackup(); break;
            case 7: handleReports(); break;
            case 8: return false; // Exit
            default: System.out.println(" Invalid choice! Please try again.");
        }
        return true;
    }
    
    private static void handleStudentMenu() {
        System.out.println("\n Student Management");
        System.out.println("1. Add Student  2. List Students  3. Deactivate Student");
        System.out.print("Choose: ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: addStudent(); break;
                case 2: listStudents(); break;
                case 3: deactivateStudent(); break;
                default: System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
    
    private static void addStudent() {
        System.out.println("\\n➕ Adding New Student");
        
        System.out.print("Registration Number: ");
        String regNo = scanner.nextLine();
        
        System.out.print("Full Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        
        
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        
        try {
            Student student = new Student(regNo, name, email, dob, phoneNumber);
            studentService.addStudent(student);
            System.out.println("✅ Student added . Welcome " + name + "!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private static void listStudents() {
        System.out.println("\\n📋 Active Students List");
        var students = studentService.getAllActiveStudents();
        
        if (students.isEmpty()) {
            System.out.println("No active students found.");
            return;
        }
        
        System.out.printf("%-10s %-20s %-25s %-15s%n", "Reg No", "Name", "Email", "Status");
        System.out.println("-".repeat(70));
        
        for (Student student : students) {
            System.out.printf("%-10s %-20s %-25s %-15s%n", 
                student.getRegNo(), 
                student.getName(), 
                student.getEmail(), 
                student.getStatus());
        }
    }
    
    private static void deactivateStudent() {
        System.out.print("Enter Registration Number to deactivate: ");
        String regNo = scanner.nextLine();
        
        try {
            studentService.deactivateStudent(regNo);
            System.out.println("✅ Student deactivated successfully!");
        } catch (StudentNotFoundException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
    
    private static void handleCourseMenu() {
        System.out.println("\\n📖 Course Management");
        System.out.println("1. Add Course  2. List Courses  3. Deactivate Course");
        System.out.print("Choose: ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: addCourse(); break;
                case 2: listCourses(); break;
                case 3: deactivateCourse(); break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
    
    private static void addCourse() {
        System.out.println("\\n➕ Adding New Course");
        
        System.out.print("Course Code: ");
        String code = scanner.nextLine();
        
        System.out.print("Course Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Credits: ");
        int credits = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Instructor ID: ");
        String instructorId = scanner.nextLine();
        
        System.out.print("Semester (SPRING/FALL/SUMMER): ");
        String semesterStr = scanner.nextLine();
        
        System.out.print("Department: ");
        String department = scanner.nextLine();
        
        try {
            Semester semester = Semester.valueOf(semesterStr.toUpperCase());
            Course course = new Course.Builder()
                .setCode(code)
                .setTitle(title)
                .setCredits(credits)
                .setInstructorId(instructorId)
                .setSemester(semester)
                .setDepartment(department)
                .build();
                
            courseService.addCourse(course);
            System.out.println("✅ Course added successfully by Ak!");  // TODO: Change name
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private static void listCourses() {
        System.out.println("\\n📋 Active Courses List");
        var courses = courseService.getAllActiveCourses();
        
        if (courses.isEmpty()) {
            System.out.println("No active courses found.");
            return;
        }
        
        System.out.printf("%-8s %-30s %-8s %-15s %-12s%n", "Code", "Title", "Credits", "Instructor", "Semester");
        System.out.println("-".repeat(80));
        
        for (Course course : courses) {
            System.out.printf("%-8s %-30s %-8d %-15s %-12s%n", 
                course.getCode(), 
                course.getTitle(), 
                course.getCredits(),
                course.getInstructorId(),
                course.getSemester());
        }
    }
    
    private static void deactivateCourse() {
        System.out.print("Enter Course Code to deactivate: ");
        String code = scanner.nextLine();
        
        try {
            courseService.deactivateCourse(code);
            System.out.println("✅ Course deactivated successfully!");
        } catch (CourseNotFoundException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
    
    private static void handleEnrollmentMenu() {
        System.out.println("\\n🎯 Enrollment Management");
        System.out.println("1. Enroll Student  2. View Enrollments  3. Update Grade");
        System.out.print("Choose: ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: enrollStudent(); break;
                case 2: viewEnrollments(); break;
                case 3: updateGrade(); break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
    
    private static void enrollStudent() {
        System.out.print("Student Registration Number: ");
        String regNo = scanner.nextLine();
        
        System.out.print("Course Code: ");
        String courseCode = scanner.nextLine();
        
        System.out.print("Semester (SPRING/FALL/SUMMER): ");
        String semesterStr = scanner.nextLine();
        
        try {
            Semester semester = Semester.valueOf(semesterStr.toUpperCase());
            enrollmentService.enrollStudent(regNo, courseCode, semester);
            System.out.println("✅ Student enrolled successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private static void viewEnrollments() {
        System.out.print("Student Registration Number: ");
        String regNo = scanner.nextLine();
        
        try {
            var enrollments = enrollmentService.getStudentEnrollments(regNo);
            
            if (enrollments.isEmpty()) {
                System.out.println("No enrollments found for this student.");
                return;
            }
            
            System.out.println("\\n📋 Student Enrollments");
            System.out.printf("%-10s %-12s %-8s%n", "Course", "Semester", "Grade");
            System.out.println("-".repeat(32));
            
            for (Enrollment enrollment : enrollments) {
                System.out.printf("%-10s %-12s %-8s%n", 
                    enrollment.getCourseCode(),
                    enrollment.getSemester(),
                    enrollment.getGrade() != null ? enrollment.getGrade() : "N/A");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private static void updateGrade() {
        System.out.print("Student Registration Number: ");
        String regNo = scanner.nextLine();
        
        System.out.print("Course Code: ");
        String courseCode = scanner.nextLine();
        
        System.out.print("Grade (A/B/C/D/F): ");
        String gradeStr = scanner.nextLine();
        
        try {
            Grade grade = Grade.valueOf(gradeStr.toUpperCase());
            enrollmentService.updateGrade(regNo, courseCode, grade);
            System.out.println("✅ Grade updated successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private static void handleImport() {
        System.out.println("📥 Import functionality - Coming soon!");
        
    }
    
    private static void handleExport() {
        System.out.println("📤 Export functionality - Coming soon!");
        
    }
    
    private static void handleBackup() {
        System.out.println("💾 Creating backup...");
        backupService.createBackup();
        System.out.println("✅ Backup created successfully!");
    }
    
    private static void handleReports() {
        System.out.println("\\n📊 Reports Menu");
        System.out.println("1. Student GPA Report  2. Course Enrollment Stats");
        System.out.print("Choose: ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: showGPAReport(); break;
                case 2: showEnrollmentStats(); break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
    
    private static void showGPAReport() {
        System.out.print("Student Registration Number: ");
        String regNo = scanner.nextLine();
        
        System.out.print("Semester (SPRING/FALL/SUMMER): ");
        String semesterStr = scanner.nextLine();
        
        try {
            Semester semester = Semester.valueOf(semesterStr.toUpperCase());
            double gpa = enrollmentService.calculateSemesterGPA(regNo, semester);
            System.out.printf("📈 GPA for %s in %s: %.2f%n", regNo, semester, gpa);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private static void showEnrollmentStats() {
        System.out.println("📊 Enrollment Statistics");
        System.out.println("Total Students: " + studentService.getAllActiveStudents().size());
        System.out.println("Total Courses: " + courseService.getAllActiveCourses().size());
       
    }
    
    
    private static void initializeSampleData() {
        
        try {
            studentService.addStudent(new Student("CS001", "Raj Thakur", "raj@email.com", "2000-01-15", "9999999999"));
            studentService.addStudent(new Student("CS002", "Soniya Singh", "soniya@email.com", "1999-12-10", "8888888888"));
            
            // Sample courses
            Course java = new Course.Builder()
                .setCode("CS101")
                .setTitle("Introduction to Java Programming")
                .setCredits(3)
                .setInstructorId("PROF001")
                .setSemester(Semester.FALL)
                .setDepartment("Computer Science")
                .build();
                
            Course dataStructures = new Course.Builder()
                .setCode("CS201")
                .setTitle("Data Structures and Algorithms")
                .setCredits(4)
                .setInstructorId("PROF002")
                .setSemester(Semester.SPRING)
                .setDepartment("Computer Science")
                .build();
                
            courseService.addCourse(java);
            courseService.addCourse(dataStructures);
            
            
            enrollmentService.enrollStudent("CS001", "CS101", Semester.FALL);
            enrollmentService.enrollStudent("CS002", "CS101", Semester.FALL);
            
        } catch (Exception e) {
            System.out.println("Error initializing sample data: " + e.getMessage());
        }
    }
}