package com.raczkowski.apps.model.repository;

import static java.lang.String.format;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(int id) {
        super(format("Article not found for given id: %s", id));
    }
}
