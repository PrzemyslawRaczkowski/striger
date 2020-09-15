package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.UsersDao;

import java.util.List;

public class LogIn {
    private final UsersDao userRepository;

    public LogIn(UsersDao userRepository) {
        this.userRepository = userRepository;
    }

    public User logIn(UserLoginData userLoginData) {
        List<User> users = userRepository.loadUsers();

        User loggedInUser = null;
        for (User user : users) {
            if (userLoginData.getEmail().equalsIgnoreCase(user.getMail())) {
                if (userLoginData.getPassword().equals(user.getPassword())) {
                    System.out.println("Successfully logged in");
                    loggedInUser = user;
                }
            }
        }
        return loggedInUser;
    }
}