package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.*;

import com.raczkowski.apps.model.repository.ArticlesRepository;
import com.raczkowski.apps.model.repository.CommentRepository;
import com.raczkowski.apps.view.View;
import org.apache.commons.lang3.ObjectUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.in;

public class ArticlesController implements Controller {

    private final ArticlesRepository articlesRepository;
    private final CommentRepository commentRepository;
    private final ArticlesCreator articlesCreator;
    private final ArticlesStatistics articlesStatistics;
    private final View menu;
    private final TablePrinter tablePrinter;
    private final CommentCreator commentCreator;
    private final DataRange dataRange;

    public ArticlesController(ArticlesRepository articlesRepository,
                              CommentRepository commentRepository,
                              ArticlesCreator articlesCreator,
                              ArticlesStatistics articlesStatistics,
                              View menu,
                              TablePrinter tablePrinter,
                              CommentCreator commentCreator,
                              DataRange dataRange) {
        this.articlesRepository = articlesRepository;
        this.commentRepository = commentRepository;
        this.articlesCreator = articlesCreator;
        this.articlesStatistics = articlesStatistics;
        this.menu = menu;
        this.tablePrinter = tablePrinter;
        this.commentCreator = commentCreator;
        this.dataRange = dataRange;
    }

    @Override
    public void handle() {
        boolean run = true;

        while (run) {
            menu.view();
            String userChoice = handleInput();
            switch (userChoice) {
                case "1":
                    tablePrinter.printArticles(articlesRepository.loadArticles());
                    articlesChoice();
                    break;
                case "2":
                    articlesRepository.addArticle(articlesCreator.create());
                    break;
                case "3":
                    tablePrinter.printArticles(articlesStatistics.articlesFromToday());
                    break;
                case "4":
                    tablePrinter.printArticles(articlesStatistics.articlesFromRange(rangeMenu()));
                    break;
                case "5":
                    tablePrinter.printArticles(articlesStatistics.articlesOfAuthor(authorMenu()));
                    break;
                case "6":
                    tablePrinter.printArticles(articlesStatistics.articlesOfLongestContext());
                    break;
                case "7":
                    tablePrinter.printArticles(articlesStatistics.articlesFilter(sortMenu()));
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

    private DataRange rangeMenu() {
        System.out.println("Insert range of date in format (yyyy-mm-dd).");
        System.out.println("Start range: ");
        dataRange.setStartRangeTime(LocalDate.parse(new Scanner(in).nextLine()));
        System.out.println("End range: ");
        dataRange.setEndRangeTime(LocalDate.parse(new Scanner(in).nextLine()));
        return dataRange;
    }

    private String handleInput() {
        System.out.print("Your choice: ");
        return new Scanner(in).nextLine();
    }

    private void articlesChoice() {
        System.out.println("What do you want to do next ?");
        System.out.println("1. Add new comment.");
        System.out.println("2. Show all comment of article");
        System.out.println("B - for back");
        String choice = new Scanner(in).nextLine();
        boolean run = true;
        while (run) {
            switch (choice) {
                case "1":
                    tablePrinter.printArticles(articlesRepository.loadArticles());
                    System.out.println("Choose id of Article: ");
                    String choice1 = new Scanner(in).nextLine();
                    tablePrinter.printArticle(articlesRepository.loadArticleById(Integer.parseInt(choice1)));
                    commentRepository.addComment(commentCreator.create(),
                            articlesRepository.loadArticleById(Integer.parseInt(choice1)));
                    System.out.println("Successfully added !");
                    run = false;
                    break;
                case "2":
                    tablePrinter.printArticles(articlesRepository.loadArticles());
                    System.out.println("Choose id of Article: ");
                    String choice2 = new Scanner(in).nextLine();
                    tablePrinter.printComments(commentRepository.
                            commentsOfArticles(articlesRepository.loadArticles().get(Integer.parseInt(choice2) - 1)));
                    run = false;
                    break;
                case "B":
                    run = false;
                default:
                    System.out.println("Wrong credentials, try again.");
            }
        }
    }
}