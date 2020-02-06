package com.raczkowski.apps;

import com.raczkowski.apps.controller.ArticlesController;
import com.raczkowski.apps.controller.CommentsController;
import com.raczkowski.apps.controller.RootController;
import com.raczkowski.apps.controller.UsersController;
import com.raczkowski.apps.model.ArticlesCreator;
import com.raczkowski.apps.model.repository.ArticlesFileRepository;
import com.raczkowski.apps.view.Components;
import com.raczkowski.apps.view.Menu;

import java.util.List;

import static java.util.Arrays.asList;

public class App {

    private final List<String> rootMenuComponents = asList(
            "1. Show articles.",
            "2. Show comments.",
            "3. Show users.",
            "4. Q - for quit");

    private final List<String> articlesMenuComponents = asList(
            "1. Show articles.",
            "2. Add new article.",
            "3. Show articles from today.",
            "4. Show articles in time range.",
            "5. Show articles for author.",
            "6. Get longest article.",
            "3. B - for back");

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        new RootController(
                new ArticlesController(
                        new ArticlesFileRepository(),
                        new ArticlesCreator(),
                        new Menu(
                                new Components(articlesMenuComponents)
                        )),
                new UsersController(),
                new CommentsController(),
                new Menu(
                        new Components(rootMenuComponents)
                )
        ).handle();
    }
}
