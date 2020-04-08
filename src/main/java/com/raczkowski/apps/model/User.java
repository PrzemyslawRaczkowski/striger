package com.raczkowski.apps.model;


public class User {
    private int id;
    private String name;
    private String lastName;
    private String eMail;
    private String password;

    public User(int id, String name, String lastName, String eMail, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users { " +
                "id = " + id +
                ", name = " + name +
                ", lastName = " + lastName +
                ", e-Mail =" + eMail +
                ", password =" + password +
                '}' + '\n';
    }
}
