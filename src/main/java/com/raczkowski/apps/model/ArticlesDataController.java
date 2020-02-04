package com.raczkowski.apps.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArticlesDataController {
    final private File file = new File("Articles.csv");

    public ArrayList<Articles> articlesReader() {
        ArrayList<Articles> listOfReadArticles = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Articles article = createArticle(attributes);
                listOfReadArticles.add(article);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfReadArticles;
    }

    private static Articles createArticle(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String title = metadata[1];
        String content = metadata[2];
        String author = metadata[3];
        LocalDate localDate = LocalDate.parse(metadata[4]);
        return new Articles(id, title, content, author, localDate);
    }


    public void articlesWriter(ArrayList<Articles> articlesList) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (Articles articles : articlesList) {
                String CSV_SEPARATOR = ",";
                String oneLine = (articles.getId() +
                        CSV_SEPARATOR +
                        articles.getTitle() +
                        CSV_SEPARATOR +
                        articles.getContent() +
                        CSV_SEPARATOR +
                        articles.getAuthor() +
                        CSV_SEPARATOR +
                        articles.getLocalDate());
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
