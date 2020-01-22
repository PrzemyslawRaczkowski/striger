package com.raczkowski.apps.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CommentDataController {
    public ArrayList<Comment> commentReader() {
        ArrayList<Comment> listOfReadedComments = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Comments.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Comment comment = createComment(attributes);
                listOfReadedComments.add(comment);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfReadedComments;
    }

    private static Comment createComment(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        int idOfArticle = Integer.parseInt(metadata[1]);
        int idOfUser=Integer.parseInt(metadata[2]);
        String content = metadata[3];
        String author = metadata[4];
        LocalDate localDate = LocalDate.parse(metadata[5]);
        return new Comment(id, idOfArticle,idOfUser, content, author, localDate);
    }
    public void commmentWriter(ArrayList<Comment> commentsList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Comments.csv"), "UTF-8"));
            for (Comment comment : commentsList) {
                StringBuffer line = new StringBuffer();
                line.append(comment.getId());
                String CSV_SEPARATOR = ",";
                line.append(CSV_SEPARATOR);
                line.append(comment.getIdOfArticle());
                line.append(CSV_SEPARATOR);
                line.append(comment.getIdOfUser());
                line.append(CSV_SEPARATOR);
                line.append(comment.getContent());
                line.append(CSV_SEPARATOR);
                line.append(comment.getAuthor());
                line.append(CSV_SEPARATOR);
                line.append(comment.getLocalDate());
                bw.write(line.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ignored) {
        }
    }
}
