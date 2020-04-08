package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.model.Comment;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CommentCSVDao implements CommentDao {
    private final File file;

    public CommentCSVDao(String filename) {
        this.file = new File(filename);
    }

    @Override
    public void addComment(Comment comment, Article article) {
        addingSingleComment(comment, article);
    }

    @Override
    public List<Comment> showComment() {
        return commentReader();
    }

    @Override
    public List<Comment> commentsOfArticles(Article article) {
        return commentsOfArticle(article);
    }

    private List<Comment> commentsOfArticle(Article article) {
        List<Comment> lsitOfComments = new ArrayList<>();

        for (int i = 0; i < commentReader().size(); i++) {
            if (commentReader().get(i).getIdOfArticle() == article.getId()) {
                lsitOfComments.add(commentReader().get(i));
            }
        }
        return lsitOfComments;
    }

    private void addingSingleComment(Comment comment, Article article) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String CSV_SEPARATOR = ",";
            String oneLine = (commentReader().size() +
                    CSV_SEPARATOR +
                    article.getId() +
                    CSV_SEPARATOR +
                    comment.getContent() +
                    CSV_SEPARATOR +
                    comment.getAuthor() +
                    CSV_SEPARATOR +
                    comment.getLocalDate());
            bw.write(oneLine);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private ArrayList<Comment> commentReader() {
        ArrayList<Comment> listOfReadComments = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Comment comment = createComment(attributes);
                listOfReadComments.add(comment);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfReadComments;
    }

    private static Comment createComment(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        int idOfArticle = Integer.parseInt(metadata[1]);
        String content = metadata[2];
        String author = metadata[3];
        LocalDate localDate = LocalDate.parse(metadata[4]);
        return new Comment(id, idOfArticle, content, author, localDate);
    }

}


