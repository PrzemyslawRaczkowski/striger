package com.raczkowski.apps.model;

import java.time.LocalDate;

public class Comment {
    private int id;
    private int idOfArticle;
    private String content;
    private String author;
    private LocalDate localDate;

    public Comment(int id, int idOfArticle, String content, String author, LocalDate localDate) {
        this.id = id;
        this.idOfArticle = idOfArticle;
        this.content = content;
        this.author = author;
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public int getIdOfArticle() {
        return idOfArticle;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "Comment{ " +
                " id =" + id +
                ", idOfArticle = " + idOfArticle +
                ", content = " + content +
                ", author = " + author +
                ", localDate = " + localDate +
                '}'+'\n';
    }
}
