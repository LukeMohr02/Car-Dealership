package dealership.service;

import dealership.model.Car;
import dealership.model.Payment;
import dealership.model.User;
import dealership.ui.Apply;
import dealership.ui.CustomerMenu;

import java.util.Scanner;

// Customer-specific service methods
class CustomerService extends GeneralService {
    CustomerMenu cm;

    CustomerService(User user, Scanner scan) {
        super();
        if (user.getUserType().equals("customer")) {
            this.user = user;
        } else {
            this.user = null;
        }

        this.scan = scan;
        cm = new CustomerMenu(user, scan);
    }

    public void makeOffer() {
        viewLot();
        offerDAO.insert(cm.makeOfferUi());
    }

    public void viewCars() {
        cm.viewCarsUi((Car[]) carDAO.getAll(), user.getUsername());
    }

    public void viewPayments() {
        cm.viewPaymentsUi((Payment[]) paymentDAO.getAll(), user.getUsername());
    }

    public void apply() {
        Apply ui = new Apply(user, scan);
        ui.showUi();
    }
}
