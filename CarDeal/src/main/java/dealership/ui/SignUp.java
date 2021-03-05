package dealership.ui;

import dealership.service.UserService;
import dealership.model.User;

import java.util.Scanner;

public class SignUp extends AbstractUi {

    public void showUi(Scanner scan) {
        String username;
        String password;

        boolean unExists = true;

        do {
            System.out.println("Username: ");
            username = scan.nextLine();

            if (username != null && !UserService.usernameExists(username)) {
                System.out.println("Password: ");
                password = scan.nextLine();

                UserService us = new UserService();
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

                GeneralMenu gm = new GeneralMenu(user);
                gm.showUi(scan);

            } else {
                System.out.println("Sign up failed, username already exists!");
            }

        } while (unExists);

    }
}
