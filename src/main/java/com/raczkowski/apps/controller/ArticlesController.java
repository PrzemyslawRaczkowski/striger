package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Articles;
import com.raczkowski.apps.model.ArticlesDataController;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticlesController implements Controller {
    @Override
    public void handle() {

        ArrayList<Articles> articlesList = new ArrayList<>();
        Articles articles = new Articles(1, "title1", "contect1", "Bartłomiej raczkowski", LocalDate.now());
        Articles articles1 = new Articles(2, "title2", "contect2", "Bartłomiej ", LocalDate.now().minusMonths(2));
        Articles articles2 = new Articles(3, "title3", "contect3", "Bartłomiej raczkowki", LocalDate.now().minusDays(3));
        articlesList.add(articles);
        articlesList.add(articles1);
        articlesList.add(articles2);
        ArticlesDataController articlesDataController = new ArticlesDataController();
        articlesDataController.dataWriter(articlesList);

        System.out.println(articlesDataController.dataReader());
    }
}