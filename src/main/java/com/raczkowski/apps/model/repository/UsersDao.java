package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.LoggedInUserData;
import com.raczkowski.apps.model.User;
import com.raczkowski.apps.model.UserLoginData;
import com.raczkowski.apps.model.UserRegistrationData;

import java.util.List;

public interface UsersDao {

    void addUser(UserRegistrationData user);

    List<User> loadUsers();

    LoggedInUserData selectDataOfUser(UserLoginData userLoginData);
}
