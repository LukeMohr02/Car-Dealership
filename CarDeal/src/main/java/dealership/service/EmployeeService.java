package dealership.service;

import dealership.model.User;

import java.util.Scanner;

public class EmployeeService extends GeneralService {

    EmployeeService(User user, Scanner scan) {
        if (user.getUserType().equals("employee")) {
            this.user = user;
        } else {
            this.user = null;
        }

        this.scan = scan;
    }

    public void addCar() {
    }

    public void removeCar() {
    }

    public void acceptOffer() {
    }

    public void rejectOffer() {
    }

    public void viewALlPayments() {
    }

    public void resign() {
    }
}
