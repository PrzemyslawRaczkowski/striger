package com.raczkowski.apps.model;

import java.io.*;
import java.time.LocalDate;

public class Articles extends NotSerializableException {
    private int id;
    private String title;
    private String content;
    private String author;
    private LocalDate localDate;

    public Articles(int id, String title, String content, String author, LocalDate localDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.localDate = localDate;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
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
        return "Article { " +
                "id = " + id +
                ", title = " + title +
                ", content = " + content +
                ", author = " + author +
                ", localDate = " + localDate +
                '}' + '\n';
    }

}
