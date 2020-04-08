package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.UsersDao;

import java.util.List;

public class Registration {
    private UsersDao userRepository;

    public Registration(UsersDao userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegistrationData userRegistrationData) {
        boolean alreadyRegistered = false;
        List<User> users = userRepository.loadUsers();
        for (User user : users) {
            if (user.getMail().equals(userRegistrationData.getMail())) {
                System.out.println("User of " + userRegistrationData.getMail() + " already registered!");
                alreadyRegistered = true;
            }
        }

        if (!alreadyRegistered) {
            userRepository.addUser(userRegistrationData);
        }

    }
}
