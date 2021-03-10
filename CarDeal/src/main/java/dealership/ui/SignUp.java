package dealership.ui;

import dealership.service.UserService;
import dealership.model.User;

import java.util.Scanner;

public class SignUp extends AbstractUi {

    public SignUp(Scanner scan) {
        super(scan);
    }

    public void showUi() {
        String username;
        String password;
        UserService us = new UserService();

        boolean unExists = true;

        // Prompts user for valid username and password
        do {
            System.out.println("Username: ");
            username = scan.nextLine();

            if (username != null && !us.usernameExists(username)) {
                System.out.println("Password: ");
                password = scan.nextLine();

                User user = null;

                try {
                    user = us.createUser(username, password, "customer");
                    us.addUser(user);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                System.out.println("Account successfully created!");
                user.setLoggedIn(true);
                unExists = false;

                // Moves to GeneralMenu
                GeneralMenu gm = new GeneralMenu(user, scan);
                gm.showUi();

            } else {
                System.out.println("Sign up failed, username already exists!");
            }

        } while (unExists);

    }
}
