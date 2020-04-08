package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class ArticlesJDBCDao implements ArticlesDao {

    private final String url = "jdbc:postgresql://localhost/dvdrental";
    private final String user = "postgres";
    private final String password = "<add your password>";

    @Override
    public void addArticle(Article article)  {
        Connection connection = connect();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String author = article.getAuthor();
            String sql = format("INSERT (%s) INTO articles", author);
            stmt.executeUpdate(sql);
            stmt.close();


            connection.close();
        } catch (SQLException e) {

        }

//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO articles VALUES (?)");
//        preparedStatement.execute(preparedStatement, author);
    }

    @Override
    public void addArticles(ArrayList<Article> articles) {

    }

    @Override
    public List<Article> loadArticles() {
        return Collections.emptyList();
    }

    @Override
    public Article loadArticleById(int id) {
        return null;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
