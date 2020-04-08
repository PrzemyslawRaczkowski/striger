package com.raczkowski.apps.model;

public class TemporaryUser {
    private String name;
    private String lastName;
    private String eMail;
    private String password;


    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
