package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private int zip;
    private boolean isAdmin;

    // General Constructor to instantiate User without creating a User
    public User() {}

    // Constructor for the user
    public User(String username, String email, String password,int zip) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.zip = zip;
        isAdmin = false;
    }

    // Constructor for the backend where we have the id from the database
    public User(long id, String username, String email, String password,int zip) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.zip = zip;
        isAdmin = false;
    }

    // Getters and Setters for all properties
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
