package dealership.ui;


import dealership.model.Payment;
import dealership.model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

// Displays system-specific menus
// Methods are called by SystemService
public class SystemMenu {
    User user;
    Scanner scan;

    public SystemMenu(User user, Scanner scan) {
        this.user = user;
        this.scan = scan;
    }

    public int rejectOffersUi() {
        System.out.println("Please enter the ID of the car to reject all offers:");
        return scan.nextInt();

    }

    public void monthlyPaymentUi(Payment[] payments) {
        System.out.println("Please enter the <monthly loan amount per car> and <interest rate per loan> (as a percentage):");

        InputMismatchException ime = null;
        double[] userInput = null;
        do {
            try {
                ime = null;
                userInput = new double[]{scan.nextDouble(), scan.nextDouble()};
            } catch (InputMismatchException e) {
                System.out.println("Input not recognized. Please enter two decimal numbers, separated by a space.");
                ime = e;
                scan.next();
            }
        } while (ime != null);

        double loanAmount = userInput[0];
        double interestRate = userInput[1];
        double totalPaymentAmount = 0;
        double maxPayment = 0;
        int    paymentCount = payments.length;

        for (Payment p : payments) {
            double amount = p.getAmount();
            totalPaymentAmount += amount;

            if (amount > maxPayment) {
                maxPayment = amount;
            }
        }

        if (loanAmount > totalPaymentAmount) {
            loanAmount = totalPaymentAmount;
        }

        double totalMonthlyPayment = paymentCount * (loanAmount + (loanAmount * (interestRate / 100)));

//        if (totalMonthlyPayment < loanAmount) {
//            totalMonthlyPayment = loanAmount;
//        }

        double months = maxPayment / loanAmount;

        System.out.println("There are " + paymentCount + " active payments.");
        System.out.println("Their combined total is $" + totalPaymentAmount + ".\n");
        System.out.println("With a monthly loan amount of $" + loanAmount + " per payment and an interest rate of " + interestRate + "%,");
        System.out.println("the total monthly payment is $" + totalMonthlyPayment + ".");
        System.out.println("All loans will be repaid after " + months + " months.\n");
    }

}
