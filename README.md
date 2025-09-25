# Campus Course and Records Manager (CCRM)

*A comprehensive CLI-based Student and Course Management System built with Java*

**Author**: code-explorer101  
---

## 📋 Table of Contents

1. [Project Overview](#-project-overview)
2. [Features](#-features)
3. [Technology Stack](#-technology-stack)
4. [Project Structure](#-project-structure)
5. [Installation & Setup](#-installation--setup)
6. [How to Compile and Run](#-how-to-compile-and-run)
7. [Usage Guide](#-usage-guide)
8. [Java Concepts Demonstrated](#-java-concepts-demonstrated)
9. [Java Background](#-java-background)
10. [Architecture Details](#-architecture-details)
11. [Customization Guide](#-customization-guide)
12. [Known Issues & Future Enhancements](#-known-issues--future-enhancements)
13. [Contributing](#-contributing)

---

## 🎯 Project Overview

The Campus Course and Records Manager (CCRM) is a command-line interface application designed to manage student records, course information, and enrollment data for educational institutions. This project demonstrates advanced Java programming concepts including Object-Oriented Programming, design patterns, exception handling, and data structures.

### Key Objectives
- Manage student records with comprehensive details
- Handle course creation, modification, and deactivation
- Process student enrollments with business rule validation
- Calculate GPA with weighted grade points
- Generate reports and statistics
- Import/Export data with CSV support
- Create automated backups

---

## ✨ Features

### 🎓 Student Management
- ✅ Add new students with validation
- ✅ List all active students
- ✅ Deactivate students
- ✅ Store additional details (phone, address)
- ✅ Status tracking (Active/Inactive/Graduated/Suspended)

### 📚 Course Management  
- ✅ Create courses using Builder pattern
- ✅ Assign instructors and departments
- ✅ Semester-based course planning
- ✅ Credit hour management
- ✅ Course status tracking

### 🎯 Enrollment System
- ✅ Enroll students with duplicate prevention
- ✅ Credit limit validation (max 18 credits per semester)
- ✅ Grade assignment and updates
- ✅ Semester-wise enrollment tracking

### 📊 Reporting & Analytics
- ✅ Semester GPA calculation
- ✅ Overall GPA computation
- ✅ Student enrollment statistics
- ✅ Course enrollment reports

### 💾 Data Management
- ✅ CSV Import/Export functionality
- ✅ Automated backup creation
- ✅ Data validation and error handling
- ✅ In-memory data storage

---

## 🛠 Technology Stack

- **Language**: Java 8+
- **Architecture**: MVC Pattern with Service Layer
- **Design Patterns**: Singleton, Builder, Strategy
- **Data Structures**: HashMap, ArrayList, Collections Framework
- **I/O Operations**: File handling, CSV processing
- **Error Handling**: Custom exceptions with business rules

---

## 📁 Project Structure

```
CCRM/
├── src/
│   └── edu/
│       └── ccrm/
│           ├── cli/                    # Command Line Interface
│           │   └── AppCLI.java         # Main application entry point
│           ├── domain/                 # Core business entities
│           │   ├── Person.java         # Base class for persons
│           │   ├── Student.java        # Student entity
│           │   ├── Course.java         # Course entity (Builder pattern)
│           │   ├── Enrollment.java     # Enrollment relationship
│           │   ├── Instructor.java     # Instructor entity
│           │   ├── Grade.java          # Grade enumeration
│           │   └── Semester.java       # Semester enumeration
│           ├── service/                # Business logic layer
│           │   ├── StudentService.java # Student operations
│           │   ├── CourseService.java  # Course operations
│           │   └── EnrollmentService.java # Enrollment & GPA logic
│           ├── io/                     # Input/Output utilities
│           │   ├── ImportExportService.java # CSV operations
│           │   ├── BackupService.java  # Data backup
│           │   └── Validators.java     # Data validation
│           ├── config/                 # Configuration management
│           │   └── AppConfig.java      # Singleton configuration
│           └── exceptions/             # Custom exception classes
│               ├── DuplicateEnrollmentException.java
│               ├── MaxCreditLimitExceededException.java
│               ├── StudentNotFoundException.java
│               ├── CourseNotFoundException.java
│               └── EnrollmentNotFoundException.java
├── bin/                               # Compiled class files (auto-generated)
├── data/                              # Data storage directory
├── backups/                           # Backup files
├── exports/                           # Exported data files
└── README.md                          # This documentation

```

---

## 🚀 Installation & Setup

### Prerequisites
- **Java Development Kit (JDK) 8 or higher**
- **Java Runtime Environment (JRE)**
- **Command line access** (Terminal/Command Prompt)
- **Text editor or IDE** (VS Code, IntelliJ IDEA, Eclipse)

### System Requirements
- **Operating System**: Windows 10+, macOS 10.14+, or Linux Ubuntu 18.04+
- **RAM**: Minimum 512MB available
- **Storage**: 50MB free space
- **Java Version**: OpenJDK 8+ or Oracle JDK 8+

### Verify Java Installation
```bash
java -version
javac -version
```
If Java is not installed, download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK.

---

## 🔧 How to Compile and Run

### Method 1: Using Command Line (Recommended)

#### For Windows:
```cmd
# Navigate to project root
cd CCRM

# Create bin directory
mkdir bin

# Compile all Java files
javac -d bin -sourcepath src src/edu/ccrm/*/*.java src/edu/ccrm/*/*/*.java

# Run the application
java -cp bin edu.ccrm.cli.AppCLI
```

#### For Linux/macOS:
```bash
# Navigate to project root
cd CCRM

# Create bin directory
mkdir -p bin

# Compile all Java files
javac -d bin -sourcepath src src/edu/ccrm/*/*.java src/edu/ccrm/*/*/*.java

# Run the application
java -cp bin edu.ccrm.cli.AppCLI
```

### Method 2: Using VS Code

1. **Install Extensions**:
   - "Extension Pack for Java" by Microsoft
   - "Java Code Generators" (optional)

2. **Open Project**:
   - File → Open Folder → Select CCRM directory
   - VS Code will automatically detect Java project

3. **Run Application**:
   - Press `F5` or `Ctrl+F5`
   - Select `AppCLI.java` as main class
   - Application will start in integrated terminal

### Method 3: Using IntelliJ IDEA

1. **Import Project**:
   - File → Open → Select CCRM directory
   - Choose "Import project from external model" → Select "Java"

2. **Configure Project**:
   - Set Project SDK to your Java version
   - Set source folder to `src`

3. **Run Configuration**:
   - Run → Edit Configurations
   - Add new Application configuration
   - Main class: `edu.ccrm.cli.AppCLI`
   - Working directory: Project root

---

## 📖 Usage Guide

### Main Menu Navigation
When you start the application, you'll see:
```
🎓 Welcome to Ak's Campus Course & Records Manager!
==================================================

--- Ak's Student Manager ---
1. Students
2. Courses  
3. Enrollment
4. Import
5. Export
6. Backup
7. Reports
8. Exit
Choose:
```

### Student Management Operations

#### Adding a New Student
1. Select option `1` (Students)
2. Choose `1` (Add Student)
3. Enter required information:
   - Registration Number (e.g., CS001)
   - Full Name
   - Email address (validated)
   - Date of Birth (YYYY-MM-DD format)
   - Phone Number (validated)

#### Listing Students
1. Select option `1` (Students)
2. Choose `2` (List Students)
3. View formatted table of all active students

#### Deactivating a Student
1. Select option `1` (Students)  
2. Choose `3` (Deactivate Student)
3. Enter student registration number

### Course Management Operations

#### Creating a New Course
1. Select option `2` (Courses)
2. Choose `1` (Add Course)
3. Provide course details:
   - Course Code (e.g., CS101)
   - Course Title
   - Credit Hours
   - Instructor ID
   - Semester (FALL/SUMMER,etc.)
   - Department

### Enrollment Operations

#### Enrolling a Student
1. Select option `3` (Enrollment)
2. Choose `1` (Enroll Student)
3. Enter:
   - Student Registration Number
   - Course Code
   - Semester

The system automatically validates:
- ✅ Student and course exist
- ✅ No duplicate enrollments
- ✅ Credit limit not exceeded (27 credits max per semester)

#### Updating Grades
1. Select option `3` (Enrollment)
2. Choose `3` (Update Grade)
3. Enter student reg number, course code, and grade (S/A/B/C/D/F)

### Generating Reports

#### Semester GPA Report
1. Select option `7` (Reports)
2. Choose `1` (Student GPA Report)
3. Enter student registration number and semester
4. View calculated GPA based on weighted average

---

## 🎓 Java Concepts Demonstrated

### Object-Oriented Programming (OOP)
- **Inheritance**: `Student` and `Instructor` extend `Person` base class
- **Encapsulation**: Private fields with public getter/setter methods
- **Polymorphism**: Method overriding in subclasses
- **Abstraction**: Abstract base classes and interfaces

### Design Patterns
- **Singleton Pattern**: `AppConfig` class for centralized configuration
- **Builder Pattern**: `Course` class for complex object creation
- **Strategy Pattern**: Different validation strategies in `Validators`

### Collections Framework
- **HashMap**: O(1) student and course lookups by ID
- **ArrayList**: Dynamic arrays for enrollments and lists
- **Streams API**: Functional programming for filtering and mapping

### Exception Handling
- **Custom Exceptions**: Business rule violations
- **Try-Catch Blocks**: Graceful error handling
- **Exception Hierarchy**: Extends standard Java exceptions

### Enums
- **Grade**: S, A, B, C, D, F with associated grade points
- **Semester**: FALL, SUMMER,etc. with display names
- **Status**: ACTIVE, INACTIVE, GRADUATED, SUSPENDED

### File I/O Operations
- **CSV Import/Export**: Reading and writing structured data
- **Backup Creation**: Automated data backup with timestamps
- **File Validation**: Checking file existence and permissions

---

## 📚 Java Background

### JDK vs JRE vs JVM

#### Java Virtual Machine (JVM)
- **Purpose**: Runtime environment that executes Java bytecode
- **Key Features**:
  - Platform independence ("Write Once, Run Anywhere")
  - Automatic memory management with Garbage Collection
  - Just-In-Time (JIT) compilation for performance optimization
  - Security through bytecode verification

#### Java Runtime Environment (JRE)  
- **Components**: JVM + Standard Java libraries + Supporting files
- **Purpose**: Provides runtime environment for Java applications
- **Contents**:
  - Core libraries (java.lang, java.util, java.io, etc.)
  - JVM implementation
  - Plugin support for browsers
  - Deployment technologies

#### Java Development Kit (JDK)
- **Components**: JRE + Development tools + Documentation
- **Development Tools**:
  - `javac`: Java compiler (source code → bytecode)
  - `java`: JVM launcher for running applications
  - `javadoc`: Documentation generator
  - `jar`: Archive tool for packaging
  - `jdb`: Java debugger
- **Purpose**: Complete toolkit for Java development

### Java Platform Editions

#### Java SE (Standard Edition)
- **Target**: Desktop and server applications
- **Core Features**:
  - Basic Java libraries and APIs
  - Collections Framework
  - Concurrency utilities
  - I/O and networking
  - GUI development (Swing, AWT)
- **Use Cases**: Desktop applications, command-line tools, server applications

#### Java EE (Enterprise Edition) / Jakarta EE
- **Target**: Large-scale, distributed enterprise applications
- **Additional Features**:
  - Servlets and JSP for web development
  - Enterprise JavaBeans (EJB)
  - Java Message Service (JMS)
  - Java Persistence API (JPA)
  - Web Services (JAX-WS, JAX-RS)
- **Use Cases**: Web applications, microservices, enterprise systems

#### Java ME (Micro Edition)
- **Target**: Mobile and embedded devices
- **Characteristics**:
  - Reduced footprint and optimized performance
  - Limited API subset
  - Device-specific implementations
- **Use Cases**: IoT devices, mobile applications (historically), embedded systems

### Java History & Evolution Timeline

#### 1995-1996: The Beginning
- **Creator**: James Gosling at Sun Microsystems
- **Original Name**: Oak (renamed to Java due to trademark issues)
- **Java 1.0**: First public release
- **Key Innovation**: "Write Once, Run Anywhere" philosophy

#### 1997-1998: Early Growth
- **Java 1.1**: Inner classes, reflection, JDBC, RMI
- **Adoption**: Rapid adoption for web applets and enterprise development

#### 1998-2000: Maturation
- **Java 2 (Java 1.2)**: Collections Framework, Swing GUI
- **Java 1.3**: HotSpot JVM, Java Sound API
- **Platform Editions**: SE, EE, ME distinction introduced

#### 2000-2004: Enterprise Focus
- **Java 1.4**: Regular expressions, assertions, XML processing
- **J2EE Growth**: Enterprise development becomes primary focus

#### 2004-2006: Major Language Evolution
- **Java 5 (Java 1.5)**: 
  - Generics for type safety
  - Annotations for metadata
  - Enums (used extensively in this project)
  - Enhanced for-loops
  - Autoboxing/unboxing
  - Varargs

#### 2006-2010: Performance & Libraries
- **Java 6**: Performance improvements, scripting support
- **Java 7**: Try-with-resources, diamond operator, switch with strings
- **2010**: Oracle acquires Sun Microsystems

#### 2014-2017: Modern Java Era
- **Java 8** (LTS): 
  - Lambda expressions and functional programming
  - Stream API (used in this project)
  - Optional class
  - New Date/Time API
- **Java 9**: Module system (Project Jigsaw), JShell

#### 2018-Present: Rapid Release Cycle
- **New Model**: 6-month release cycle introduced
- **Java 11** (LTS): HTTP Client API, local variable type inference improvements
- **Java 17** (LTS): Sealed classes, pattern matching enhancements
- **Java 21** (LTS): Virtual threads, pattern matching for switch

### Key Java Principles

#### Platform Independence
```java
// Java source code (.java)
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

// Compiled to bytecode (.class) - platform independent
// JVM interprets bytecode on specific platform
```

#### Object-Oriented Paradigm
- **Everything is an object** (except primitives)
- **Inheritance**: Code reuse through class hierarchies
- **Polymorphism**: Same interface, different implementations
- **Encapsulation**: Data hiding and controlled access

#### Memory Management
- **Automatic Garbage Collection**: No manual memory management
- **Heap and Stack**: Separate memory areas for objects and method calls
- **Reference-based**: Objects accessed through references, not pointers

#### Strong Type System
- **Compile-time checking**: Prevents many runtime errors
- **Type safety**: Generics provide compile-time type checking
- **No implicit conversions**: Explicit casting required

---

## 🏗 Architecture Details

### Layered Architecture

#### 1. Presentation Layer (`edu.ccrm.cli`)
- **AppCLI.java**: Main application entry point and user interface
- **Responsibilities**:
  - User input handling and validation
  - Menu navigation and flow control
  - Output formatting and display
  - Exception handling and user feedback

#### 2. Service Layer (`edu.ccrm.service`)
- **Business Logic**: Core application functionality
- **Services**:
  - `StudentService`: Student CRUD operations and business rules
  - `CourseService`: Course management and validation
  - `EnrollmentService`: Enrollment processing and GPA calculations
- **Responsibilities**:
  - Business rule enforcement
  - Data validation and transformation
  - Transaction coordination

#### 3. Domain Layer (`edu.ccrm.domain`)
- **Entity Classes**: Core business objects
- **Entities**:
  - `Person`: Base class with common attributes
  - `Student`: Student-specific data and behavior  
  - `Course`: Course information with Builder pattern
  - `Enrollment`: Relationship between Student and Course
  - `Instructor`: Faculty information
- **Enums**: `Grade`, `Semester`, Status enumerations

#### 4. Infrastructure Layer (`edu.ccrm.io`, `edu.ccrm.config`)
- **I/O Operations**: File handling and data persistence
- **Configuration**: Application settings and constants
- **Utilities**: Helper classes and validation logic

#### 5. Cross-Cutting Concerns (`edu.ccrm.exceptions`)
- **Exception Handling**: Custom business exceptions
- **Error Management**: Centralized error handling strategy

### Design Patterns Implementation

#### Singleton Pattern (AppConfig)
```java
public class AppConfig {
    private static AppConfig instance;
    
    private AppConfig() { } // Private constructor
    
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
}
```
**Benefits**: 
- Single point of configuration
- Global access to settings
- Memory efficiency

#### Builder Pattern (Course)
```java
Course course = new Course.Builder()
    .setCode("CS101")
    .setTitle("Introduction to Programming")
    .setCredits(3)
    .setSemester(Semester.FALL)
    .build();
```
**Benefits**:
- Flexible object construction
- Immutable objects
- Readable code

#### Strategy Pattern (Validators)
```java
public class Validators {
    public static boolean isValidEmail(String email) { /* ... */ }
    public static boolean isValidPhone(String phone) { /* ... */ }
    // Different validation strategies
}
```

### Data Flow Architecture

```
User Input → CLI Layer → Service Layer → Domain Layer → Data Storage
     ↓           ↓           ↓            ↓            ↓
Validation → Business → Entity → Persistence → In-Memory
  Logic      Rules    Creation    Layer      Collections
```

### Error Handling Strategy

#### Exception Hierarchy
```
Exception
├── StudentNotFoundException
├── CourseNotFoundException  
├── DuplicateEnrollmentException
├── MaxCreditLimitExceededException
└── EnrollmentNotFoundException
```

#### Error Handling Flow
1. **Input Validation**: CLI layer validates user input
2. **Business Rule Enforcement**: Service layer checks business constraints
3. **Exception Propagation**: Custom exceptions bubble up to CLI
4. **User Feedback**: Friendly error messages displayed to user

---

## 🐛 Known Issues & Future Enhancements

### Current Limitations

#### 1. Data Persistence
- **Issue**: Data is stored in memory only
- **Impact**: All data lost when application closes
- **Workaround**: Use export feature before closing
- **Future Fix**: Implement database integration or file-based persistence

#### 2. Concurrent Access
- **Issue**: No multi-user support
- **Impact**: Single user application only
- **Future Fix**: Add user authentication and concurrent access control

#### 3. Input Validation
- **Issue**: Limited input format validation
- **Impact**: Some invalid inputs may cause errors
- **Future Fix**: Enhanced validation with regex patterns

### Planned Enhancements

#### Short Term (Next Version)
- [ ] **File-based persistence**: Save data to JSON/XML files
- [ ] **Enhanced reporting**: PDF export capabilities
- [ ] **Bulk import**: Excel file support for data import
- [ ] **Search functionality**: Find students/courses by various criteria
- [ ] **Audit logging**: Track all system changes

#### Medium Term (Future Versions)
- [ ] **Web interface**: Convert CLI to web-based GUI
- [ ] **Database integration**: MySQL/PostgreSQL support
- [ ] **Authentication**: User login and role-based access
- [ ] **Email notifications**: Send grade reports via email
- [ ] **Mobile app**: Android/iOS companion app

#### Long Term (Major Releases)
- [ ] **Cloud deployment**: AWS/Azure hosting
- [ ] **Microservices architecture**: Break into smaller services
- [ ] **AI integration**: Predictive analytics for student performance
- [ ] **Integration APIs**: Connect with other campus systems

### Performance Optimizations

#### Current Performance
- **Lookup operations**: O(1) for HashMap-based searches
- **List operations**: O(n) for ArrayList iterations
- **Memory usage**: Minimal for small datasets

#### Potential Improvements
- **Indexing**: Add secondary indexes for common searches
- **Caching**: Cache frequently accessed data
- **Pagination**: Handle large datasets efficiently
- **Lazy loading**: Load data on-demand

---

## 🤝 Contributing

### Development Guidelines

#### Code Style
- **Naming Convention**: camelCase for methods, PascalCase for classes
- **Comments**: JavaDoc for public methods, inline for complex logic
- **Formatting**: 4-space indentation, 100-character line limit
- **Error Handling**: Use specific exceptions, meaningful error messages

#### Adding New Features
1. **Create feature branch**: `feature/your-feature-name`
2. **Follow package structure**: Place files in appropriate packages
3. **Add tests**: Include test cases for new functionality
4. **Update documentation**: Modify README if needed
5. **Create pull request**: Describe changes and test results

#### Bug Reports
Include the following information:
- **Java version**: Output of `java -version`
- **Operating system**: Windows/Linux/macOS version
- **Steps to reproduce**: Detailed reproduction steps
- **Expected behavior**: What should happen
- **Actual behavior**: What actually happens
- **Error messages**: Complete error output

### Project Maintenance

#### Regular Updates
- **Dependencies**: Keep Java version updated
- **Security**: Review for potential vulnerabilities
- **Documentation**: Keep README synchronized with code
- **Testing**: Add automated tests for critical functionality

#### Version Control
- **Git workflow**: Use feature branches for development
- **Commit messages**: Clear, descriptive commit messages
- **Release tags**: Tag stable versions
- **Changelog**: Maintain version history

---

## 📞 Support & Contact

### Getting Help

#### Common Issues
1. **Compilation Errors**: Check Java version and CLASSPATH
2. **Runtime Exceptions**: Verify input data format
3. **File Permissions**: Ensure write access to data directories
4. **Memory Issues**: Increase JVM heap size if needed

#### Resources
- **Java Documentation**: [Oracle Java Docs](https://docs.oracle.com/javase/)
- **Java Tutorials**: [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- **Stack Overflow**: [Java Questions](https://stackoverflow.com/questions/tagged/java)

### Academic Use

This project is designed for educational purposes and demonstrates:
- **Software Engineering Principles**: Clean architecture and design patterns
- **Java Programming**: Core language features and best practices  
- **Problem Solving**: Real-world application development
- **Documentation**: Professional-level documentation standards

---

## 📄 License & Academic Integrity

### Academic Use Policy
This project is created for educational purposes. Students are encouraged to:
- **Learn from the code**: Understand the implementation techniques
- **Customize and extend**: Add personal touches and new features
- **Follow academic guidelines**: Respect your institution's academic integrity policies

### Customization Requirements
Before submission, please:
- [ ] Replace "Ak" with your actual name throughout the codebase
- [ ] Modify constants and configuration values
- [ ] Add personal comments and implementation notes
- [ ] Customize features based on your specific requirements
- [ ] Test thoroughly and fix any issues

### Disclaimer
This code is provided as-is for educational purposes. While functional and well-structured, it may require additional features or modifications based on specific academic requirements.

---

## 🎉 Conclusion

The Campus Course and Records Manager demonstrates comprehensive Java programming skills including object-oriented design, exception handling, collections framework usage, and clean architecture principles. The project provides a solid foundation for understanding enterprise Java development patterns and can be extended with additional features as needed.

**Happy Coding! 🚀**

---

*Last Updated: September 2025*  
*Version: 1.0.0*  
*Java Version: 8+*