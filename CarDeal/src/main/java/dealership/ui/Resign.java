package dealership.ui;

import dealership.model.User;
import dealership.service.UserService;

import java.util.Scanner;

public class Resign extends AbstractUi {
    User user;

    public Resign(User user, Scanner scan) {
        super(scan);
        this.user = user;
    }

    public void showUi() {

        System.out.println("Would you like to tender your resignation with the Dealership? (Y/N)");

        boolean loop = true;
        do {
            String userInput = scan.nextLine();

            if (userInput.equalsIgnoreCase("Y")) {
                System.out.println("You are no longer an employee. Thank you for working with us, and good luck with your future endeavors!");
                user.setUserType("customer");
                loop = false;
            } else if (userInput.equalsIgnoreCase("N")) {
                System.out.println("We are glad that you decided to stay with us!");
                loop = false;
            } else {
                System.out.println("Input not recognized. Please enter either Y for yes or N for no.");
            }
        } while (loop);

        new UserService().updateUser(user.getUsername(), "user_type", user.getUserType());
    }
}
