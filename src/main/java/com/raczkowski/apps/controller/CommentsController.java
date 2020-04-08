package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.CommentCreator;
import com.raczkowski.apps.model.repository.ArticlesDao;
import com.raczkowski.apps.model.repository.CommentCSVDao;
import com.raczkowski.apps.model.repository.CommentDao;
import com.raczkowski.apps.view.View;

import java.util.Scanner;

import static java.lang.System.in;

public class CommentsController implements Controller {

    private final CommentDao commentDao;
    private final View menu;
    private final CommentCreator commentCreator;
    private final ArticlesDao articlesDao;
    private final TablePrinter tablePrinter;

    public CommentsController(CommentCSVDao commentFileRepository,
                              View menu,
                              CommentCreator commentCreator,
                              ArticlesDao articlesDao,
                              TablePrinter tablePrinter) {
        this.menu = menu;
        this.commentDao = commentFileRepository;
        this.commentCreator = commentCreator;
        this.articlesDao = articlesDao;
        this.tablePrinter = tablePrinter;
    }

    @Override
    public void handle() {
        boolean run = true;

        while (run) {
            menu.view();
            String userChoice = handleInput();
            switch (userChoice) {
                case "1":
                    tablePrinter.printComments(commentDao.showComment());
                    break;
                case "2":
                    tablePrinter.printArticles(articlesDao.loadArticles());
                    String choiceArticle = commentMenu();
                    commentDao.addComment(commentCreator.create(), articlesDao.loadArticleById(Integer.parseInt(choiceArticle)));
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

    private String commentMenu() {
        System.out.println("Choose id of article: ");
        return new Scanner(in).nextLine();
    }
}