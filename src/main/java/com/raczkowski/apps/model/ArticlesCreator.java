package com.raczkowski.apps.model;

import java.time.LocalDate;
import java.util.Scanner;

public class ArticlesCreator {

    public Article create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tworzenie nowego artukułu");
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj treść: ");
        String content = scanner.nextLine();
        System.out.println("Podaj swoje Imię i Nazwisko: ");
        String author = scanner.nextLine();

        return new Article(0, title, content, author, LocalDate.now());
    }
}
