package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;

import java.util.List;

public interface ArticlesRepository {

    void addArticle(Article article);

    void addArticles(List<Article> articles);

    void loadArticles();

    void loadArticleById(int id);

}
