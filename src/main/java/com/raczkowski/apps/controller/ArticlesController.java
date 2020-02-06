package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.ArticlesCreator;
import com.raczkowski.apps.model.repository.ArticlesRepository;
import com.raczkowski.apps.view.View;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;

public class ArticlesController implements Controller {

    private final ArticlesRepository articlesRepository;
    private final ArticlesCreator articlesCreator;
    private final View menu;

    public ArticlesController(ArticlesRepository articlesRepository,
                              ArticlesCreator articlesCreator,
                              View menu) {
        this.articlesRepository = articlesRepository;
        this.articlesCreator = articlesCreator;
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
                    articlesRepository.loadArticles();
                    break;
                case "2":
                    articlesRepository.addArticle(articlesCreator.create());
                    break;
                case "B":
                    run = false;
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