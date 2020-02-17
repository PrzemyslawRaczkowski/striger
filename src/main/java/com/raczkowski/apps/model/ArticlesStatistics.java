package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.ArticlesFileRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticlesStatistics {

    private ArticlesFileRepository articlesRepository = new ArticlesFileRepository();

    public ArrayList<Article> articlesFromToday() {
        ArrayList<Article> articles = new ArrayList<>();
        for (int i = 0; i < articlesRepository.loadArticles().size(); i++) {
            if (articlesRepository.loadArticles().get(i).getLocalDate().equals(LocalDate.now())) {
                articles.add(articlesRepository.loadArticles().get(i));
            }
        }
        return articles;
    }

    public ArrayList<Article> articlesOfAuthor(String author) {
        ArrayList<Article> articlesOfAuthor = new ArrayList<>();
        for (int i = 0; i < articlesRepository.loadArticles().size(); i++) {
            if (articlesRepository.loadArticles().get(i).getAuthor().equalsIgnoreCase(author)) {
                articlesOfAuthor.add(articlesRepository.loadArticles().get(i));
            }
        }
        return articlesOfAuthor;
    }

    public ArrayList<Article> articlesOfLongestContext() {
        ArrayList<Article> longestArticles = new ArrayList<>();
        int counter = articlesRepository.loadArticles().get(0).getContent().length();
        for (int i = 0; i < articlesRepository.loadArticles().size(); i++) {
            if (articlesRepository.loadArticles().get(i).getContent().length() > counter) {
                longestArticles.add(0, articlesRepository.loadArticles().get(i));
                counter = articlesRepository.loadArticles().get(i).getContent().length();
            }
        }
        return longestArticles;
    }

    public ArrayList<Article> articlesFromRange(List<Integer> choice) {
        ArrayList<Article> articlesFrom = new ArrayList<>();
        for (int i = 0; i < articlesRepository.loadArticles().size(); i++) {
            if (articlesRepository.loadArticles().get(i).getLocalDate().getMonth().getValue() >= (choice.get(0))
                    && articlesRepository.loadArticles().get(i).getLocalDate().getMonth().getValue() <= (choice.get(1))) {
                articlesFrom.add(articlesRepository.loadArticles().get(i));
            }
        }
        return articlesFrom;
    }

    public List<Article> articlesFiler(String choice) {
        ArrayList<Article> articlesSorted = new ArrayList<>(articlesRepository.loadArticles());
        Article temporaryArticle;
        if (articlesSorted.size() > 1) {
            if (choice.equals("1")) {
                for (int i = 0; i < articlesSorted.size(); i++) {
                    for (int j = 0; j < articlesSorted.size() - 1; j++) {
                        if (articlesSorted.get(j).getLocalDate().
                                isAfter(articlesSorted.get(j + 1).getLocalDate())) {
                            temporaryArticle = articlesSorted.get(j);
                            articlesSorted.set(j, articlesSorted.get(j + 1));
                            articlesSorted.set(j + 1, temporaryArticle);
                        }
                    }
                }
            } else if (choice.equals("2")) {
                for (int i = 0; i < articlesSorted.size(); i++) {
                    for (int j = 0; j < articlesSorted.size() - 1; j++) {
                        if (articlesSorted.get(j).getLocalDate().
                                isBefore(articlesSorted.get(j + 1).getLocalDate())) {
                            temporaryArticle = articlesSorted.get(j);
                            articlesSorted.set(j, articlesSorted.get(j + 1));
                            articlesSorted.set(j + 1, temporaryArticle);
                        }
                    }
                }
            }
        }
        return articlesSorted;
    }
}
