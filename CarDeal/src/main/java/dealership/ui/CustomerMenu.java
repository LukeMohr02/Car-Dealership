package dealership.ui;

import dealership.model.Car;
import dealership.model.Offer;
import dealership.model.User;
import dealership.service.GeneralService;

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

        //TODO: validate input
        offer.setCarId(scan.nextInt());

        System.out.println("Please enter the offer amount:");

        //TODO: validate input
        offer.setAmount(scan.nextInt());

        return offer;

    }
}
