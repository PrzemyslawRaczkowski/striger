package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;

import java.util.ArrayList;

public interface ArticlesRepository {

    void addArticle(Article article);

    void addArticles(ArrayList<Article> articles);

    ArrayList<Article> loadArticles();

    Article loadArticleById(int id);

}
