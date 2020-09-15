package com.raczkowski.apps.model;

public class LoggedInUserData {
    private String name;
    private String surname;

    public LoggedInUserData(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
