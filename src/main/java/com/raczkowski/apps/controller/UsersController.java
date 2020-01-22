package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Comment;
import com.raczkowski.apps.model.CommentDataController;
import com.raczkowski.apps.model.Users;
import com.raczkowski.apps.model.UsersDataController;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsersController implements Controller {

    @Override
    public void handle() {
        ArrayList<Users> usersList=new ArrayList<>();
        Users user= new Users(1,"Name1");
        usersList.add(user);
        UsersDataController userDataController=new UsersDataController();
        userDataController.userWriter(usersList);
        System.out.println(userDataController.usersReader());
    }
}
