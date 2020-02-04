package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Users;
import com.raczkowski.apps.model.UsersDataController;

import java.util.ArrayList;

public class UsersController implements Controller {

    @Override
    public void handle() {
        ArrayList<Users> usersList=new ArrayList<>();
        Users user= new Users(1,"Jan","Kowalski");
        Users user1= new Users(2,"Tomasz","Jeżyna");
        usersList.add(user);
        usersList.add(user1);
        UsersDataController userDataController=new UsersDataController();
        userDataController.userWriter(usersList);
        System.out.println(userDataController.usersReader());
    }
}
