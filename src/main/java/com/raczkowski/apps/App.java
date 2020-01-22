package com.raczkowski.apps;

import com.raczkowski.apps.controller.ArticlesController;
import com.raczkowski.apps.controller.CommentsController;
import com.raczkowski.apps.controller.RootController;
import com.raczkowski.apps.controller.UsersController;
import com.raczkowski.apps.model.Articles;
import com.raczkowski.apps.view.View;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        new App().run();
        ArticlesController articlesController = new ArticlesController();
        articlesController.handle();
        CommentsController commentsController=new CommentsController();
        commentsController.handle();
        UsersController usersController=new UsersController();
        usersController.handle();
    }

    private void run() {
        View view = new View() {
            @Override
            public void view() {
            }
        };
        new RootController(new ArticlesController(), new UsersController(), view)
                .handle();
    }
}
