package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.TemporaryUser;
import com.raczkowski.apps.model.User;

import java.util.List;

public interface UsersRepository {
    void addUser(TemporaryUser user);

    List<User> loadUsers();
}
