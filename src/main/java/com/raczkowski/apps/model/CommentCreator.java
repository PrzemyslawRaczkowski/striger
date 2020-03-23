package com.raczkowski.apps.model;

import java.time.LocalDate;
import java.util.Scanner;

public class CommentCreator {
    public Comment create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert content of comment: ");
        String content = scanner.nextLine();
        System.out.println("Insert our first name and last name: ");
        String author = scanner.nextLine();
        return new Comment(0, 0, content, author, LocalDate.now());
    }
}
