package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.ArticlesCreator;
import com.raczkowski.apps.model.ArticlesStatistics;

import com.raczkowski.apps.model.repository.ArticlesRepository;
import com.raczkowski.apps.view.View;

import java.util.ArrayList;
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
                    System.out.println(articlesRepository.loadArticles());
                    break;
                case "2":
                    articlesRepository.addArticle(articlesCreator.create());
                    break;
                case "3":
                    System.out.println(articlesStatistics.articlesFromToday());
                    break;
                case "4":
                    System.out.println(articlesStatistics.articlesFromRange(rangeMenu()));
                    break;
                case "5":
                    System.out.println(articlesStatistics.articlesOfAuthor(authorMenu()));
                    break;
                case "6":
                    System.out.println(articlesStatistics.articlesOfLongestContext());
                    break;
                case "7":
                    System.out.println(articlesStatistics.articlesFiler(sortMenu()));
                    break;
                case "B":
                    run = false;
                    break;
                default:
                    System.out.println("Unknown command, please try again");
            }
        }
    }

    private String sortMenu() {
        System.out.println("How do you want to sort ?");
        System.out.println("1. Ascending.");
        System.out.println("2. Descending.");
        return handleInput();
    }

    private String authorMenu() {
        System.out.println("Insert author: ");
        return new Scanner(in).nextLine();
    }

    private ArrayList<Integer> rangeMenu() {
        System.out.println("Insert range of months.");
        System.out.println("First month: ");
        int scanner = new Scanner(in).nextInt();
        System.out.println("Last month: ");
        int scanner1 = new Scanner(in).nextInt();
        ArrayList<Integer> choice=new ArrayList<>();
        choice.add(scanner);
        choice.add(scanner1);
        return choice;
    }

    private String handleInput() {
        System.out.print("Your choice: ");
        return new Scanner(in).nextLine();
    }
}