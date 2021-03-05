package dealership.ui;

import dealership.service.SelectService;
import dealership.model.User;

import java.util.Scanner;

public class GeneralMenu extends AbstractUi {
    User user;

    public GeneralMenu(User user) {
        this.user = user;
    }

    public void showUi(Scanner scan) {

        //TODO: maybe set these strings from config file?
        String[] defaultActions = {"sign out"};
        String[] customerActions = {"make an offer", "view my cars", "view my payments", "apply for work"};
        String[] employeeActions = {"add car to lot", "remove car from lot", "accept offer", "reject offer", "view all payments", "resign from dealership"};
        String[] systemActions = {"remove all cars from lot", "reject all pending offers", "calculate monthly payment"};
        SelectService ss = new SelectService();

        int userInputInt = -1;

        System.out.println("Welcome, " + user.getUsername() + "!\nYou are a customer. Please select an option from the list below:\n\n");

        do {
            if (user.isLoggedIn() && user.getUserType().equals("customer")) {
                ss.selectFromString(user, TakeUserInput.takeInput(scan, customerActions, defaultActions));
            } else if (user.isLoggedIn() && user.getUserType().equals("employee")) {
                ss.selectFromString(user, TakeUserInput.takeInput(scan, employeeActions, defaultActions));
            } else if (user.getUserType().equals("system")) {
                ss.selectFromString(user, TakeUserInput.takeInput(scan, systemActions, defaultActions));
            }
        } while (user.isLoggedIn());


    }

}
