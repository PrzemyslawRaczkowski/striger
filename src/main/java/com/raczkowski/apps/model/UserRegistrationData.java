package com.raczkowski.apps.model;

public class UserRegistrationData {
    private String name;
    private String lastName;
    private String email;
    private String password;

    public UserRegistrationData(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getMail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

}
