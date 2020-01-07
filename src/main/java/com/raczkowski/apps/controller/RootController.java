package com.raczkowski.apps.controller;

import com.raczkowski.apps.view.View;

public class RootController implements Controller {

    private final ArticlesController articlesController;
    private final UsersController usersController;
    private final View menu;

    public RootController(ArticlesController articlesController,
                          UsersController usersController,
                          View menu) {
        this.articlesController = articlesController;
        this.usersController = usersController;
        this.menu = menu;
    }

    @Override
    public void handle() {
        menu.view();


    }
}
