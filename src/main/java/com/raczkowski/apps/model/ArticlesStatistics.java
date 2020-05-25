package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.ArticlesDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;
import static java.util.stream.Collectors.toList;

public class ArticlesStatistics {
    private ArticlesDao articlesDao;

    public ArticlesStatistics(ArticlesDao articlesDao) {
        this.articlesDao = articlesDao;
    }

    public List<Article> articlesFromToday() {
        return getArticlesForPredicate(article -> article.getLocalDate().equals(now()));
    }

    public List<Article> articlesOfAuthor(String author) {
        return getArticlesForPredicate(article -> article.getAuthor().equalsIgnoreCase(author));
    }

    public List<Article> articlesFromRange(DataRange dataRange) {
        getArticlesForPredicate(new Predicate<Article>() {
            @Override
            public boolean test(Article article) {
                return article.getLocalDate().isAfter(dataRange.getStartRangeTime();
            }
        });

        return getArticlesForPredicate(article -> article.getLocalDate().isAfter(dataRange.getStartRangeTime())
                && article.getLocalDate().isBefore(dataRange.getEndRangeTime()));
    }

    private List<Article> getArticlesForPredicate(Predicate<Article> predicate) {
        List<Article> articles = new ArrayList<>();
        for (Article article : articlesDao.loadArticles()) {
            if (predicate.test(article)) {
                articles.add(article);
            }
        }
        return articles;
    }

    public List<Article> articlesOfLongestContext() {
        List<Article> articles = new ArrayList<>();
        int counter = articlesDao.loadArticles().get(0).getContent().length();
        for (Article article : articlesDao.loadArticles()) {
            if (article.getContent().length() >= counter) {
                articles.add(0, article);
                counter = article.getContent().length();
            }
        }
        return articles;
    }

    public List<Article> articlesFilter(String choice) {
        List<Article> articlesSorted = new ArrayList<>(articlesDao.loadArticles());
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

    private List<Article> sortedArticles() {
        List<Article> articles = articlesDao.loadArticles();

        List<String> authors = articles.stream()
                .map(article -> article.getAuthor())
                .collect(toList());

        List<Article> articles2 = articles.stream()
                .filter(article -> article.getAuthor().startsWith("B"))
                .collect(toList());


        long numberOfAuthors = articles.stream()
                .filter(article -> article.getAuthor().startsWith("B"))
                .count();


        int sum = articles.stream()
                .map(Article::getId)
                .reduce(0, Integer::sum);

        boolean result = articles.stream()
                .filter(article -> article.getAuthor().equals("Siwy z bagien"))
                .allMatch(article -> article.getLocalDate().getYear() >= 2000);

        Map<String, List<Article>> collect = articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));

    }

    interface Dupa {
        void dupa();
    }

    private void function(Dupa dupa) {
        dupa.dupa();
    }
}
