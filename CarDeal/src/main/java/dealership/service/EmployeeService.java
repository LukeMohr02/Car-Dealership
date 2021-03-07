package dealership.service;

import dealership.model.Car;
import dealership.model.User;
import dealership.ui.EmployeeMenu;

import java.util.Scanner;

public class EmployeeService extends GeneralService {
    EmployeeMenu eMenu = new EmployeeMenu(scan);

    EmployeeService(User user, Scanner scan) {
        if (user.getUserType().equals("employee")) {
            this.user = user;
        } else {
            this.user = null;
        }

        this.scan = scan;
    }

    public void addCar() {
        carDAO.insert(eMenu.addCarUi());
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
