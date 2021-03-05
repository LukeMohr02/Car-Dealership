package dealership.ui;

import dealership.model.User;

import java.util.Scanner;

public class Apply extends AbstractUi {
    User user;

    public Apply(User user) {
        this.user = user;
    }

    public void showUi(Scanner scan) {

        System.out.println("You have been selected for an interview! Please answer the following interview question:");
        System.out.println("Which came first, the car or the dealership?");
        scan.nextLine();
        System.out.println("That is correct! Congratulations, you are now an employee!");
        user.setUserType("employee");
    }
}
