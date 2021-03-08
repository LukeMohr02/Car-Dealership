package dealership.service;

import dealership.model.User;
import dealership.ui.SystemMenu;

import java.util.Scanner;

public class SystemService extends GeneralService {
    SystemMenu sm;

    SystemService(User user, Scanner scan) {
        if (user.getUserType().equals("system")) {
            this.user = user;
        } else {
            this.user = null;
        }

        this.scan = scan;
        sm = new SystemMenu(user, scan);
    }

    public void rejectAllOffers() {
        viewLot();
        offerDAO.delete("%%",sm.rejectOffersUi());
    }

    public void calculateMonthlyPayment() {

    }
}
