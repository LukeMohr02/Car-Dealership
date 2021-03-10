package dealership.ui;

import java.util.Scanner;

import dealership.model.User;
import dealership.service.UserService;

public class Login extends AbstractUi {
    private int loginAttempts = 3;
    private boolean loginSuccessful = false;

    public Login(Scanner scan) {
        super(scan);
    }

    public void showUi() {
        String username;
        String password;
        UserService us = new UserService();
        User user = null;

        do {
            System.out.println("Username:");
            username = scan.nextLine();
            System.out.println("Password:");
            password = scan.nextLine();

            // Prompts user for existing username and password
            try {
                if (us.usernameExists(username) && us.getUser(username).getPassword().equals(password)) {
                    user = us.getUser(username);
                    user.setLoggedIn(true);
                    System.out.println("Login successful!");
                    loginSuccessful = true;
                } else {
                    loginAttempts--;
                    System.out.println("Login failed, username or password is incorrect!");
                    System.out.println("Login attempts remaining: " + loginAttempts);
                }
            } catch (NullPointerException e) {
                loginAttempts--;
                System.out.println("Login failed, username or password is incorrect!");
                System.out.println("Login attempts remaining: " + loginAttempts);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } while (!loginSuccessful && loginAttempts > 0);

        if (user != null) {

            // Moves to GeneralMenu
            GeneralMenu gm = new GeneralMenu(user, scan);
            gm.showUi();
        }
    }
}
