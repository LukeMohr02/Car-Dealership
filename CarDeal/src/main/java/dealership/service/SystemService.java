package dealership.service;

import dealership.model.User;

public class SystemService extends GeneralService {

    SystemService(User user) {
        if (user.getUserType().equals("system")) {
            this.user = user;
        } else {
            this.user = null;
        }
    }

    public void removeAllCars() {
    }

    public void rejectAllOffers() {
    }

    public void calculateMonthlyPayment() {
    }
}
