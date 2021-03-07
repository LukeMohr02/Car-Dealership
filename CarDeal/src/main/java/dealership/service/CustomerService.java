package dealership.service;

import dealership.model.User;
import dealership.ui.Apply;

import java.util.Scanner;

public class CustomerService extends GeneralService {

    CustomerService(User user, Scanner scan) {
        super();
        if (user.getUserType().equals("customer")) {
            this.user = user;
        } else {
            this.user = null;
        }

        this.scan = scan;
    }

    public void viewLot() {
    }

    public void viewCars() {
    }

    public void viewPayments() {
    }

    public void apply() {
        Apply ui = new Apply(user, scan);
        ui.showUi();
    }

}
