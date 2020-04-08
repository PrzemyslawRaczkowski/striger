package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.*;
import com.raczkowski.apps.view.View;

import java.util.Scanner;

import static java.lang.System.in;

public class RegistrationController implements Controller {
    private final RootController rootController;
    private final View menu;
    private final TemporaryUser temporaryUser;
    private final LogIn logIn;
    private final Registration registration;

    public RegistrationController(RootController rootController
            , View menu
            , TemporaryUser temporaryUser
            , LogIn logIn
            , Registration registration) {
        this.rootController = rootController;
        this.menu = menu;
        this.temporaryUser = temporaryUser;
        this.logIn = logIn;
        this.registration = registration;
    }

    @Override
    public void handle() {
        boolean run = true;

        while (run) {
            menu.view();
            String userChoice = handleInput();
            switch (userChoice) {
                case "1":
                    logIn();
                    if (logIn.logIn(temporaryUser)) rootController.handle();
                    break;
                case "2":
                    registration();
                    if (registration.registration(temporaryUser)) {
                        if (logIn.logIn(temporaryUser)) rootController.handle();
                    }
                    break;
                case "Q":
                    run = false;
                    System.out.println("Bye, Bye!");
                    break;
                default:
                    System.out.println("Unknown command, please try again");
            }
        }

    }

    private String handleInput() {
        System.out.print("Your choice: ");
        return new Scanner(in).next();
    }

    private void logIn() {
        System.out.println("Log in:");
        System.out.println("E-mail: ");
        temporaryUser.seteMail(new Scanner(in).nextLine());
        System.out.println("Password:");
        temporaryUser.setPassword(new Scanner(in).nextLine());
    }

    private void registration() {
        System.out.println("Registration:");
        System.out.println("Type first name:");
        temporaryUser.setName(new Scanner(in).nextLine());
        System.out.println("Type last name:");
        temporaryUser.setLastName(new Scanner(in).nextLine());
        System.out.println("Type your e-mail address:");
        temporaryUser.seteMail(new Scanner(in).nextLine());
        System.out.println("Type your password:");
        temporaryUser.setPassword(new Scanner(in).nextLine());
    }
}
