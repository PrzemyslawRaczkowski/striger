package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.ArticlesFileRepository;

import java.time.LocalDate;
import java.util.ArrayList;
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
            if (articlesRepository.loadArticles().get(i).getAuthor().equals(author)) {
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

    public ArrayList<Article> articlesFromRange(String choice1, String choice2) {
        ArrayList<Article> articlesFrom = new ArrayList<>();
        for (int i = 0; i < articlesRepository.loadArticles().size(); i++) {
            if (articlesRepository.loadArticles().get(i).getLocalDate().getMonth().getValue() >= Integer.parseInt(choice1)
                    && articlesRepository.loadArticles().get(i).getLocalDate().getMonth().getValue() <= Integer.parseInt(choice2)) {
                articlesFrom.add(articlesRepository.loadArticles().get(i));
            }
        }
        return articlesFrom;
    }
}
