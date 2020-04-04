package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.model.Comment;
import com.raczkowski.apps.model.repository.ArticlesCSVRepository;
import com.raczkowski.apps.model.repository.ArticlesRepository;
import com.raczkowski.apps.model.repository.CommentCSVRepository;
import com.raczkowski.apps.model.repository.CommentRepository;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.time.LocalDate;
import java.util.List;

public class TablePrinter {
    public void printArticle(Article article) {
        createTableForArticles(article);
    }

    public void printArticles(List<Article> articles) {
        for (Article article : articles) {
            createTableForArticles(article);
        }
    }

    private void createTableForArticles(Article article) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID: " + article.getId(), "Title: " + article.getTitle())
                .setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow(null, "Content: " + article.getContent());
        table.addRule();
        table.addRow("Author: " + article.getAuthor(), "Date: " + article.getLocalDate())
                .setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.setPadding(1);
        String rend = table.render();
        System.out.println(rend);
    }

    public void printComments(List<Comment> comments) {
        for (Comment comment : comments) {
            createTableForComment(comment);
        }
    }

    public void printComment(Comment comment) {
        createTableForComment(comment);
    }

    private void createTableForComment(Comment comment) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID: " + comment.getId(), "Content: " + comment.getContent());
        table.addRule();
        table.addRow("Author:" + comment.getAuthor(), "Date: " + comment.getLocalDate());
        table.addRule();
        table.setPadding(1);
        String rend = table.render();
        System.out.println(rend);
    }
}
