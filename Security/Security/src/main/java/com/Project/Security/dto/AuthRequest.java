package com.Project.Security.dto;



public class AuthRequest {


    private String username;

    private String password;

  //  private String roles;  // New field for role

    // Constructors
    public AuthRequest() {}

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for role
//    public String getRoles() {
//        return roles;
//    }
//    public void setRole(String roles) {
//        this.roles = roles;
//    }
}