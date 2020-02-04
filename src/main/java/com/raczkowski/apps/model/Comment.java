package com.raczkowski.apps.model;

import java.time.LocalDate;

public class Comment {
    private int id;
    private int idOfArticle;
    private int idOfUser;
    private String content;
    private String author;
    LocalDate localDate;

    public Comment(int id, int idOfArticle,int idOfUser, String content, String author, LocalDate localDate) {
        this.id = id;
        this.idOfArticle = idOfArticle;
        this.idOfUser=idOfUser;
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

    public int getIdOfUser() {
        return idOfUser;
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
                ", idOfUser = " + idOfUser +
                ", content = " + content +
                ", author = " + author +
                ", localDate = " + localDate +
                '}'+'\n';
    }
}
