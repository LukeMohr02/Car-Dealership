package dealership.service;

import dealership.model.User;

import java.util.Scanner;

public class SelectService {

    public void selectFromString(User user, Scanner scan, String service) {
        GeneralService  gs = new GeneralService(user, scan);
        CustomerService cs = new CustomerService(user, scan);
        EmployeeService es = new EmployeeService(user, scan);
        SystemService   ss = new SystemService(user, scan);

        switch (service) {

            // Default actions
            case "view cars on the lot":
                gs.viewLot();
                break;
            case "sign out":
                gs.signOut();
                break;

            // Customer actions
            case "make an offer":
                cs.makeOffer();
                break;
            case "view my cars":
                cs.viewCars();
                break;
            case "view my payments":
                cs.viewPayments();
                break;
            case "apply for work":
                cs.apply();
                break;

            // Employee actions
            case "add car to lot":
                es.addCar();
                break;
            case "remove car from lot":
                es.removeCar();
                break;
            case "accept offer":
                es.acceptOffer();
                break;
            case "reject offer":
                es.rejectOffer();
                break;
            case "view all payments":
                es.viewAllPayments();
                break;
            case "resign from dealership":
                es.resign();
                break;

            // System actions
            case "reject all pending offers":
                ss.rejectAllOffers();
                break;
            case "calculate monthly payment":
                ss.calculateMonthlyPayment();
                break;

        }
    }
}
