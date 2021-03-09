package dealership.service;

import dealership.model.Car;
import dealership.model.Offer;
import dealership.model.Payment;
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
        viewLot();
        carDAO.delete(em.removeCarUi());
    }

    public void viewAllOffers() {
        em.viewOffersUi((Offer[]) offerDAO.getAll());
    }

    public void acceptOffer() {
        viewAllOffers();
        String[] strings = em.acceptOfferUi();
        Offer offer = (Offer) offerDAO.get(strings[0], strings[1]);
        paymentDAO.insert(new Payment(strings[0], Integer.parseInt(strings[1]), offer.getAmount()));
        offerDAO.delete(strings[0], Integer.parseInt(strings[1]));
    }

    public void rejectOffer() {
        viewAllOffers();
        String[] strings = em.rejectOfferUi();
        offerDAO.delete(strings[0], Integer.parseInt(strings[1]));
    }

    public void viewAllPayments() {
        em.viewAllPaymentsUi((Payment[]) paymentDAO.getAll());
    }

    public void resign() {
    }
}
