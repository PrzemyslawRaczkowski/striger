package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.model.Comment;

import java.util.List;

public interface CommentDao {

    void addComment(Comment comment, Article article);

    List<Comment> showComment();

    List<Comment> commentsOfArticles(Article article);
}
