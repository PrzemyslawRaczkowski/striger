package com.raczkowski.apps.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArticlesDataController {
    public ArrayList<Articles> dataReader() {
        ArrayList<Articles> listOfReadedArticles = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Articles.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Articles article = createArticle(attributes);
                listOfReadedArticles.add(article);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfReadedArticles;
    }

    private static Articles createArticle(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String title = metadata[1];
        String content = metadata[2];
        String author = metadata[3];
        LocalDate localDate = LocalDate.parse(metadata[4]);
        return new Articles(id, title, content, author, localDate);
    }


    public void dataWriter(ArrayList<Articles> articlesList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Articles.csv"), "UTF-8"));
            for (Articles articles : articlesList) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(articles.getId());
                String CSV_SEPARATOR = ",";
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(articles.getTitle());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(articles.getContent());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(articles.getAuthor());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(articles.getLocalDate());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ignored) {
        }
    }
}
