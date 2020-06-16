package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;

import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class ArticlesJDBCDao implements ArticlesDao {
    private final String url = "jdbc:postgresql://localhost:5432/articleservice";
    private final String user = "postgres";
    private final String password = "Tajfun";

    @Override
    public void addArticle(Article article) {
        Connection connection = connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO articles(id, title, content, author, localdate) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, loadArticles().size());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getContent());
            preparedStatement.setString(4, article.getAuthor());
            preparedStatement.setDate(5, Date.valueOf(article.getLocalDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot insert Article");
        }
    }

    @Override
    public void addArticles(ArrayList<Article> articles) {

    }

    @Override
    public List<Article> loadArticles() {
        Connection connection = connect();
        Statement statement;
        List<Article> articles = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM articles");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String author = rs.getString("author");
                Date localDate = rs.getDate("localdate");
                Article article = new Article(id, title, content, author, localDate.toLocalDate());
                articles.add(article);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public Article loadArticleById(int id) {
        Connection connection = connect();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM articles WHERE id=" + id);
            while (rs.next()) {
                String title = rs.getString("title");
                String content = rs.getString("content");
                String author = rs.getString("author");
                Date localDate = rs.getDate("localdate");
                return new Article(id, title, content, author, localDate.toLocalDate());
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new ArticleNotFoundException(id);
    }

    private Connection connect() {
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