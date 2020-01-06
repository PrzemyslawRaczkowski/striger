package com.raczkowski.apps.controller;

import java.io.InputStream;

import static java.lang.System.out;

public class RootController implements Controller {

    private final ArticlesController articlesController;
    private final UsersController usersController;

    public RootController(ArticlesController articlesController, UsersController usersController) {
        this.articlesController = articlesController;
        this.usersController = usersController;
    }

    @Override
    public void handle() {
        out.println("Menu: ");
        out.println("1. Users manager.");
        out.println("2. Articles manager.");


    }
}
