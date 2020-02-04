package com.raczkowski.apps.model;

public class Users {
    private int id;
    private String name;
    private String lastName;

    public Users(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Users { " +
                "id = " + id +
                ", name = " + name +
                ", lastName = " + lastName +
                '}'+'\n';
    }
}
