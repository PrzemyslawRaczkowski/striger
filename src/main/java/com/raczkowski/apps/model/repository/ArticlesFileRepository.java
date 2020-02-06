package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticlesFileRepository implements ArticlesRepository {
    final private File file = new File("Articles.csv");

    @Override
    public void addArticle(Article article) {

    }

    @Override
    public void addArticles(List<Article> articles) {

    }

    @Override
    public void loadArticles() {

    }

    @Override
    public void loadArticleById(int id) {

    }

    private ArrayList<Article> articlesReader() {
        ArrayList<Article> listOfReadArticles = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Article article = createArticle(attributes);
                listOfReadArticles.add(article);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfReadArticles;
    }

    private static Article createArticle(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String title = metadata[1];
        String content = metadata[2];
        String author = metadata[3];
        LocalDate localDate = LocalDate.parse(metadata[4]);
        return new Article(id, title, content, author, localDate);
    }


    private void articlesWriter(ArrayList<Article> articlesList) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (Article articles : articlesList) {
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
