package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.UsersRepository;

import java.util.List;

public class Registration {
    private UsersRepository userRepository;

    public Registration(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registration(TemporaryUser temporaryUser) {
        boolean status = true;
        List<User> users = userRepository.loadUsers();
        for (User user : users) {
            if (user.geteMail().equals(temporaryUser.geteMail())) {
                status = false;
                System.out.println("User of " + temporaryUser.geteMail() + " already registered!");
            }
        }
        if (status) {
            userRepository.addUser(temporaryUser);
        }
        return status;
    }
}
