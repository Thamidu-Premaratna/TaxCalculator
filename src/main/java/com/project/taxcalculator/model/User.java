package com.project.taxcalculator.model;

public class User {

    // Private attributes for the User model class
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;

    // Constructor and Getters and Setters

    public User() {
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
