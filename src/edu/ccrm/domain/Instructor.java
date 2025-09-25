package edu.ccrm.domain;

public class Instructor extends Person {
    private String employeeId;
    private String department;
    private String officeLocation;
    
    public Instructor(String employeeId, String name, String email, String dob, String department) {
        super(employeeId, name, email, dob);
        this.employeeId = employeeId;
        this.department = department;
    }
    
    public String getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }
    public String getOfficeLocation() { return officeLocation; }
    
    public void setDepartment(String department) { this.department = department; }
    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }
    
    @Override
    public String toString() {
        return String.format("Instructor[%s: %s (%s)]", employeeId, name, department);
    }
}