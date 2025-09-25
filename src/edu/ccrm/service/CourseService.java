package edu.ccrm.service;

import java.util.*;
import java.util.stream.Collectors;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Course.CourseStatus;
import edu.ccrm.exceptions.CourseNotFoundException;

public class CourseService {
    private Map<String, Course> courses = new HashMap<>();
    
    public void addCourse(Course course) {
        if (courses.containsKey(course.getCode())) {
            throw new IllegalArgumentException("Course with this code already exists: " + course.getCode());
        }
        
        courses.put(course.getCode(), course);

    }
    
    public Course getCourse(String courseCode) throws CourseNotFoundException {
        Course course = courses.get(courseCode);
        if (course == null) {
            throw new CourseNotFoundException("Course not found: " + courseCode);
        }
        return course;
    }
    
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }
    
    public List<Course> getAllActiveCourses() {
        return courses.values().stream()
            .filter(course -> course.getStatus() == CourseStatus.ACTIVE)
            .collect(Collectors.toList());
    }
    
    public void deactivateCourse(String courseCode) throws CourseNotFoundException {
        Course course = getCourse(courseCode);
        course.setStatus(CourseStatus.INACTIVE);

    }
    
    public List<Course> getCoursesByDepartment(String department) {
        return courses.values().stream()
            .filter(course -> course.getDepartment().equalsIgnoreCase(department))
            .collect(Collectors.toList());
    }
}