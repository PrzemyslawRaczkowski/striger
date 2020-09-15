package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.UsersDao;

import java.time.LocalDate;
import java.util.Scanner;

public class ArticlesCreator {
    private final UsersDao usersDao;
    private final UserLoginData userLoginData;

    public ArticlesCreator(UsersDao usersDao, UserLoginData userLoginData) {
        this.usersDao = usersDao;
        this.userLoginData = userLoginData;
    }


    public Article create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tworzenie nowego artukułu");
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj treść: ");
        String content = scanner.nextLine();
        String author = usersDao.selectDataOfUser(userLoginData).getName()
                + " " + usersDao.selectDataOfUser(userLoginData).getSurname();
        return new Article(0, title, content, author, LocalDate.now());
    }
}