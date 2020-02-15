package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.ArticlesCreator;
import com.raczkowski.apps.model.ArticlesStatistics;

import com.raczkowski.apps.model.repository.ArticlesRepository;
import com.raczkowski.apps.view.View;

import java.util.Scanner;

import static java.lang.System.in;

public class ArticlesController implements Controller {

    private final ArticlesRepository articlesRepository;
    private final ArticlesCreator articlesCreator;
    private final ArticlesStatistics articlesStatistics;
    private final View menu;

    public ArticlesController(ArticlesRepository articlesRepository,
                              ArticlesCreator articlesCreator,
                              ArticlesStatistics articlesStatistics, View menu) {
        this.articlesRepository = articlesRepository;
        this.articlesCreator = articlesCreator;
        this.articlesStatistics = articlesStatistics;
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
                case "3":
                    System.out.println(articlesStatistics.articlesFromToday());
                    break;
                case "4":
                    String userChoice1 = handleInput();
                    String userChoice2 = handleInput();
                    System.out.println(articlesStatistics.articlesFromRange(userChoice1,userChoice2));
                    break;
                case "5":
                    String choice1 = handleInput();
                    System.out.println(articlesStatistics.articlesOfAuthor(choice1));
                    break;
                case "6":
                    System.out.println(articlesStatistics.articlesOfLongestContext());
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
        return new Scanner(in).nextLine();
    }
}