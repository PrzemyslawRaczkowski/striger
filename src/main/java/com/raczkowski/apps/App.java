package com.raczkowski.apps;

import com.raczkowski.apps.controller.*;
import com.raczkowski.apps.model.*;
import com.raczkowski.apps.model.repository.*;
import com.raczkowski.apps.view.Components;
import com.raczkowski.apps.view.Menu;

import java.util.List;

import static java.util.Arrays.asList;

public class App {
    private static final List<String> registrationComponents = asList(
            "1. Log in.",
            "2. Registration.");

    private static final List<String> rootMenuComponents = asList(
            "1. Open articles manager.",
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
        ArticlesDao articlesDao = new ArticlesJDBCDao();
        CommentDao commentDao = new CommentsJDBCDao();
        UsersCSVDao usersRepository = new UsersCSVDao("src/main/resources/Users.csv");

        new RegistrationController(
                new RootController(
                        new ArticlesController(
                                articlesDao,
                                commentDao,
                                new ArticlesCreator(),
                                new ArticlesStatistics(articlesDao),
                                new Menu(new Components(articlesMenuComponents)),
                                new TablePrinter(),
                                new CommentCreator(),
                                new DataRange()),
                        new UsersController(),
                        new CommentsController(commentDao,
                                new Menu(new Components(commentsMenuComponents)),
                                new CommentCreator(),
                                articlesDao,
                                new TablePrinter()),
                        new Menu(
                                new Components(rootMenuComponents)
                        )),
                new Components(registrationComponents),
                new LogIn(usersRepository),
                new Registration(usersRepository)).handle();
    }
}
