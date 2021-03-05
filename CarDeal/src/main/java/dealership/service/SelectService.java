package dealership.service;

import dealership.model.User;

public class SelectService {

    public void selectFromString(User user, String service) {

        GeneralService gs = new GeneralService(user);
        CustomerService cs = new CustomerService(user);
        EmployeeService es = new EmployeeService(user);
        SystemService ss = new SystemService(user);


        switch (service) {

            // Default actions
            case "sign out":
                gs.signOut();
                break;

            // Customer actions
            case "view cars on lot":
                cs.viewLot();
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
                es.viewALlPayments();
                break;
            case "resign from dealership":
                es.resign();
                break;

            // System actions
            case "remove all cars from lot":
                ss.removeAllCars();
                break;
            case "reject all pending offers":
                ss.rejectAllOffers();
                break;
            case "calculate monthly payment":
                ss.calculateMonthlyPayment();
                break;

        }
    }
}
