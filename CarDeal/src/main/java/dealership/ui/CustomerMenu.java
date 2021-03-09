package dealership.ui;

import dealership.model.Car;
import dealership.model.Offer;
import dealership.model.Payment;
import dealership.model.User;
import dealership.service.GeneralService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerMenu {
    User user;
    Scanner scan;

    public CustomerMenu(User user, Scanner scan) {
        this.user = user;
        this.scan = scan;
    }

    public Offer makeOfferUi() {
        Offer offer = new Offer();

        offer.setUserId(user.getUsername());

        System.out.println("Please enter the ID of the car you would like to make an offer on:");

        InputMismatchException ime = null;
        int userInput = -1;
        do {
            try {
                ime = null;
                offer.setCarId(scan.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Input not recognized. Please enter the car ID as shown.");
                ime = e;
                scan.next();
            }
        } while (ime != null);

        System.out.println("Please enter the offer amount:");

        ime = null;
        userInput = -1;
        do {
            try {
                ime = null;
                offer.setAmount(scan.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Input not recognized. Please enter the offer amount as a decimal number.");
                ime = e;
                scan.next();
            }
        } while (ime != null);

        System.out.println("Your offer has been processed!\n");

        return offer;

    }

    public void viewCarsUi(Car[] cars, String username) {
        System.out.println("\nHere are the cars that you own:\n");
        System.out.println("ID        Make      Model     Year      Color");
        System.out.println("---------------------------------------------");

        for (Car c : cars) {
            if (c.getOwner() != null && c.getOwner().getUsername().equals(username)) {
                String format = "%-10s%-10s%-10s%-10s%-10s";
                System.out.printf(format, c.getId(), c.getMake(), c.getModel(), c.getYear(), c.getColor());
                System.out.println("\n");
            }
        }

        System.out.println("\n");
    }

    public void viewPaymentsUi(Payment[] payments, String username) {
        System.out.println("\nHere are your remaining payments:\n");
        System.out.println("Car ID    Payment amount");
        System.out.println("------------------------");

        for (Payment p : payments) {
            if (p.getUserId().equals(username)) {
                String format = "%-10s%-10s";
                System.out.printf(format, p.getCarId(), p.getAmount());
                System.out.println("\n");
            }
        }

        System.out.println("\n");
    }
}

