package com.raczkowski.apps.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CommentDataController {
    final private File file = new File("Comments.csv");

    public ArrayList<Comment> commentReader() {
        ArrayList<Comment> listOfReadComments = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Comments.csv"));
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
        int idOfUser = Integer.parseInt(metadata[2]);
        String content = metadata[3];
        String author = metadata[4];
        LocalDate localDate = LocalDate.parse(metadata[5]);
        return new Comment(id, idOfArticle, idOfUser, content, author, localDate);
    }

    public void commentWriter(ArrayList<Comment> commentsList) {
        try {
            final String CSV_SEPARATOR = ",";
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (Comment comment : commentsList) {
                String line = (comment.getId() +
                        CSV_SEPARATOR +
                        comment.getIdOfArticle() +
                        CSV_SEPARATOR +
                        comment.getIdOfUser() +
                        CSV_SEPARATOR +
                        comment.getContent() +
                        CSV_SEPARATOR +
                        comment.getAuthor() +
                        CSV_SEPARATOR +
                        comment.getLocalDate());
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
