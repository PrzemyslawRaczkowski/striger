package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.CommentCreator;
import com.raczkowski.apps.model.repository.ArticlesRepository;
import com.raczkowski.apps.model.repository.CommentCSVRepository;
import com.raczkowski.apps.model.repository.CommentRepository;
import com.raczkowski.apps.view.View;

import java.util.Scanner;

import static java.lang.System.in;

public class CommentsController implements Controller {

    private final CommentRepository commentRepository;
    private final View menu;
    private final CommentCreator commentCreator;
    private final ArticlesRepository articlesRepository;
    private final TablePrinter tablePrinter;

    public CommentsController(CommentCSVRepository commentFileRepository,
                              View menu,
                              CommentCreator commentCreator,
                              ArticlesRepository articlesRepository,
                              TablePrinter tablePrinter) {
        this.menu = menu;
        this.commentRepository = commentFileRepository;
        this.commentCreator = commentCreator;
        this.articlesRepository = articlesRepository;
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
                    tablePrinter.printComments(commentRepository.showComment());
                    break;
                case "2":
                    tablePrinter.printArticles(articlesRepository.loadArticles());
                    String choiceArticle = commentMenu();
                    commentRepository.addComment(commentCreator.create(), articlesRepository.loadArticleById(Integer.parseInt(choiceArticle)));
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