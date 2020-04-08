package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.UsersRepository;

import java.util.List;

public class LogIn {
    private final UsersRepository userRepository;

    public LogIn(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean logIn(TemporaryUser temporaryUser) {
        boolean status = false;
        List<User> users = userRepository.loadUsers();

        for (User user : users) {
            if (temporaryUser.geteMail().equalsIgnoreCase(user.geteMail())) {
                if(temporaryUser.getPassword().equals(user.getPassword()));
                {
                    System.out.println("Successfully logged");
                    status=true;
                }
            }
        }
        return status;
    }
}
