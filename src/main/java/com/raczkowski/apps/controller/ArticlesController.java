package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.ArticlesCreator;
import com.raczkowski.apps.model.ArticlesDataController;

public class ArticlesController implements Controller {
    @Override
    public void handle() {
        ArticlesDataController articlesDataController = new ArticlesDataController();
        ArticlesCreator articlesCreator = new ArticlesCreator();
        articlesDataController.articlesWriter(articlesCreator.articlesCreator());
        System.out.println(articlesDataController.articlesReader());
    }
}