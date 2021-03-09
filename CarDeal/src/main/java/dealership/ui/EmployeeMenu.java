package dealership.ui;

import dealership.model.Car;
import dealership.model.Offer;
import dealership.model.Payment;
import dealership.service.GeneralService;

import java.util.Scanner;

public class EmployeeMenu {
    Scanner scan;

    public EmployeeMenu(Scanner scan) {
        this.scan = scan;
    }

    public Car addCarUi() {
        Car car = new Car();

        System.out.println("Enter car make: ");
        car.setMake(scan.nextLine());
        System.out.println("Enter car model: ");
        car.setModel(scan.nextLine());
        System.out.println("Enter car year: ");
        car.setYear(scan.nextInt());
        scan.nextLine();
        System.out.println("Enter car color: ");
        car.setColor(scan.nextLine());
        car.setOwner(null);

        return car;
    }

    public int removeCarUi() {
        System.out.println("Please enter the ID of the car you would like to remove:");

        //TODO: validate input
        int userInput = scan.nextInt();

        System.out.println("Removing ID " + userInput + " from the lot...\n");

        return userInput;
    }

    public void viewOffersUi(Offer[] offers) {
        System.out.println("\nHere are all pending offers:\n");
        System.out.println("Customer  Car ID    Offer amount");
        System.out.println("--------------------------------");

        for (Offer o : offers) {
            String format = "%-10s%-10s%-10s";
            System.out.printf(format, o.getUserId(), o.getCarId(), o.getAmount());
            System.out.println("\n");
        }

        System.out.println("\n");
    }

    public String[] acceptOfferUi() {
        System.out.println("Please enter the customer name and car ID of the offer you would like to accept:");

        //TODO: validate input
        String[] strings = {scan.next(), scan.next()};
        System.out.println("Accepting offer. Please contact your System Administrator to cancel all pending offers for this car.");
        return strings;
    }

    public String[] rejectOfferUi() {
        System.out.println("Please enter the customer name and car ID of the offer you would like to rejec:");

        //TODO: validate input
        String[] strings = {scan.next(), scan.next()};
        System.out.println("Rejecting offer...");
        return strings;
    }

    public void viewAllPaymentsUi(Payment[] payments) {
        System.out.println("\nHere are all of the remaining payments:\n");
        System.out.println("User ID   Car ID    Payment amount");
        System.out.println("----------------------------------");

        for (Payment p : payments) {
            String format = "%-10s%-10s%-10s";
            System.out.printf(format, p.getUserId(), p.getCarId(), p.getAmount());
            System.out.println("\n");
        }

        System.out.println("\n");
    }
}
