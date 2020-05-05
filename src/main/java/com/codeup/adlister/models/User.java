package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private int zip;
    private boolean isAdmin = false;

    public User() {}

    public User(String username, String email, String password,int zip) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.zip = zip;
    }

    public User(long id, String username, String email, String password,int zip) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.zip = zip;
    }

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
        this.password = Password.hash(password);
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
}
