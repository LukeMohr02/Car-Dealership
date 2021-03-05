package dealership.service;

import dealership.model.User;

public class EmployeeService extends GeneralService {

    EmployeeService(User user) {
        if (user.getUserType().equals("employee")) {
            this.user = user;
        } else {
            this.user = null;
        }
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
