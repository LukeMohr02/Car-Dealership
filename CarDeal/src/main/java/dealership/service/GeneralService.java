package dealership.service;

import dealership.database.DAOFactory;
import dealership.database.GenericDAO;
import dealership.model.Car;
import dealership.model.Payment;
import dealership.model.User;
import dealership.ui.GeneralMenu;

import java.util.Scanner;

public class GeneralService {
    User user;
    Scanner scan;
    GenericDAO carDAO;
    GenericDAO paymentDAO;

    GeneralService() {
        try {
            carDAO = DAOFactory.getDAO(Car.class);
            paymentDAO = DAOFactory.getDAO(Payment.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    GeneralService (User user, Scanner scan) {
        this();
        this.user = user;
        this.scan = scan;
    }

    void signOut() {
        user.setLoggedIn(false);
    }

    public void viewLot() {
        new GeneralMenu(null, scan).viewLot((Car[]) carDAO.getAll());
    }
}
