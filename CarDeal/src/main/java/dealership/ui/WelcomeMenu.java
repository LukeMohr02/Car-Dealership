package dealership.ui;

import dealership.service.UserService;

import java.util.Scanner;

public class WelcomeMenu extends AbstractUi {

    public void showUi(Scanner scan) {

        System.out.println("~~~~~~~~~~ Welcome to the Dealership! ~~~~~~~~~~");

        System.out.println("sign up, login, or exit?");

        String userInput = scan.nextLine();

        if (userInput.equals("sign up")) {
            SignUp ui = new SignUp();
            ui.showUi(scan);
        } else if (userInput.equals("login")) {
            Login ui = new Login();
            ui.showUi(scan);
        }

        System.out.println("Leaving the Dealership. Have a nice day!");
        System.exit(0);

    }
}
