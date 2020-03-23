package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArticlesFileRepository implements ArticlesRepository {
    final private File file = new File("Articles.csv");
    final private String CSV_SEPARATOR = ",";

    @Override
    public void addArticle(Article article) {
        addSingleArticle(article);
    }

    @Override
    public void addArticles(ArrayList<Article> articles) {
        articlesWriter(articles);
    }

    @Override
    public ArrayList<Article> loadArticles() {
        return articlesReader();
    }

    @Override
    public Article loadArticleById(int id) {
        return articlesReader().get(id - 1);
    }

    private void addSingleArticle(Article article) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String oneLine = (articlesReader().size() +
                    CSV_SEPARATOR +
                    article.getTitle() +
                    CSV_SEPARATOR +
                    article.getContent() +
                    CSV_SEPARATOR +
                    article.getAuthor() +
                    CSV_SEPARATOR +
                    article.getLocalDate());
            bw.write(oneLine);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
