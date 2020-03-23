package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.ArticlesCSVRepository;
import com.raczkowski.apps.model.repository.ArticlesRepository;
import com.raczkowski.apps.model.repository.CommentCSVRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.time.LocalDate.now;

public class ArticlesStatistics {
    private ArticlesRepository articlesRepository;

    public ArticlesStatistics(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public List<Article> articlesFromToday() {
        return getArticlesForPredicate(article -> article.getLocalDate().equals(now()));
    }

    public List<Article> articlesOfAuthor(String author) {
        return getArticlesForPredicate(article -> article.getAuthor().equalsIgnoreCase(author));
    }

    //    TODO: zrobić na datach
    public List<Article> articlesFromRange(List<Integer> choice) {
        return getArticlesForPredicate(article -> article.getLocalDate().getMonth().getValue() >= choice.get(0)
                && article.getLocalDate().getMonth().getValue() <= choice.get(1));
    }

    private List<Article> getArticlesForPredicate(Predicate<Article> predicate) {
        List<Article> articles = new ArrayList<>();
        for (Article article : articlesRepository.loadArticles()) {
            if (predicate.test(article)) {
                articles.add(article);
            }
        }

        return articles;
    }

    public List<Article> articlesOfLongestContext() {
        List<Article> articles = new ArrayList<>();
        int counter = articlesRepository.loadArticles().get(0).getContent().length();
        for (Article article : articlesRepository.loadArticles()) {
            if (article.getContent().length() >= counter) {
                articles.add(0, article);
                counter = article.getContent().length();
            }
        }
        return articles;
    }

    public List<Article> articlesFilter(String choice) {
        List<Article> articlesSorted = new ArrayList<>(articlesRepository.loadArticles());
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
