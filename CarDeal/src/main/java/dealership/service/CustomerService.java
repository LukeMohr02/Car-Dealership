package dealership.service;

import dealership.model.User;
import dealership.ui.Apply;

public class CustomerService extends GeneralService {

    CustomerService(User user) {
        if (user.getUserType().equals("customer")) {
            this.user = user;
        } else {
            this.user = null;
        }

    }
    public void viewLot() {
    }

    public void viewCars() {
    }

    public void viewPayments() {
    }

    public void apply() {
        Apply ui = new Apply(user);
    }

}
