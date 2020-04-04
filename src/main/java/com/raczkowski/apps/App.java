package com.raczkowski.apps;

import com.raczkowski.apps.controller.*;
import com.raczkowski.apps.model.*;
import com.raczkowski.apps.model.repository.ArticlesCSVRepository;
import com.raczkowski.apps.model.repository.ArticlesRepository;
import com.raczkowski.apps.model.repository.CommentCSVRepository;
import com.raczkowski.apps.view.Components;
import com.raczkowski.apps.view.Menu;

import java.util.List;

import static java.util.Arrays.asList;

public class App {

    private static final List<String> rootMenuComponents = asList(
            "1. Open articles menager.",
            "2. Show comments.",
            "3. Show users.",
            "Q - for quit");

    private static final List<String> articlesMenuComponents = asList(
            "1. Show articles.",
            "2. Add new article.",
            "3. Show articles from today.",
            "4. Show articles in time range.",
            "5. Show articles for author.",
            "6. Get longest article.",
            "7. Filter articles.",
            "B - for back");

    private static final List<String> commentsMenuComponents = asList(
            "1. Show Comments",
            "2. Create Comment",
            "B - for back");

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        ArticlesRepository articlesRepository = new ArticlesCSVRepository("src/main/resources/Articles.csv");
        CommentCSVRepository commentsRepository = new CommentCSVRepository("src/main/resources/Comments.csv");

        new RootController(
                new ArticlesController(
                        articlesRepository,
                        commentsRepository,
                        new ArticlesCreator(),
                        new ArticlesStatistics(articlesRepository),
                        new Menu(new Components(articlesMenuComponents)),
                        new TablePrinter(),
                        new CommentCreator(),
                        new DataRange()),
                new UsersController(),
                new CommentsController(commentsRepository,
                        new Menu(new Components(commentsMenuComponents)),
                        new CommentCreator(),
                        articlesRepository,
                        new TablePrinter()),
                new Menu(
                        new Components(rootMenuComponents)
                )
        ).handle();
    }
}
