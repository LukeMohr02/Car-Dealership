package dealership.service;

import dealership.model.Car;
import dealership.model.User;
import dealership.ui.CustomerMenu;
import dealership.ui.EmployeeMenu;

import java.util.Scanner;

class EmployeeService extends GeneralService {
    EmployeeMenu em;
    GeneralService gs;

    EmployeeService(User user, Scanner scan) {
        if (user.getUserType().equals("employee")) {
            this.user = user;
        } else {
            this.user = null;
        }

        this.scan = scan;
        em = new EmployeeMenu(scan);
    }

    public void addCar() {
        carDAO.insert(em.addCarUi());
    }

    public Car getCar(int id) {
        return (Car) carDAO.get(id);
    }

    public void removeCar() {
        carDAO.delete(em.removeCarUi(this));
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
