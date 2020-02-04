package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Comment;
import com.raczkowski.apps.model.CommentDataController;

import java.time.LocalDate;
import java.util.ArrayList;

public class CommentsController implements Controller {
    @Override
    public void handle() {
        ArrayList<Comment> commentsList=new ArrayList<>();
        Comment comment= new Comment(1,1,1,"Comment 1","Author 1", LocalDate.now());
        Comment comment1= new Comment(2,2,2,"Comment 2","Author 2", LocalDate.now());
        commentsList.add(comment);
        commentsList.add(comment1);
        CommentDataController commentDataController=new CommentDataController();
        //commentDataController.commentWriter(commentsList);
        System.out.println(commentDataController.commentReader());
    }
}
