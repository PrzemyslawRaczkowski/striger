package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.*;
import com.raczkowski.apps.view.View;

import java.util.Scanner;

import static java.lang.System.in;

public class RegistrationController implements Controller {
    private final RootController rootController;
    private final View menu;
    private final LogIn logIn;
    private final Registration registration;


    public RegistrationController(RootController rootController,
                                  View menu,
                                  LogIn logIn,
                                  Registration registration) {
        this.rootController = rootController;
        this.menu = menu;
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
                    User user = logIn.logIn(getUserDataForLogin());
                    if (user != null) {
                        rootController.handle();
                    }
                    break;
                case "2":
                    registration.register(getUserDataForRegistration());
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

    private UserLoginData getUserDataForLogin() {
        System.out.println("Log in:");
        System.out.println("E-mail: ");
        String email = new Scanner(in).nextLine();
        System.out.println("Password:");
        String password = new Scanner(in).nextLine();

        return new UserLoginData(email, password);
    }

    private UserRegistrationData getUserDataForRegistration() {
        System.out.println("Registration:");
        System.out.println("Type first name:");
        String name = new Scanner(in).nextLine();
        System.out.println("Type last name:");
        String lastName = new Scanner(in).nextLine();
        System.out.println("Type your e-mail address:");
        String email = new Scanner(in).nextLine();
        System.out.println("Type your password:");
        String password = new Scanner(in).nextLine();

        return new UserRegistrationData(name, lastName, email, password);
    }
}
