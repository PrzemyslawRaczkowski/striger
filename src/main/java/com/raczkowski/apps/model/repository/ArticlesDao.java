package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ArticlesDao {

    void addArticle(Article article);

    void addArticles(ArrayList<Article> articles);

    List<Article> loadArticles();

    Article loadArticleById(int id);

}
