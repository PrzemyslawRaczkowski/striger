package com.raczkowski.apps.controller;

import com.raczkowski.apps.view.View;

import java.util.Scanner;

import static java.lang.System.in;

public class RootController implements Controller {

    private final ArticlesController articlesController;
    private final UsersController usersController;
    private final CommentsController commentsController;
    private final View menu;

    public RootController(ArticlesController articlesController,
                          UsersController usersController,
                          CommentsController commentsController, View menu) {
        this.articlesController = articlesController;
        this.usersController = usersController;
        this.commentsController = commentsController;
        this.menu = menu;
    }

    @Override
    public void handle() {
        boolean run = true;

        while (run) {
            menu.view();
            String userChoice = handleInput();
            switch (userChoice) {
                case "1":
                    articlesController.handle();
                    break;
                case "2":
                    commentsController.handle();
                    break;
                case "3":
                    usersController.handle();
                    break;
                case "Q":
                    run = false;
                    System.out.println("Bye, Bye!");
                    break;
                default:
                    System.out.println("Unknown command, please try again");
            }
        }
    }

    private String handleInput() {
        System.out.print("Your choice: ");
        return new Scanner(in).next();
    }
}
