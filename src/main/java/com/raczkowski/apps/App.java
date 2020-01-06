package com.raczkowski.apps;

import com.raczkowski.apps.controller.ArticlesController;
import com.raczkowski.apps.controller.RootController;
import com.raczkowski.apps.controller.UsersController;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        new RootController(new ArticlesController(), new UsersController())
                .handle();
    }
}
