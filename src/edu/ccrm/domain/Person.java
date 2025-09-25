package edu.ccrm.domain;

public abstract class Person {
    protected String id;
    protected String name;
    protected String email;
    protected String dateOfBirth;
    
    public Person(String id, String name, String email, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    
    // Getters and setters with proper encapsulation
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDateOfBirth() { return dateOfBirth; }
    
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}