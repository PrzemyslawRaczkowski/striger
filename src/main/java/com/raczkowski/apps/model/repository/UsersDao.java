package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.User;
import com.raczkowski.apps.model.UserRegistrationData;

import java.util.List;

public interface UsersDao {

    void addUser(UserRegistrationData user);

    List<User> loadUsers();
}
