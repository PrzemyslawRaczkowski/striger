package com.raczkowski.apps.model;

public class Users {
    private int id;
    private String name;

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
