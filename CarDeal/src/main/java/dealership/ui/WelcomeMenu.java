package dealership.ui;

import dealership.service.UserService;

import java.util.Scanner;

public class WelcomeMenu extends AbstractUi {

    public WelcomeMenu(Scanner scan) {
        super(scan);
    }

    public void showUi() {

        System.out.println("~~~~~~~~~~ Welcome to the Dealership! ~~~~~~~~~~");

        System.out.println("sign up, login, or exit?");

        String userInput = scan.nextLine();

        if (userInput.equals("sign up")) {
            SignUp ui = new SignUp(scan);
            ui.showUi();
        } else if (userInput.equals("login")) {
            Login ui = new Login(scan);
            ui.showUi();
        }

        System.out.println("Leaving the Dealership. Have a nice day!");
        System.exit(0);

    }
}
