package dealership.ui;

import dealership.model.Car;
import dealership.service.SelectService;
import dealership.model.User;

import java.util.Scanner;

public class GeneralMenu extends AbstractUi {
    User user;

    public GeneralMenu(User user, Scanner scan) {
        super(scan);
        this.user = user;
    }

    public void showUi() {

        String[] defaultActions = {"view cars on the lot","sign out"};
        String[] customerActions = {"make an offer", "view my cars", "view my payments", "apply for work"};
        String[] employeeActions = {"add car to lot", "remove car from lot", "accept offer", "reject offer", "view all payments", "resign from dealership"};
        String[] systemActions = {"reject all pending offers", "calculate monthly payment", "reset car IDs"};
        SelectService ss = new SelectService();

        int userInputInt = -1;

        System.out.println("\nWelcome, " + user.getUsername() + "!\nYou are a(n) " + user.getUserType() + ". Please select an option from the list below:\n\n");

        do {
            if (user.isLoggedIn() && user.getUserType().equals("customer")) {
                ss.selectFromString(user, scan, TakeUserInput.takeInput(scan, customerActions, defaultActions));
            } else if (user.isLoggedIn() && user.getUserType().equals("employee")) {
                ss.selectFromString(user, scan, TakeUserInput.takeInput(scan, employeeActions, defaultActions));
            } else if (user.getUserType().equals("system")) {
                ss.selectFromString(user, scan, TakeUserInput.takeInput(scan, systemActions, defaultActions));
            }
        } while (user.isLoggedIn());


    }

    public void viewLot(Car[] cars) {
        System.out.println("\nHere are all the cars on the lot:\n");
        System.out.println("ID        Make      Model     Year      Color");
        System.out.println("---------------------------------------------");

        for (Car c : cars) {
            String format = "%-10s%-10s%-10s%-10s%-10s";
            System.out.printf(format, c.getId(), c.getMake(), c.getModel(), c.getYear(), c.getColor() );
            System.out.println("\n");
        }

        System.out.println("\n");

    }

}
