package com.raczkowski.apps.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ArticlesCreator {
    public ArrayList<Articles> articlesCreator() {
        ArticlesDataController artliclesControler = new ArticlesDataController();
        ArrayList<Articles> article = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tworzenie nowego artukułu");
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj treść: ");
        String content = scanner.nextLine();
        System.out.println("Podaj swoje Imię i Nazwisko: ");
        String author = scanner.nextLine();
        Articles articles = new Articles(artliclesControler.articlesReader().size(), title, content, author, LocalDate.now());
        article.add(articles);

        return article;
    }
}
